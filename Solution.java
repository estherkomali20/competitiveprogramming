import java.io.*;
import java.util.*;

public class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.isEnd = true;
        }

        boolean search(String word) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    return false;
                }

                current = current.children[index];
            }

            return current.isEnd;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] words = sc.nextLine().split(",");

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        String search = sc.nextLine();

        System.out.println(trie.search(search) ? 1 : 0);

        sc.close();
    }
}
