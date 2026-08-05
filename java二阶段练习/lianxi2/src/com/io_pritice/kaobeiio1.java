package com.io_pritice;

import java.io.*;
import java.nio.file.*;

/*
 * BufferedInputStream / BufferedOutputStream 用法详解
 *
 * 核心概念：
 * 1. 缓冲流不是直接操作文件，而是"包装"其他流，在内存中开辟一块缓冲区（默认8192字节=8KB）
 * 2. 读的时候：一次性从磁盘读8KB到缓冲区，后续read()直接从内存取，减少磁盘IO次数
 * 3. 写的时候：数据先写到缓冲区，缓冲区满了再一次性刷到磁盘，减少磁盘IO次数
 * 4. 必须手动close（或用try-with-resources），否则缓冲区残留数据会丢失！
 */

//此类对比了三种有效的方法
//字节搬运流***缓冲流***字节流
public class kaobeiio1 {

    public static void main(String[] args) throws IOException {
        // ========== 演示1：用缓冲流拷贝文件 ==========
        System.out.println("=== 演示1：缓冲流拷贝文件 ===");
        copyWithBuffered();

        // ========== 演示2：对比普通流 vs 缓冲流的写法 ==========
        /*System.out.println("\n=== 演示2：字节流拷贝文件（逐字节读写）===");
        copyWithByteStream();               */

        // ========== 演示3：字节流 + 数组读写（对比缓冲流）==========
        System.out.println("\n=== 演示3：字节流 + 数组批量读写 ===");
        copyWithArray();

        // 清理
        Files.deleteIfExists(Path.of("large_src.txt"));
        Files.deleteIfExists(Path.of("large_dest_buf.txt"));
        Files.deleteIfExists(Path.of("large_dest_byte.txt"));
        Files.deleteIfExists(Path.of("large_dest_arr.txt"));

        // test_data.txt 实际在 src/com/io_pritice/ 下，用相对工作目录拼接
        Path testFile = Path.of("src", "com", "io_pritice", "test_data.txt");
        if (Files.exists(testFile)) {
            try {
                Files.delete(testFile);
                System.out.println("已删除: " + testFile.toAbsolutePath());
            } catch (IOException e) {
                System.out.println("删除失败 - 文件可能被其他程序占用: " + e.getLocalizedMessage());
            }
        } else {
            System.out.println("找不到文件: " + testFile.toAbsolutePath());
        }

        System.out.println("\n演示文件已清理");
    }

    /**
     * 演示1：缓冲流拷贝（推荐用法）
     * 特点：内部有8KB缓冲区 + 外部byte[]数组批量搬运
     */
    public static void copyWithBuffered() throws IOException {
        String src = "large_src.txt";
        String dest = "large_dest_buf.txt";

        // 先生成大文件（约500KB），放在计时外面
        System.out.println("正在生成测试文件...");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            sb.append("这是第").append(i).append("行测试数据：数据库的哈师大数据库的看哈数据库大厦卡卡和大数据快点哈数据库的哈数据库还记得沙坑里的哈啥是快递很快撒谎的萨科还记得刷卡机等哈设计的哈师大凯撒好的话哈斯金打卡萨很多机会和大家撒谎多久啊是的猎杀等哈稍等哈时间等哈数据库的沙龙的哈数据库的哈萨克就就撒谎大哭等哈是大家坷拉哈萨克还打算科技大厦贷记卡是快乐的哈卡斯领导黄金大劫案是大航海时代和环境大家快来。\n");
        }
        Files.writeString(Path.of(src), sb.toString());
        long fileSize = Files.size(Path.of(src));
        System.out.println("测试文件大小: " + fileSize + " 字节 (" + String.format("%.2f", fileSize / 1024.0) + " KB)");

        // 只计时拷贝部分
        long start = System.currentTimeMillis();
        int count = 0;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[1024]; // 自己定义一个搬运缓冲区，1KB
            int len;

            // read() 返回实际读取的字节数，读到末尾返回-1
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                count++;
            }
        }
        // 退出try块时，bis和bos自动close，bos缓冲区残留数据会在close时先flush再关
        long end = System.currentTimeMillis();

        System.out.println("缓冲流拷贝完成！");
        System.out.println("  耗时: " + (end - start) + " ms");
        System.out.println("  搬运次数: " + count + " 次");
        System.out.println("  拷贝后文件大小: " + Files.size(Path.of(dest)) + " 字节");
    }

    /**
     * 演示2：普通字节流 + 逐字节读写（最慢的写法）
     * 特点：每次read/write只有1个字节，磁盘IO次数最多
     */
    public static void copyWithByteStream() throws IOException {
        String src = "large_src.txt";
        String dest = "large_dest_byte.txt";

        long start = System.currentTimeMillis();
        int count = 0;
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int data;


            // read() 每次只读1个字节，返回0~255，末尾返回-1
            while ((data = fis.read()) != -1) {
                fos.write(data); // write() 每次也只写1个字节
                count++;
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("逐字节字节流拷贝完成！");
        System.out.println("  耗时: " + (end - start) + " ms");
        System.out.println("  读写次数: " + count + " 次（每次1字节）");
        System.out.println("  拷贝后文件大小: " + Files.size(Path.of(dest)) + " 字节");
    }

    /**
     * 演示3：普通字节流 + 数组批量读写（对比缓冲流）
     * 特点：不用缓冲流，但用byte[]数组批量搬运，介于前两者之间
     */
    public static void copyWithArray() throws IOException {
        String src = "large_src.txt";
        String dest = "large_dest_arr.txt";

        long start = System.currentTimeMillis();
        int count = 0;
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024]; // 自己定义一个搬运缓冲区，1KB
            int len;

            // 和缓冲流一样的循环，但底层是普通流
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                count++;
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("数组批量字节流拷贝完成！");
        System.out.println("  耗时: " + (end - start) + " ms");
        System.out.println("  搬运次数: " + count + " 次");
        System.out.println("  拷贝后文件大小: " + Files.size(Path.of(dest)) + " 字节");
    }
}
