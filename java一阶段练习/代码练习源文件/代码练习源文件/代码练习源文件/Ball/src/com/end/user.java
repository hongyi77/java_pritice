package com.end;

public class user {
    String username;
    String passworld;

    public user() {
    }

    public user(String username, String passworld) {
        this.username = username;
        this.passworld = passworld;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    @Override
    public String toString() {
        System.out.println("账号"+username);
        System.out.println("密码"+passworld);
        return "";
    }
}
