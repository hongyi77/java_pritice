package com.lianxi;

class ye{

}
public class duotai1 extends ye {
    String name ="fu";
    public void show(){
        System.out.println("show类的方法被调用了");
    }
    public void fushow(){
        System.out.println("fushow的方法被调用了");
    }

}
class zi extends duotai1{
    String name ="zi";
    public void zishow(){
        System.out.println("zishow的方法被调用了");
    }

    @Override
    public void show() {
        System.out.println("子类重写的show方法被调用了");
    }
}
class text4{
    static void main(String[] args) {
        //在运行的时候编译和运行都看左边 这是及有关成员变量的

        duotai1 f = new zi();
        f.fushow();//这属于一个编译过程
        //编译看左边，运行看右边
        //但是看右边时，若是子类没有成员方法时，则会使用父类的成员方法
        f.show();
        System.out.println("姓名为："+f.name);
        //若是想用到子类中非重写的成员方法，需要用到类型转换
        //1.这张是自动类型转换（从子到父）
        zi z = (zi)f;
        z.zishow();
        //2.这是强制类型转换
        ye u = new duotai1();//如果是zi则触发if中的结果，如果是duotai则是else的结果，
        if (u instanceof zi ){//此时可以调用zishow()的结果
            zi ff = (zi) u;
            ff.fushow();
            ff.show();
            ff.zishow();
        }else {
            System.out.println("请确定好类型在进行数据转换");
        }
    }

}

