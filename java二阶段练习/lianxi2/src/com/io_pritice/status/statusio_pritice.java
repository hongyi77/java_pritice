package com.io_pritice.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// 【解压缩流基础概念】
// ----------------------------------------------------------
// 1. 什么是解压缩流？
//    解压缩流是一种过滤流（Filter Stream），用于从压缩格式的数据中
//    还原出原始数据。它读取压缩后的输入流，并经过解压算法处理，
//    输出解压后的字节或字符数据。
//
// 2. 常见解压缩流类：
//    - GZIPInputStream：用于解压 .gz 格式的压缩流，基于 GZIP 算法。
//    - ZipInputStream：用于解压 .zip 格式的压缩包，可以逐个条目（entry）解压。
//    - JarInputStream：专门用于解压 JAR 文件，继承自 ZipInputStream。
//    - DeflaterInputStream：使用通用 DEFLATE 算法的解压流。
//
// 3. 解压缩流的工作原理：
//   (a) 创建一个底层字节输入流（如 FileInputStream）指向压缩文件；
//   (b) 将该底层流包装到解压缩流中（如 new GZIPInputStream(FileInputStream)）；
//   (c) 通过 read() 方法从解压缩流读取数据，内部自动执行解压逻辑；
//   (d) 读取到的数据已经是原始内容，可直接写入目标文件或输出到控制台。
//
// 4. 典型使用步骤：
//   a. 创建底层输入流：FileInputStream fis = new FileInputStream("file.zip");
//   b. 包装解压缩流：ZipInputStream zis = new ZipInputStream(fis);
//   c. 获取下一个压缩条目：ZipEntry entry = zis.getNextEntry();
//   d. 循环读取解压数据：int len; byte[] buffer = new byte[1024];
//                         while ((len = zis.read(buffer)) != -1) { ... }
//   e. 关闭条目：zis.closeEntry(); （每个条目解压后需关闭）
//   f. 关闭资源：依次关闭 ZipInputStream 和 FileInputStream。
//
// 5. 注意事项：
//   - 解压缩流必须配合压缩文件使用，不能直接对普通文件解压；
//   - 对于 .zip 等多文件压缩包，需使用 getNextEntry() 遍历每个条目；
//   - 使用 try-with-resources 或在 finally 块中手动关闭流，防止资源泄漏；
//   - 解压缩过程可能消耗较多 CPU 和内存，大文件建议分块读写；
//   - 若压缩文件损坏或格式不匹配，会抛出 IOException。
//
// 6. 代码示例框架（供参考，无需复制）：
//   try (FileInputStream fis = new FileInputStream("src.zip");
//        ZipInputStream zis = new ZipInputStream(fis)) {
//       ZipEntry entry;
//       while ((entry = zis.getNextEntry()) != null) {
//           // 在此读取 entry 的内容并解压保存
//           zis.closeEntry();
//       }
//   } catch (IOException e) {
//       e.printStackTrace();
//   }
// ----------------------------------------------------------

public class statusio_pritice {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\文件实验地\\代码练习源文件.zip");
        ZipInputStream zip = new ZipInputStream(fis);
        ZipEntry entry;
        try(fis;zip){
            while ((entry=zip.getNextEntry())!=null){
                System.out.println(entry);
            }
        }


    }
}
