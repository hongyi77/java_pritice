package com.lianxi;

public class people {
    String name;
    int zhanghao;int mima;
    public void work(){
        System.out.println("work");
    }
    public  people( String name,
    int zhanghao,int mima){
        this.name = name;
        this.zhanghao = zhanghao;
        this.mima = mima;
    }
    public  void chen(){
        System.out.println("姓名："+name+" 账号"+zhanghao+" 密码"+mima);
        System.out.println("注册成功");
    }
    public void print(){
        System.out.print("姓名："+name+" ");
        System.out.print("账号"+zhanghao+" ");
        System.out.println("密码"+mima+" ");
    }

}
class student extends people{
    public student( String name,
    int zhanghao,int mima){
        super(name, zhanghao, mima);
    }
    @Override
    public void work() {


        super.work();
        System.out.println("学生的工作是做作业");
    }
}
class teather extends people{
    public teather( String name,
                    int zhanghao,int mima){
        super(name, zhanghao, mima);
    }
    @Override
    public void work() {

        super.work();
        System.out.println("老师的工作是教书");
    }
}
class guanliyuan extends people{
    public guanliyuan( String name,
                    int zhanghao,int mima){
        super(name, zhanghao, mima);
    }
    @Override
    public void work() {

        super.work();
        System.out.println("管理员的工作是管理网站");
    }
}
class text{
    public static void main(String[] args) {
        System.out.println("---------学生管理网站----------");
        people people = new student("张三",202533987,123456);
        people.print();
        people.work();

        people people1 = new teather("李四",202566987,586974);
        people1.print();
        people1.work();

        people people2 = new guanliyuan("王五",202544687,186897);
        people2.print();
        people2.work();

    }
}