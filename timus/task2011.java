package timus;

import java.math.BigInteger;
import java.util.Scanner;

public class task2011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pieces = new int[n];
        for (int i = 0; i < n; i++) {
            pieces[i] = in.nextInt();
        }
        in.close();

        int countA = 0, countB = 0, countV = 0;
        for (int x : pieces) {
            if (x == 1)
                countA++;
            else if (x == 2)
                countB++;
            else if (x == 3)
                countV++;
        }

        BigInteger permutations = factorial(n)
                .divide(factorial(countA)
                        .multiply(factorial(countB))
                        .multiply(factorial(countV)));

        System.out.println(permutations.compareTo(BigInteger.valueOf(6)) >= 0 ? "Yes" : "No");
    }

    private static BigInteger factorial(int k) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= k; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
