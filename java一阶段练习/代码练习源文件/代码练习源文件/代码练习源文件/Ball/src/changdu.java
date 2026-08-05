import java.io.IOException;
import java.util.Scanner;

public class changdu {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("shutdown -a" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
