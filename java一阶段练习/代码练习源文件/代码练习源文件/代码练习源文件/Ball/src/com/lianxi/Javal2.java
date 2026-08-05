package com.lianxi;

public class Javal2 {
    public static void main(String[] args) {
        //StringBUtter类  可以储存各种各样的数据类型
        System.out.println("StringBUtter类");
        StringBuffer butter = new StringBuffer();
        butter.append("hello ");
        butter.append(",");//append输入信息
        butter.append("world ");
        butter.append("! ");
        butter.append(42+" ");
        butter.append(true+" ");
        System.out.println(butter.toString());//toString()用于输出
        System.out.println(
        );

        //deleteCharAt方法用于用于删除指定位置的字符
        System.out.println("deleteCharAt");
        StringBuffer buffer = new StringBuffer("hello,world");
        System.out.println("原始内容："+buffer.toString());
        buffer.deleteCharAt(5);//实际删除的数为原来的索引值+1
        buffer.delete(2,5);//可以删除指定的范围
        System.out.println("修改后的内容为："+buffer.toString());//删除索引5
        /*假设你删除一个不存在的数，最后会抛出异常，例如buffer.deleteCharAt(20)*/
        System.out.println();

        //insert方法是StringButter类中最重要的方法,它允许在指定的位置插入一个或多个字符或字符串
        System.out.println("insert");
        StringBuffer butter1 = new StringBuffer("hello  数字为");
        butter1.insert(6,"world");
        butter1.insert(butter1.length(),42);
        System.out.println(butter1.toString());
        System.out.println();

        //reverse方法revere方法用于反转此字符序列的方法
        System.out.println("reverse");
        StringBuffer buffer1 = new StringBuffer("hello world");
        System.out.println("原始内容为："+buffer1.toString());
        buffer1.reverse();
        System.out.println("反转后的内容为:"+buffer1.toString());

    }
}
