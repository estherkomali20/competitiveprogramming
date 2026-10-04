import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static int[] arr;
    static long total;
    static long minDiff = Long.MAX_VALUE;

    static void solve(int index, int count, long sum) {

        if (count == n / 2) {
            long otherSum = total - sum;
            long diff = Math.abs(sum - otherSum);

            minDiff = Math.min(minDiff, diff);
            return;
        }

        if (index == n) {
            return;
        }

        solve(index + 1, count + 1, sum + arr[index]);

        solve(index + 1, count, sum);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        solve(0, 0, 0);

        System.out.println(minDiff);
    }
}
