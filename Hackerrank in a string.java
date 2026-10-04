import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        String target = "hackerrank";

        while (q-- > 0) {
            String s = sc.next();
            int j = 0;

            for (int i = 0; i < s.length(); i++) {
                if (j < target.length() && s.charAt(i) == target.charAt(j)) {
                    j++;
                }
            }

            if (j == target.length()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
