import java.util.*;

public class java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int ans = 0;
            for (int i = 0; i < n; i += k) {
                boolean hasZero = false;
                for (int j = 0; j < k; j++) {
                    if (s.charAt(i + j) == '0') {
                        hasZero = true;
                        break;
                    }
                }
                if (!hasZero) {
                    ans++;
                }
            }
            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}
