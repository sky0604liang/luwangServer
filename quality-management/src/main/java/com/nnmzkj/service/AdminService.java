package com.nnmzkj.service;


import com.nnmzkj.model.SysUser;


public interface AdminService {


    void register(SysUser umsAdminParam);

    String login(String username, String password);
}
