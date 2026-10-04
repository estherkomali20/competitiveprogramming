import java.io.*;
import java.util.*;

public class Main {

    static class WordInfo {
        String word;
        String abbreviation;

        WordInfo(String word) {
            this.word = word;
            this.abbreviation = getAbbreviation(word);
        }
    }
    static String getAbbreviation(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int n = Integer.parseInt(br.readLine().trim());
        String line = br.readLine().trim();
                String[] words = line.split(",");
        String pattern = br.readLine().trim();
        List<WordInfo> result = new ArrayList<>();
        for (String word : words) {
            word = word.trim();
            String abbreviation = getAbbreviation(word);
            if (abbreviation.startsWith(pattern)) {
                result.add(new WordInfo(word));
            }
        }
        result.sort((a, b) -> {
            int cmp = a.abbreviation.compareTo(b.abbreviation);

            if (cmp != 0) {
                return cmp;
            }

            return a.word.compareTo(b.word);
        });

        if (result.isEmpty()) {
            System.out.println("No match found");
        } else {
            for (WordInfo info : result) {
                System.out.println(info.word);
            }
        }
    }
}
