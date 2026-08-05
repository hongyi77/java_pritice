package com.shennian.fdsxi;

import java.util.List;

/**
 * 人员基类（学生、老师、管理员都继承此类）
 */
public abstract class person {
    private int id;
    private String name;
    private int age;
    private String grade;
    /** 绑定的登录账号名 */
    private String username;
    /** 个人信息是否已录入（只能录入一次） */
    protected boolean infoFilled = false;

    public person() {}

    public person(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getId() { return id; }
    public void setid(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    /** 标记个人信息已录入 */
    public void fillInfo() { this.infoFilled = true; }

    /** 格式化输出个人信息（子类可重写） */
    @Override
    public String toString() {
        return String.format("%-8d %-10s %-6d %-10s", id, name, age, grade);
    }

    /** 表头 */
    public static String header() {
        return String.format("%-8s %-10s %-6s %-10s", "编号", "姓名", "年龄", "班级");
    }

    /** 批量查询所有人员 */
    public void chaall(List<person> list) {
        if (list.isEmpty()) {
            System.out.println("暂无人员信息");
            return;
        }
        System.out.println(header());
        System.out.println("------------------------------------------------------------");
        for (person p : list) {
            System.out.println(p);
        }
    }
}
