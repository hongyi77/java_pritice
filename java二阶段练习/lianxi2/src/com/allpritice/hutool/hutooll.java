package com.allpritice.hutool;

import cn.hutool.http.HttpUtil;

public class hutooll {
    public static void main(String[] args) {
        String s = HttpUtil.get("https://dow.lzdown28.com/20250820/1022_b46ecb95/%E5%9D%8F%E8%9B%8B%E8%81%94%E7%9B%9F2%20The%20Bad%20Guys%202%20(2025).mp4");
        System.out.println(s.length());
    }
}
