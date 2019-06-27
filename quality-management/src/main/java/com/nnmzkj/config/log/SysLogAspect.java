package com.nnmzkj.config.log;


import com.nnmzkj.common.utils.IpUtils;
import com.nnmzkj.model.SystemLog;
import com.nnmzkj.service.SystemLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SystemLogService systemLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.nnmzkj.config.log.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {

        //保存日志
        SystemLog systemLog = new SystemLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            systemLog.setPage(value);
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();

        systemLog.setAddTime(new Date());
        //获取用户名
       // sysLog.setUsername(ShiroUtils.getUserEntity().getUsername());
        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        systemLog.setIp(IpUtils.getIpAddr(request));
        String url = request.getRequestURL().toString();
        systemLog.setPath(url);
        systemLog.setAdminName("测试admin");
        //调用service保存SysLog实体类到数据库
        systemLogService.save(systemLog);
    }
}
