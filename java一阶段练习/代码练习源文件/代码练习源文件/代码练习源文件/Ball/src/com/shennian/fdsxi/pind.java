package com.shennian.fdsxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 学生管理系统主程序
 * 角色：老师(teather)、学生(student)、管理员(yuzhe)
 */
public class pind {

    // ==================== 管理员常量 ====================
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "123456";

    // ==================== 主入口 ====================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 老师账号列表（存登录凭证）
        List<pingtai> teacherAccounts = new ArrayList<>();
        // 学生账号列表（存登录凭证）
        List<pingtai> studentAccounts = new ArrayList<>();
        // 所有人员信息（老师+学生）
        List<person> allPeople = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("========== 学生管理系统 ==========");
            System.out.println("  1. 老师登录/注册");
            System.out.println("  2. 学生登录/注册");
            System.out.println("  3. 管理员登录");
            System.out.println("  4. 退出系统");
            System.out.println("==================================");
            System.out.print("请选择: ");

            int choice = getIntInput(sc);
            switch (choice) {
                case 1:
                    runRoleMenu(sc, teacherAccounts, allPeople, 1);
                    break;
                case 2:
                    runRoleMenu(sc, studentAccounts, allPeople, 2);
                    break;
                case 3:
                    runAdminLogin(sc, allPeople);
                    break;
                case 4:
                    running = false;
                    System.out.println("感谢使用，再见！");
                    break;
                default:
                    System.out.println("请输入有效数字 (1-4)");
            }
        }

        sc.close();
    }

    // ==================== 角色菜单（老师/学生） ====================
    private static void runRoleMenu(Scanner sc,
                                    List<pingtai> roleAccounts,
                                    List<person> allPeople,
                                    int roleType) {
        String roleName = (roleType == 1) ? "教师" : "学生";

        while (true) {
            System.out.println("--- " + roleName + "系统 ---");
            System.out.println("  1. 登录");
            System.out.println("  2. 注册");
            System.out.println("  3. 返回主菜单");
            System.out.print("请选择: ");

            int choice = getIntInput(sc);
            switch (choice) {
                case 1:
                    // 登录：先验证账号密码，再返回 person 对象
                    person loggedIn = login(sc, roleAccounts, allPeople);
                    if (loggedIn != null) {
                        runPersonMenu(sc, loggedIn, allPeople, roleType);
                    }
                    break;
                case 2:
                    register(sc, roleAccounts, allPeople, roleType);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("请输入有效数字 (1-3)");
            }
        }
    }

    // ==================== 注册 ====================
    private static void register(Scanner sc, List<pingtai> roleAccounts,
                                  List<person> allPeople, int roleType) {
        // 1. 注册账号（username + password）
        String username = registerAccount(sc, roleAccounts);
        if (username == null) return;

        // 2. 检查该账号是否已录入过个人信息
        person existing = findPersonByUsername(allPeople, username);
        if (existing != null && existing.infoFilled) {
            System.out.println("该账号已录入过个人信息，无法重复录入。");
            return;
        }

        // 3. 录入个人信息
       person p = createPerson(sc, roleType);
        if (p == null) return;

        // 绑定账号名并标记已录入
        p.setUsername(username);
        p.fillInfo();
        allPeople.add(p);

        System.out.println("注册成功！账号: " + username);
        System.out.println("请登录使用。");
    }

    /**
     * 注册账号（用户名+密码），返回 username，失败返回 null
     */
    private static String registerAccount(Scanner sc, List<pingtai> roleAccounts) {
        System.out.println("--- 注册账号 ---");
        String username = getValidUsername(sc);
        if (username == null) return null;

        // 检查账号是否已存在
        for (pingtai acc : roleAccounts) {
            if (acc.getUsername().equals(username)) {
                System.out.println("账号已存在，请直接登录");
                return null;
            }
        }

        String password = getValidPassword(sc);
        if (password == null) return null;

        // 创建账号
        pingtai account = (roleAccounts instanceof ArrayList)
                ? new tepingtai(username, password)
                : new stpingtai(username, password);
        roleAccounts.add(account);

        System.out.println("账号注册成功，请录入个人信息。");
        return username;
    }

    /**
     * 获取合法用户名（6-14位纯数字）
     */
    private static String getValidUsername(Scanner sc) {
        while (true) {
            System.out.print("请输入账号 (6-14位数字): ");
            String input = sc.next();
            if (input.length() >= 6 && input.length() <= 14 && input.matches("\\d+")) {
                return input;
            }
            System.out.println("格式错误，请输入6-14位纯数字");
        }
    }//账号的逻辑

    /**
     * 获取合法密码（6-14位，至少含字母）
     */
    private static String getValidPassword(Scanner sc) {
        while (true) {
            System.out.print("请输入密码 (6-14位，至少含字母): ");
            String pwd = sc.next();
            if (pwd.length() >= 6 && pwd.length() <= 14 && pwd.matches(".*[a-zA-Z].*")) {
                System.out.print("请再次输入密码确认: ");
                String pwd2 = sc.next();
                if (pwd.equals(pwd2)) {
                    return pwd;
                }
                System.out.println("两次密码不一致，请重新输入");
            } else {
                System.out.println("格式错误，长度需6-14位且至少含一种字母");
            }
        }
    }//密码逻辑

    /**
     * 创建人员对象（录入个人信息）
     */
    private static person createPerson(Scanner sc, int roleType) {
        System.out.println("--- 录入个人信息 ---");

        System.out.print((roleType == 1) ? "请输入工号: " : "请输入学号: ");
        int id = getIntInput(sc);

        System.out.print("请输入姓名: ");
        String name = sc.next();

        System.out.print("请输入年龄: ");
        int age = getIntInput(sc);

        System.out.print("请输入班级/年级: ");
        String grade = sc.next();

        person p;
        if (roleType == 1) {
            System.out.print("请输入电话号码: ");
            String tel = sc.next();
            p = new teather(id, name, age, grade, tel);
        } else {
            p = new student(id, name, age, grade);
        }

        return p;
    }

    // ==================== 登录 ====================
    /**
     * 登录验证：检查账号密码，找到并返回对应的 person 对象
     * 登录成功返回 person，否则返回 null
     */
    private static person login(Scanner sc, List<pingtai> roleAccounts,
                                 List<person> allPeople) {
        if (roleAccounts.isEmpty()) {
            System.out.println("暂无账号，请先注册");
            return null;
        }

        System.out.print("请输入账号: ");
        String username = sc.next();
        System.out.print("请输入密码: ");
        String password = sc.next();

        // 1. 验证账号密码
        pingtai matched = null;
        for (pingtai acc : roleAccounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                matched = acc;
                break;
            }
        }

        if (matched == null) {
            System.out.println("账号或密码错误");
            return null;
        }

        // 2. 通过 username 查找对应的 person
        person p = findPersonByUsername(allPeople, username);
        if (p == null) {
            System.out.println("未找到个人信息，请重新注册");
            return null;
        }

        System.out.println("登录成功！欢迎, " + p.getName());
        return p;
    }

    /**
     * 通过 username 在所有人员中精确查找 person
     */
    private static person findPersonByUsername(List<person> allPeople, String username) {
        for (person p : allPeople) {
            if (username.equals(p.getUsername())) {
                return p;
            }
        }
        return null;
    }

    // ==================== 个人信息菜单 ====================
    private static void runPersonMenu(Scanner sc, person loggedInPerson,
                                       List<person> allPeople, int roleType) {
        while (true) {
            System.out.println("--- " + loggedInPerson.getName() + " 的个人中心 ---");

            if (!loggedInPerson.infoFilled) {
                System.out.println("  1. 录入个人信息");
            }
            System.out.println("  2. 查看个人信息");
            System.out.println("  3. 修改个人信息");
            System.out.println("  4. 退出登录");
            System.out.print("请选择: ");

            int choice = getIntInput(sc);
            switch (choice) {
                case 1:
                    // 只能录入一次
                    if (loggedInPerson.infoFilled) {
                        System.out.println("个人信息已录入，无法重复录入");
                    } else {
                        person updated = createPerson(sc, roleType);
                        if (updated != null) {
                            // 更新已有 person 的信息
                            loggedInPerson.setid(updated.getId());
                            loggedInPerson.setName(updated.getName());
                            loggedInPerson.setAge(updated.getAge());
                            loggedInPerson.setGrade(updated.getGrade());
                            if (loggedInPerson instanceof teather && updated instanceof teather) {
                                ((teather) loggedInPerson).setTel(((teather) updated).getTel());
                            }
                            loggedInPerson.fillInfo();
                            System.out.println("信息录入成功！");
                        }
                    }
                    break;
                case 2:
                    System.out.println("您的信息：");
                    if (roleType==1){
                        System.out.println(teather.header());
                        System.out.println(loggedInPerson);
                    }else {
                        System.out.println(student.header());
                        System.out.println(loggedInPerson);
                    }

                    break;
                case 3:
                    modifyPerson(sc, loggedInPerson);
                    break;
                case 4:
                    System.out.println("已退出登录");
                    return;
                default:
                    System.out.println("请输入有效数字 (1-4)");
            }
        }
    }

    // ==================== 修改个人信息 ====================
    private static void modifyPerson(Scanner sc, person p) {
        System.out.println("--- 修改个人信息 ---");
        System.out.println("注意：编号/学号/工号不可修改");

        System.out.print("新姓名: ");
        p.setName(sc.next());

        System.out.print("新年龄: ");
        p.setAge(getIntInput(sc));

        System.out.print("新班级/年级: ");
        p.setGrade(sc.next());

        if (p instanceof teather) {
            System.out.print("新电话号码: ");
            ((teather) p).setTel(sc.next());
        }

        System.out.println("修改成功！");
    }

    // ==================== 管理员 ====================
    private static void runAdminLogin(Scanner sc, List<person> allPeople) {
        System.out.print("请输入管理员账号: ");
        String username = sc.next();
        System.out.print("请输入管理员密码: ");
        String password = sc.next();

        if (!ADMIN_USERNAME.equals(username) || !ADMIN_PASSWORD.equals(password)) {
            System.out.println("管理员账号或密码错误");
            return;
        }

        System.out.println("管理员登录成功！");
        runAdminMenu(sc, allPeople);
    }

    private static void runAdminMenu(Scanner sc, List<person> allPeople) {
        while (true) {
            System.out.println("--- 管理员菜单 ---");
            System.out.println("  1. 查看所有人员");
            System.out.println("  2. 删除人员");
            System.out.println("  3. 修改人员信息");
            System.out.println("  4. 返回主菜单");
            System.out.print("请选择: ");

            int choice = getIntInput(sc);
            switch (choice) {
                case 1:
                    showAllPeople(allPeople);
                    break;
                case 2:
                    deletePerson(sc, allPeople);
                    break;
                case 3:
                    adminModifyPerson(sc, allPeople);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("请输入有效数字 (1-4)");
            }
        }
    }

    private static void showAllPeople(List<person> allPeople) {
        if (allPeople.isEmpty()) {
            System.out.println("暂无人员信息");
            return;
        }

        System.out.println("====== 所有人员列表 ======");
        System.out.println("[老师]");
        System.out.println(teather.header());
        for (person p : allPeople) {
            if (p instanceof teather) {
                System.out.println(p);
            }
        }
        System.out.println("\n[学生]");
        System.out.println(teather.header());
        for (person p : allPeople) {
            if (p instanceof student) {
                System.out.println(p);
            }
        }
    }

    private static void deletePerson(Scanner sc, List<person> allPeople) {
        if (allPeople.isEmpty()) {
            System.out.println("暂无人员信息");
            return;
        }

        System.out.print("请输入要删除的人员编号: ");
        int id = getIntInput(sc);

        int idx = findPersonIndexById(allPeople, id);
        if (idx >= 0) {
            person removed = allPeople.remove(idx);
            System.out.println("已删除: " + removed.getName());
        } else {
            System.out.println("未找到该编号的人员");
        }
    }

    private static void adminModifyPerson(Scanner sc, List<person> allPeople) {
        if (allPeople.isEmpty()) {
            System.out.println("暂无人员信息");
            return;
        }

        System.out.print("请输入要修改的人员编号: ");
        int id = getIntInput(sc);

        int idx = findPersonIndexById(allPeople, id);
        if (idx < 0) {
            System.out.println("未找到该编号的人员");
            return;
        }

        person p = allPeople.get(idx);
        System.out.println("当前信息: " + p);
        modifyPerson(sc, p);
        allPeople.set(idx, p);
    }

    // ==================== 工具方法 ====================
    private static int findPersonIndexById(List<person> allPeople, int id) {
        for (int i = 0; i < allPeople.size(); i++) {
            if (allPeople.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 安全获取整数输入
     */
    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("输入无效，请输入数字: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
