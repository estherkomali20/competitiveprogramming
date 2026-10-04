import java.io.*;
import java.util.*;

public class Solution {

    static class Result {
        long x, y, gcd;

        Result(long x, long y, long gcd) {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }
    }

    // Returns x, y, gcd such that a*x + b*y = gcd(a,b)
    static Result extendedGCD(long a, long b) {
        if (b == 0) {
            return new Result(1, 0, a);
        }

        Result r = extendedGCD(b, a % b);

        long x = r.y;
        long y = r.x - (a / b) * r.y;

        return new Result(x, y, r.gcd);
    }

    static long floorDiv(long a, long b) {
        return Math.floorDiv(a, b);
    }

    static long ceilDiv(long a, long b) {
        return -Math.floorDiv(-a, b);
    }

    static boolean better(long x1, long y1, long x2, long y2) {
        long sum1 = Math.abs(x1) + Math.abs(y1);
        long sum2 = Math.abs(x2) + Math.abs(y2);

        if (sum1 != sum2)
            return sum1 < sum2;

        return x1 <= y1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        Result r = extendedGCD(A, B);

        long x0 = r.x;
        long y0 = r.y;
        long D = r.gcd;

        // General solution:
        // x = x0 + k * (B/D)
        // y = y0 - k * (A/D)

        long p = B / D;
        long q = A / D;

        /*
         * The minimum |x| + |y| occurs around the points where
         * x or y changes sign. Check the nearby k values.
         */
        long k1 = floorDiv(-x0, p);
        long k2 = ceilDiv(-x0, p);
        long k3 = floorDiv(y0, q);
        long k4 = ceilDiv(y0, q);

        long[] candidates = {
            k1 - 1, k1, k1 + 1,
            k2 - 1, k2, k2 + 1,
            k3 - 1, k3, k3 + 1,
            k4 - 1, k4, k4 + 1
        };

        long bestX = x0;
        long bestY = y0;

        for (long k : candidates) {
            long x = x0 + k * p;
            long y = y0 - k * q;

            if (better(x, y, bestX, bestY)) {
                bestX = x;
                bestY = y;
            }
        }

        System.out.println(bestX + " " + bestY + " " + D);

        sc.close();
    }
}
