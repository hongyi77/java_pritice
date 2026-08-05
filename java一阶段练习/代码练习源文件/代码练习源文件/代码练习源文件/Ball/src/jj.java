import java.util.Scanner;

public class jj {
    String name;
    String pai;

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        jj jj = new jj();
        jj.name = scanner.next();
        jj.pai = scanner.next();
       /* System.out.println(jj.name.length());
        System.out.println(jj.pai.length());*/
        for (int i = 0; i <jj.name.length(); i++) {
            System.out.print("/");

        }
    }
}
