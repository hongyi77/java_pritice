package com.异常;

// Exception 拼写有误，原类名 demo2Exceotion 保留兼容性
// 建议后续统一重命名为 demo2Exception
public class demo2Exceotion extends RuntimeException {
    // RuntimeException 是未检查异常（unchecked exception）
    // 调用方不需要强制 catch，适合业务校验场景

    public demo2Exceotion() {
    }

    public demo2Exceotion(String message) {
        super(message);
    }
}
