package com.nnmzkj.service.impl;


import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.common.utils.IpUtils;
import com.nnmzkj.common.utils.JwtTokenUtil;
import com.nnmzkj.dao.SysUserMapper;
import com.nnmzkj.dao.SystemLogMapper;
import com.nnmzkj.dto.AdminUserDetails;
import com.nnmzkj.model.SysMenu;
import com.nnmzkj.model.SysUser;
import com.nnmzkj.model.SystemLog;
import com.nnmzkj.service.AdminService;
import com.nnmzkj.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {
//    @Autowired
//    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private SysUserMapper adminMapper;

    @Autowired
    private SystemLogMapper systemLogMapper;





    /**
     * 1.不能存在相同的用户名
     * 2.获取所有角色
     * 2.加密存储
     * @param
     * @return
     */
    @Override
    public void register(SysUser umsAdminParam) {
          int status = adminMapper.checkAdmin(umsAdminParam.getUsername());
          if (status > 0){
              //存在相同名称的用户
              throw new QualityManagementException(QualityManagementExceptionCode.HAVE_IDENTICAL_USER);
          }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdminParam.getPassword());
        umsAdminParam.setPassword(encodePassword);
        umsAdminParam.setGmtCreate(new Date());
        adminMapper.insertSelective(umsAdminParam);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (StringUtils.isEmpty(userDetails)){
                //不存在这个账户
                throw new QualityManagementException(QualityManagementExceptionCode.USER_NAME_IS_NULL);
            }
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                //密码错误
                throw new QualityManagementException(QualityManagementExceptionCode.PASSWORD_IS_ERROR);
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            //登陆成功,获取用户完整信息
           Long userId = adminMapper.getUserInfo(username);
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ipAddr = IpUtils.getIpAddr(request);
            String loginPath="http://"+ ipAddr +"/user/login";
            SystemLog systemLog = new SystemLog(userId,username,"账户登录",loginPath,ipAddr,new Date());
            systemLogMapper.insertSelective(systemLog);
        } catch (AuthenticationException e) {
        }
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = adminMapper.getAdminByUserName(userName);
        UserDetails userDetails = null;
        if (sysUser != null){
            if (sysUser.getStatus() != 1){
                //判断用户是否正常
                throw new QualityManagementException(QualityManagementExceptionCode.USER_NAME_EXCEPTION);
            }
            //加载用户对用的权限
            List<SysMenu> permissionList = adminMapper.getPermissionList(sysUser.getUserId());
            userDetails = new AdminUserDetails(sysUser,permissionList);
            return userDetails;
        }
        return null;
    }
}
