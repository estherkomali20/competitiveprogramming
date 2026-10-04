import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long x = sc.nextLong();

        Arrays.sort(arr);

        boolean found = false;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n - 2; i++) {
        
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if (sum == x) {
                    result.append(arr[i])
                          .append(" ")
                          .append(arr[left])
                          .append(" ")
                          .append(arr[right])
                          .append("\n");

                    found = true;
                    long leftValue = arr[left];
                    long rightValue = arr[right];

                    while (left < right && arr[left] == leftValue) {
                        left++;
                    }

                    while (left < right && arr[right] == rightValue) {
                        right--;
                    }

                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        if (found) {
            System.out.print(result);
        } else {
            System.out.println("No Triplet Found");
        }
    }
}
