package timus;

import java.util.Scanner;
import java.math.BigInteger;

public class task1260 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        BigInteger[] ways = new BigInteger[n + 5];
        ways[1] = BigInteger.ONE;
        if (n >= 2)
            ways[2] = BigInteger.ONE;
        if (n >= 3)
            ways[3] = BigInteger.valueOf(2);
        if (n >= 4)
            ways[4] = BigInteger.valueOf(4);
        BigInteger two = BigInteger.valueOf(2);
        for (int i = 5; i <= n; i++) {
            ways[i] = two.multiply(ways[i - 1])
                    .subtract(ways[i - 2])
                    .add(ways[i - 3])
                    .subtract(ways[i - 4]);
        }
        System.out.println(ways[n]);
    }
}
