package com.异常;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class throwabledemo2 {
    public static void main(String[] args) {
        int i = 0;
        List<student> list = new ArrayList<>();
        // Scanner 只需创建一个，重复创建浪费资源
        Scanner scanner = new Scanner(System.in);
        while (true) {
            student student = new student();

            try {
                System.out.println("请输入姓名");
                String name = scanner.nextLine();
                student.setName(name);
                System.out.println("请输入年龄");
                int age = getIntInput(scanner);
                student.setAge(age);
                // Collections.addAll 适合批量添加，单个元素用 list.add 更直观
                list.add(student);
                i++;
                if (i > 3) {
                    // Comparator.comparing 提取 age 字段做比较，比直接引用实例方法更清晰
                    list.stream()
                            .sorted(student::compareToStatic)
                            .forEach(s -> System.out.println(s));
                    break;
                }
            } catch (nameException e) {
                e.printStackTrace();
            } catch (ageException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("输入无效，只能输入数字: ");
            // next() 消耗掉非整数 token，防止死循环
            sc.next();
        }
        // 修复：nextInt() 不消耗换行符，后续 nextLine() 会读到空字符串
        // 所以这里用 sc.nextLine() 再解析，避免换行符残留问题
        int val;
        try {
            val = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("输入无效，只能输入数字: ");
            return getIntInput(sc);
        }
        return val;
    }
}
