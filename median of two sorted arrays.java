import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int total = n + m;
        int target1 = (total - 1) / 2;
        int target2 = total / 2;

        int i = 0, j = 0;
        int index = 0;

        long middle1 = 0;
        long middle2 = 0;

        while (index <= target2) {
            int value;

            if (i < n && j < m) {
                if (a[i] <= b[j]) {
                    value = a[i++];
                } else {
                    value = b[j++];
                }
            } else if (i < n) {
                value = a[i++];
            } else {
                value = b[j++];
            }

            if (index == target1) {
                middle1 = value;
            }

            if (index == target2) {
                middle2 = value;
            }

            index++;
        }

        if (total % 2 == 1) {
            System.out.printf("%.1f%n", (double) middle2);
        } else {
            System.out.printf("%.1f%n", (middle1 + middle2) / 2.0);
        }

        sc.close();
    }
}
