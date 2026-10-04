import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        System.out.println(count);
    }
}
