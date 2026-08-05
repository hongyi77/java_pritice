package comm.shen;

import java.util.Scanner;

public class phonecall {
    public static void main(String[] args) {
        System.out.println("-----注册系统-----");
        Scanner scanner = new Scanner(System.in);
        //System.out.println("请输入你的手机号：");//19714518014   197*****014
       String zhanghao = getzhanghao(scanner);
        System.out.print(zhanghao);
        String callnum = getcall(scanner);
        System.out.println(callnum);
        String usename = getname(scanner);
        System.out.print(usename);
    }
    public  static String getzhanghao(Scanner scanner){
        while(true){
            System.out.println("请输入你的账号：");
            String usezhanghao = scanner.next();
            if (usezhanghao.length()>7&&usezhanghao.length()<11){
                        break;
            }else {
                System.out.println("输出无效，请重新输入");
            }
        }
        return "";
    }

    public static String getcall(Scanner scanner){
        while (true){
            System.out.println("请输入你的密码（9位数）：");
            String callnum = scanner.next();
            System.out.println("请再次输入你的密码：");
            String callnum1 = scanner.next();
            if (callnum.length()==9&&callnum1.length()==9&&callnum.equals(callnum1)){
                System.out.println("恭喜你成功注册");
                System.out.print("您的密码是");
                return callnum.substring(0,2)+"*****"+callnum.substring(6);
            } else {
                System.out.println("你输入的格式不对，请重新输入");
            }

            }
        }
        public static String getname(Scanner scanner){
        while (true){
            System.out.println("请输入你的用户名:");
            String usename = scanner.next();
            if (usename.length()>=2&&usename.length()<=8){
                System.out.println("成功进入该应用，"+"你好"+usename+","+"请开始你的体验");
                return "";
            }
        }
        }
    }


