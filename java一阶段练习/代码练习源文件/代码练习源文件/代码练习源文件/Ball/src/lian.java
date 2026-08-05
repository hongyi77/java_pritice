import java.util.InputMismatchException;
import java.util.Scanner;

public class lian {
    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入一个数字");
            Scanner scanner = new Scanner(System.in);
            try {
                int day = scanner.nextInt();
                if (day < 0) {
                    System.out.println("请输入大于零的数");
                    continue;
                }
                for (int i = 0; i < 100; i++) {
                    if (day == i * i) {
                        System.out.println(i);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("请输入整数");
            } catch (Exception e) {
                System.out.println("请输入小数");
            }


        }
    }

}
