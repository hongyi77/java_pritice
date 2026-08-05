import java.util.Scanner;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(){
        super("请输入正确的年龄");
    }

    public InvalidAgeException(String s) {
    }

    public void setage( int age) throws InvalidAgeException {

        if (age<0||age>150){
            if (age>150){
                System.out.println("年龄亿点大");
            }else {
                System.out.println("出生了吗");
            }
            throw new InvalidAgeException();
        }
    }
    }

