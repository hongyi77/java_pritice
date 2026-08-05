import java.util.Scanner;

public class nian {
    public static void main(String[] args) throws InvalidAgeException {
       while (true) {
           System.out.println("请输入年龄");
           Scanner scanner = new Scanner(System.in);
           int age = scanner.nextInt();
           InvalidAgeException invalidAgeException = new InvalidAgeException();
           invalidAgeException.setage(age);
       }
    }
}
