package com.io_pritice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class iofiiledemon2 {
    //换行和续写
    //换行:再次写一个换行符就行了
            //如果说是windows系统：\r\n
            //linux: \n
            //mac:   \r
    /*
    细节：在Java中我们只需要用一个\r或\n就可以了
     */

    /*
    续写：如果想要续写，打开续写开关就可以了，，开关位置是在续写的第二个参数
    默认为false：表示关闭续写，手动为true：表示打开续写，此时创建对象不会清空文件夹
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\java二阶段练习\\lianxi2\\c.txt",true);
        String str = "wodedoerrengefeichanglihai";
        byte[] bytes = str.getBytes();
        fos.write(bytes);

        //换行处理
        String wrap = "\r\n";
        byte[] bytes2 = wrap.getBytes();
        fos.write(bytes2);

        String aaa = "666";
        byte[] bytes1 = aaa.getBytes();
        fos.write(bytes1);

        fos.close();
    }
}
