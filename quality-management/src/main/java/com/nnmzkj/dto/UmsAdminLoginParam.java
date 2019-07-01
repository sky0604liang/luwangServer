package com.nnmzkj.dto;


import java.io.Serializable;

public class UmsAdminLoginParam implements Serializable {

    private static final long serialVersionUID = -2863564931555120541L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
