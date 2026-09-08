import java.util.Scanner;

public class codeforce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int normalWords = scanner.nextInt();
            int abbreviations = scanner.nextInt();
            boolean[] available = new boolean[26];

            for (int i = 0; i < normalWords; i++) {
                String word = scanner.next();
                char firstLetter = Character.toUpperCase(word.charAt(0));
                available[firstLetter - 'A'] = true;
            }

            String[] words = new String[abbreviations];
            for (int i = 0; i < abbreviations; i++) {
                words[i] = scanner.next();
            }

            boolean[] used = new boolean[abbreviations];
            int completed = 0;

            while (completed < abbreviations) {
                boolean found = false;

                for (int i = 0; i < abbreviations; i++) {
                    if (used[i]) {
                        continue;
                    }

                    boolean possible = true;
                    for (int j = 0; j < words[i].length(); j++) {
                        if (!available[words[i].charAt(j) - 'A']) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        used[i] = true;
                        available[words[i].charAt(0) - 'A'] = true;
                        completed++;
                        found = true;
                    }
                }

                if (!found) {
                    break;
                }
            }

            if (completed == abbreviations) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}