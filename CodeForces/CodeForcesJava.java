import java.util.*;

public class CodeForcesJava {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int count1 = 0;

                for (int j = 0; j < n; j++) {
                    count1 += sc.nextInt();
                }
                if (count1 > (n - 1) / 2) {
                    System.out.println("Bessie");
                } else {
                    System.out.println("Elsie");
                }
            }
        }
    }
}