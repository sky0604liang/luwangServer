package com.nnmzkj.dto;

import com.nnmzkj.model.SysMenu;
import com.nnmzkj.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SpringSecurity需要的用户详情
 * SpringSecurity定义用于封装用户信息的类（主要是用户信息和权限），需要自行实现；
 * Created by macro on 2018/4/26.
 */
public class AdminUserDetails implements Serializable, UserDetails {
    private static final long serialVersionUID = 7453283853342403678L;

    private SysUser umsAdmin;
    private List<SysMenu> permissionList;


    public AdminUserDetails(SysUser umsAdmin, List<SysMenu> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }

    /**
     * 获取用户所有权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        System.out.println(permissionList.size()+"!!!!!!!!!");
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        for (SysMenu sysMenu : permissionList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysMenu.getUrl());
            auths.add(grantedAuthority);
        }
        return  auths;
//        return permissionList.stream()
//                .filter(permission -> permission.getPerms()!=null)
//                .map(permission ->new SimpleGrantedAuthority(permission.getPerms()))
//                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }


    /**
     * 账号是否异常
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否被锁住
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否能启用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }

    public SysUser getUmsAdmin() {
        return umsAdmin;
    }

    public void setUmsAdmin(SysUser umsAdmin) {
        this.umsAdmin = umsAdmin;
    }

    public List<SysMenu> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysMenu> permissionList) {
        this.permissionList = permissionList;
    }


}
