import java.io.*;

public class Main {

   
    static int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    static void search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = buildLPS(pat);

        int i = 0; 
        int j = 0;

        while (i < n) {

            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println(i - j);
                j = lps[j - 1];

            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String txt = br.readLine();
        String pat = br.readLine();

        search(pat, txt);
    }
}
