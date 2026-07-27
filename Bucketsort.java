import java.io.*;
import java.util.*;

public class Bucketsort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            float num = sc.nextFloat();
            int index = (int) (num * n);
            buckets[index].add(num);
        }

        
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        
        for (int i = 0; i < n; i++) {
            for (float num : buckets[i]) {
                System.out.printf("%.2f ", num);
            }
        }

        sc.close();
    }
}