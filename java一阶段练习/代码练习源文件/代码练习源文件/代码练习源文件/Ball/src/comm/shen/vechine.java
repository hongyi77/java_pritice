package comm.shen;

public class vechine {
    private String name;
    private double speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public vechine(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }
    public void move(){
        System.out.println("一辆"+getName()+"正在以"+getSpeed()+"km/h的速度在马路上行驶");

    }
}
 class bike extends vechine{
     public bike(String name, double speed) {
         super(name, speed);
     }

     @Override
     public void move() {
         super.move();
     }
     public void ringball(){
         System.out.println("它的声音提示效果是响铃");
     }
 }
 class car extends vechine{
     public car(String name, double speed) {
         super(name, speed);
     }

     @Override
     public void move() {
         super.move();
     }
     public void honk(){
         System.out.println("它的声音提示效果是鸣笛");
     }
 }
 class people{
    String name;
    int age;
    String gender;
    public people(){};
    public people(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void print(){
        System.out.print("姓名:"+name+" ");
        System.out.print("年龄:"+age+" ");
        System.out.println("性别:"+gender);

    }
    public void drive(vechine vechine){
       vechine.move();
       if (vechine instanceof bike){
           bike b = (bike) vechine;
           b.ringball();
       }else if (vechine instanceof car) {
           car b1 = (car) vechine;
       }else {
           System.out.println("没有输出效果");
       }
    }
 }
 class text{
     public static void main(String[] args) {
         people people = new people("小明",16,"男");
         people people1 = new people("林小诗",18,"女");
         vechine r =  new car("汽车",15.6);
         people.print();
         people.drive(r);

         vechine r1  = new bike("自行车",1.6);
         people1.print();
        people1.drive(r1);

     }
 }
