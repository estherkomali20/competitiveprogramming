import java.io.*;
import java.util.*;

public class Solution {

    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;

        int star = -1;
        int starMatch = -1;

        while (i < s.length()) {

            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }

            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                starMatch = i;
                j++;
            }

            else if (star != -1) {
                j = star + 1;
                starMatch++;
                i = starMatch;
            }

            else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();
        String p = sc.nextLine().trim();

        System.out.println(isMatch(s, p) ? 1 : 0);

        sc.close();
    }
}
