package com.io_pritice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class iofiledemon6 implements AutoCloseable {
    public static void main(String[] args)  {
        long start = System.currentTimeMillis();
        FileInputStream fis;
        FileOutputStream fos;
        try {
             fis = new FileInputStream("D:\\java二阶段练习\\lianxi2\\q.txt");
            fos = new FileOutputStream("D:\\java二阶段练习\\lianxi2\\dd.txt");
            try (fis; fos) {
                byte[] bytes = new byte[2];
                int len;
                while ((len = fis.read(bytes)) != -1) {
                    System.out.print((char) len);
                    fos.write(bytes, 0, len);
                }
            }
            System.out.println();
            long end = System.currentTimeMillis();
            System.out.println("共花费" + ((end - start)) + "ms的时间");
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("🤭");
        }
    }

    @Override
    public void close() throws Exception {

    }
}
