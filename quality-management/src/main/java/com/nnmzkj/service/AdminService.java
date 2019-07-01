package com.nnmzkj.service;


import com.nnmzkj.model.SysUser;

import javax.servlet.http.HttpServletRequest;


public interface AdminService {


    void register(SysUser umsAdminParam);

    String login(String username, String password);

    void logout(HttpServletRequest request);
}
