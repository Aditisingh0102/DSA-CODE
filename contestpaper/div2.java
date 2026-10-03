import java.util.*;

public class div2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] p = new int[n + 1];
                ArrayList<Integer> wrong = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    p[i] = scanner.nextInt();
                    if (p[i] != i) wrong.add(i);
                }
                boolean ok = true;
                for (int i = 0; i < wrong.size(); i++)
                    if (p[wrong.get(i)] != wrong.get(wrong.size() - i - 1)) ok = false;
                System.out.println(ok ? "YES" : "NO");
            }
        }
    }
}
