import java.util.Scanner;
public class file {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder output = new StringBuilder(); 
        for (int test = 0; test < testCases; test++) {
            int n = sc.nextInt();
            int k = sc.nextInt();  
            if (k < n || k >= 2 * n) {
                output.append("-1\n");
                continue;
            }
            int shared = 2 * n - k;
            int[][] matrix = new int[n][n];
            int value = 1;
for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i == j && i < shared) || (j == 0 && i >= shared) || (i == 0 && j >= shared)) {
                        matrix[i][j] = value++;
                    }
                }
            }  for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = value++;
                    }
                }
            }  for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    output.append(matrix[i][j]).append(' ');
                }
                output.append('\n');
            }
        }  System.out.print(output);
        sc.close();
    }
}