package com.shennian.fdsxi;

/**
 * 教师类
 */
public class teather extends person {
    private String tel;

    public teather() {}

    public teather(String tel) { this.tel = tel; }

    public teather(int id, String name, int age, String grade, String tel) {
        super(id, name, age, grade);
        this.tel = tel;
    }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    @Override
    public String toString() {
        return String.format("%-8d %-10s %-6d %-10s %-15s", getId(), getName(), getAge(), getGrade(), getTel());
    }

    public static String header() {
        return String.format("%-8s %-10s %-6s %-10s %-15s", "工号", "姓名", "年龄", "年级", "电话号码");
    }
}
