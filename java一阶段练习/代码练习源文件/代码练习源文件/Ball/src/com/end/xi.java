package com.end;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class xi {
    static void main(String[] args) {
        ArrayList<student> list = new ArrayList<>();
        ArrayList<user> list1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----欢迎来到学生管理系统----");
        System.out.println(1 + ":登录");
        System.out.println(2 + ":查询");
        System.out.println(3 + ":修改");
        System.out.println(4 + ":删除");
        System.out.println(5 + ":注册");
        System.out.println(6 + ":退出");
        while (true) {
            System.out.println("请输出你要查询的方向");
            int num = scanner.nextInt();
            switch (num) {
                case 1://登录
                   usedeng(list1);
                    break;
                case 2:
                    usecha(list,list1);//查看
                    break;
                case 3:
                    usexiu(list);
                    //System.out.println("修改");
                    break;
                case 4:
                    //System.out.println("删除");
                    useshan(list);
                    break;
                case 5:
                    usezhu(list);//注册
                    break;
                case 6:
                    System.out.println("成功退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入有效数字");
                   break;
            }
        }
    }
    //登录
    public static String usedeng(ArrayList<user> list1){
        user user = new user();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入账号（帐号长度需要大于6并且小于15）");
            String username = sc.next();
           if (username.length()>6&&username.length()<15&&!username.matches(".*[a-zA-Z].*")){
               user.setUsername(username);
               break;
           }else {
               System.out.println("账号长度或输入格式不规范，请重新输入");
           }
        }
        while (true) {
            System.out.println("请输入密码");
            String passworld = sc.next();
            if (passworld.length()>6&&passworld.length()<15&&passworld.matches(".*[a-zA-Z].*")){
                user.setPassworld(passworld);
                break;
            }else {
                System.out.println("密码长度不规范，请重新输入");
            }
        }
        list1.add(user);
        System.out.println("成功录入");
        return "";
    }
    public static String usecha(ArrayList<student> list,ArrayList<user> list1){//查看
        if (list1 == null ||list1.size()==0){
            System.out.println("用户信息不完整，拒绝访问");
            return "";
        }
        usedeng(list1);
        user admin = list1.get(0);
        user admin1 = list1.get(1);
        boolean isout = admin.getUsername().equals(admin1.getUsername())&&admin.getPassworld().equals(admin1.getPassworld());
        if (isout){
            System.out.println("欢迎你，尊贵的管理员大人");
        }else{
            System.out.println("检测到xi有人入侵，马上拨打110，且关机电脑");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 5");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (list.size()<=0){
            System.out.println("暂无学生信息,请先添加");//登录
            return "";
        }else {
            for (int i = 0; i < list.size() ; i++) {
                System.out.println(list.get(i));
            }
        }
        return "";
    }
    public static String usexiu(ArrayList<student>list){//修改
       Scanner scanner = new Scanner(System.in);
       student student  = new student();
        System.out.println("请输入你想修改学生的id");
        String id = scanner.next();
        if (id(list,id)>0){
            System.out.println("请输入新的信息");
           student.setId(id);
            System.out.println("请输入姓名:");
            String name = scanner.next();
            student.setName(name);
            while (true) {
                System.out.println("请输入年龄:");
                int age = scanner.nextInt();
                if (age < 0 || age > 150) {
                    System.out.println("输入的数据异常，请重新输入");
                    continue;
                }else {
                    student.setAge(age);
                    break;
                }
            }
            while (true) {
                System.out.println("请输入家庭住址：");
                String address = scanner.next();
                if (address.length()>15){
                    System.out.println("请正确规范的输入");
                    continue;
                }else {
                    student.setAddress(address);
                    break;
                }
            }
            while (true){
                System.out.println("请输入你的电子邮件");
                String email = scanner.next();
                if (email.contains("@qq.com")&&email.length()>8){
                    student.setEmail(email);
                    System.out.println();
                    break;
                } else  {
                    System.out.println("请规范输入你的电子邮箱");
                    continue;
                }
            }
            list.set(id(list,id)-1,student);
            System.out.println("修改成功");
        }else {
            System.out.println("不存在该id的学生");
        }
        return "";
    }
    public static String useshan(ArrayList<student> list){
        student student = new student();//删除
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择您要删除的学生id");
        String id = scanner.next();
        if (id(list,id)>0){
            System.out.println("正在为您删除id为"+id(list,id)+"的学生");
            list.remove(id(list,id)-1);
            System.out.println("删除成功");
        }else {
            System.out.println("该学生不存在，请先添加或删除id存在的学生");
        }

        return "";
    }
    public static String usezhu(ArrayList<student> list){//注册
        while (true) {
            Scanner scanner = new Scanner(System.in);
            student student = new student();
            System.out.println("请输入id:");
            String id = scanner.next();
            student.setId(id);
            boolean isout = isout(list,id);
            if (isout){
                System.out.println("id重复,请重新输入");
                continue;
            }
            System.out.println("请输入姓名:");
            String name = scanner.next();
            student.setName(name);
            while (true) {
                System.out.println("请输入年龄:");
                int age = scanner.nextInt();
                if (age < 0 || age > 150) {
                    System.out.println("输入的数据异常，请重新输入");
                    continue;
                }else {
                    student.setAge(age);
                    break;
                }
            }
            while (true) {
                System.out.println("请输入家庭住址：");
                String address = scanner.next();
                if (address.length()>15){
                    System.out.println("请正确规范的输入");
                    continue;
                }else {
                    student.setAddress(address);
                    break;
                }
            }
            while (true){
                System.out.println("请输入你的电子邮件");
                String email = scanner.next();
                if (email.contains("@qq.com")&&email.length()>8){
                    student.setEmail(email);
                    System.out.println();
                    break;
                } else  {
                    System.out.println("请规范输入你的电子邮箱");
                    continue;
                }
            }
            list.add(student);
            System.out.println("注册成功");
            return "";
        }
    }
   public static boolean isout(ArrayList<student> list,String id){//判断是否id重复

       return id(list,id)>0;
   }
   public static int id(ArrayList<student> list,String id){
       for (int i = 0; i < list.size() ; i++) {
           student student = list.get(i);
           String getid = student.getId();
           if (getid.equals(id)){
               return i+1;
           }
       }
        return -1;
   }
   /*public static boolean istrue(ArrayList<student>list,student student){
        Scanner scanner = new Scanner(System.in);
       System.out.println("请选择你的id");
       String id = scanner.next();
       if (id.equals(student.getId())){
           System.out.println();
       }else {
           System.out.println("不存在这个id");
           return false;
       }
       System.out.println("请输入你的电子邮件：");
       String email = scanner.next();
       String email1 = student.getEmail();
       if (email1.equals(email)){
           System.out.println("请输入你的新密码");
       }
       return true;
   }*/
}
