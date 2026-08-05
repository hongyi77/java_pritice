package com.io_pritice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class kaobeiio4 {
    public static void main(String[] args) throws IOException {

        // ========== 第一步：读取打乱的文章行 ==========
        BufferedReader br = new BufferedReader(new FileReader(
                "D:\\githup仓库\\java二阶段练习\\lianxi2\\dd.txt"));

        // br: 缓冲读取器，从文件逐行读取数据，比直接读File效率高
        // dd.txt: 包含被打乱顺序的出师表片段，每行最前面有"序号."的格式

        // list: 用ArrayList存储每一行的文本内容
        ArrayList<String> list = new ArrayList<>();

        // try-with-resources: 自动关闭资源，即使发生异常也会关闭br
        try (br) {
            String line; // line: 临时变量，存储每一行读到的文本
            while ((line = br.readLine()) != null) {
                // readLine(): 读取一行文本，读到末尾返回null
                // 循环把所有行都读进list中
                list.add(line);
            }
        }
        // try块结束后，br会自动关闭，不需要手动调用br.close()

        System.out.println("=== 排序前（共 " + list.size() + " 行）===");
        for (String s : list) {
            System.out.println(s);
        }

        // ========== 第二步：按行首的数字序号排序 ==========
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // compare方法: 比较两行o1和o2的顺序
                // 返回值 < 0: o1排在o2前面
                // 返回值 > 0: o2排在o1前面
                // 返回值 = 0: 两者相等

                // split("\\."): 以点号分割字符串，返回字符串数组
                // 例如 "17.遇，欲报之于陛下也..." 分割后得到 ["17", "遇，欲报..."]
                // [0]: 取数组的第一个元素，即序号部分
                String num1 = o1.split("\\.")[0];   // 取出o1的序号字符串，如"17"
                String num2 = o2.split("\\.")[0];   // 取出o2的序号字符串，如"1"

                // Integer.parseInt(): 把字符串转换成整数
                // "17" -> 17, "1" -> 1
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);

                // n1 - n2: 升序排序
                // 如果n1 < n2，结果为负数，n1排在前面
                // 如果n1 > n2，结果为正数，n2排在前面
                return n1 - n2;
            }
        });

        System.out.println("\n=== 排序后 ===");
        for (String s : list) {
            System.out.println(s);
        }

        // ========== 第三步：将排序后的内容写入新文件 ==========
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "D:\\githup仓库\\java二阶段练习\\lianxi2\\b.txt"));
        // bw: 缓冲写入器，逐行写入数据到b.txt文件

        for (String str : list) {
            bw.write(str);   // 写入当前行的文本内容
            bw.newLine();    // 写入一个换行符（跨平台兼容）
        }

        bw.close(); // 关闭写入器，确保数据全部刷新到文件中
        System.out.println("\n排序完成！结果已保存到 b.txt");
    }
}
