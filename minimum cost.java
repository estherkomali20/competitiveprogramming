import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                long value = sc.nextLong();

                if (i == 0 && j == 0) {
                    dp[i][j] = value;
                    continue;
                }

                long best = Long.MAX_VALUE;

                if (i > 0) {
                    best = Math.min(best, dp[i - 1][j]);
                }

                if (j > 0) {
                    best = Math.min(best, dp[i][j - 1]);
                }

                if (i > 0 && j > 0) {
                    best = Math.min(best, dp[i - 1][j - 1]);
                }

                dp[i][j] = value + best;
            }
        }

        System.out.println(dp[n - 1][m - 1]);

        sc.close();
    }
}
