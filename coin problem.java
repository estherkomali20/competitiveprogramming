import java.io.*;
import java.util.*;

public class Solution {

    public static long getWays(int n, int[] c) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int coin : c) {
            for (int amount = coin; amount <= n; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] c = new int[m];

        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }

        System.out.println(getWays(n, c));

        sc.close();
    }
}
