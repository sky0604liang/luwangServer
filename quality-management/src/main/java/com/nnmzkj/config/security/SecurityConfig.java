package com.nnmzkj.config.security;


import com.nnmzkj.config.jwt.JwtAuthenticationTokenFilter;
import com.nnmzkj.config.jwt.RestAuthenticationEntryPoint;
import com.nnmzkj.config.jwt.RestfulAccessDeniedHandler;
import com.nnmzkj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
   @Autowired
   private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

   @Autowired
   private AdminService adminService;

   //用于配置需要拦截的url路径、jwt过滤器及出异常后的处理器；
   @Override
   protected void configure(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.csrf() //使用jwt，不需要csrf
      .disable()
      .sessionManagement()// 使用jwt，不需要session管理
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and() //配置其他属性
      .authorizeRequests() //配置授权请求
      .antMatchers(HttpMethod.GET, //允许对于网站静态资源无授权访问
              "/",
              "/*.html",
              "/favicon.ico",
              "/**/*.html",
              "/**/*.css",
              "/**/*.js"
      )
      .permitAll() //放行
      .antMatchers("/user/login","/user/register") //对登陆注册允许访问
      .permitAll()
      .antMatchers(HttpMethod.OPTIONS) //跨域请求会先进行一次options请求
      .permitAll()
      .anyRequest() //除了以上配置信息，其余都要全部认证与授权
      .authenticated();
      //禁用缓存
      httpSecurity.headers().cacheControl();
      // 添加jwt 认证token拦截器
      httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
      //添加自定义未授权和未登录结果返回
      httpSecurity.exceptionHandling().
                      accessDeniedHandler(restfulAccessDeniedHandler)
                      .authenticationEntryPoint(restAuthenticationEntryPoint);
   }

   //用于配置UserDetailsService及PasswordEncoder；
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService())
              .passwordEncoder(passwordEncoder());
   }

   //SpringSecurity定义的用于对密码进行编码及比对的接口，目前使用的是BCryptPasswordEncoder；
   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }


  // SpringSecurity定义的核心接口，用于根据用户名获取用户信息，需要自行实现；
//   @Bean
//   public UserDetailsService userDetailsService() {
//      //获取登录用户信息
//      return username -> {
//         SysUser admin = adminService.getAdminByUsername(username);
//         if (admin != null) {
//             //判断该用户当前状态
//             if (admin.getStatus() != 1){
//                 //抛出用户异常信息
//             }
//            //获取用户对应的所有权限
//            List<SysMenu> permissionList = adminService.getPermissionList(admin.getUserId());
//            return new AdminUserDetails(admin,permissionList);
//         }
//         throw new UsernameNotFoundException("用户名或密码错误");
//      };
//   }

   //在用户名和密码校验前添加的过滤器，如果有jwt的token，会自行根据token信息进行登录。
   @Bean
   public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
      return  new JwtAuthenticationTokenFilter();
   }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
