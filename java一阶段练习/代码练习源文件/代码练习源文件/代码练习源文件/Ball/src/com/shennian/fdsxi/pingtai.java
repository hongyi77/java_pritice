package com.shennian.fdsxi;

import java.util.Scanner;

public class pingtai {
    private String username;
    private String password;
    public pingtai(){
    }
    public pingtai(String username,String password){
        this.username = username;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return "账号:"+username+" 密码"+password;
    }
}


