package com.file_prictice;

import java.io.File;
//删除所有文件
public class filedemon_lianxi01 {
    public static void main(String[] args) {
        /*File file = new File("D:\\文件实验地\\sss");
        deleteAll(file);*/
    }
    public  static  void deleteAll(File src){
        if (!src.exists()){
            return;
        }
                if (src.isDirectory()){
                    File[] chileren = src.listFiles();
                    if (chileren !=null){
                        for (File childe:chileren){
                            deleteAll(childe);
                        }
                    }

                boolean result = src.delete();
                if (result){
                    System.out.println("已删除的"+src.getAbsolutePath());
                }else {
                    System.out.println("删除失败，权限不足"+src.getAbsolutePath());
                }
        }

    }
}
