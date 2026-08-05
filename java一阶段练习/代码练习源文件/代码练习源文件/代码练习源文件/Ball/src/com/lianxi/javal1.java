package com.lianxi;

public class javal1 {
    public static void main(String[] args) {
        //replace
        //替换字符的应用
        String str = "hello,world!this is a python program";
        String turn = str.replace('o','x');
        System.out.println("替换字符的字符串为:"+turn);
        String turn1 = str.replace("java","kotlain");
        System.out.println("替换字符的字符串为:"+turn1);
        //System.out.println(turn3);//输出的是原始字符串,因为没有找到python的字符串
        if (str.contains("python")){//判断是否有python这个字符串
            String newturn3 = str.replace("python","java");
            //定义一个新字符串，// 将python换成Java
            System.out.println("替换后的字符串为"+newturn3);

        }else {
            System.out.println("你所置换的这个字符串，在本句话中不存在");
        }
        //spilt,将字符串的数字进行分割,消除符号
        String str1 ="apple,banana,orange,grape";
        String[]fen = str1.split(",");
        //这是增强for循环的效果
        for (String fruit:fen){
            System.out.print(fruit+" ");
        }
        /* 普通for循环的效果
        //for(int i = 0;i<str1.length;i++)
                  String fruit = fen[i];
                  System.out.print("fruit")
         */
        System.out.println();
        //输出一个单字符的应用
        String str3 = "Hello,world";
        char[]charArry = str3.toCharArray();
        for (char c:charArry) {

            System.out.print(c+" ");
        }
        System.out.println();
        System.out.println("第一个字符为"+charArry[0]);
        System.out.println("最后一个字符为"+charArry[charArry.length-1]);
    }
}
