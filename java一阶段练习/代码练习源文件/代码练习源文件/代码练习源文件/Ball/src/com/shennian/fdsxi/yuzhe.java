package com.shennian.fdsxi;

/**
 * 管理员类
 * 固定账号: admin / 123456
 */
public class yuzhe extends pingtai {
    public yuzhe() {
        setUsername("admin");
        setPassword("123456");
    }

    public yuzhe(String username, String password) {
        super(username, password);
    }
}
