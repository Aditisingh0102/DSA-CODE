import java.util.Scanner;
public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int first = 0;
            int last = 0;
            int zcounts = 0;
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                if (j == 0) { first = value;
                } if (j == n - 1) {
                    last = value;
                } if (value == 0) {
                    zcounts++;}}
            if (zcounts < 2) {
                System.out.println(-1);
            } else {   int swaps = 0;
                if (first == 1) {
                    swaps++; }
                if (last == 1) {
                    swaps++;}
                System.out.println(swaps);}}
        sc.close();}}