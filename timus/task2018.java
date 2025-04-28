package timus;

import java.util.Scanner;

public class task2018 {
    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();

        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        dp1[0] = 1;
        dp2[0] = 1;

        long sum1 = dp1[0];
        long sum2 = dp2[0];

        for (int i = 1; i <= n; i++) {
            dp1[i] = (int) (sum2 % MOD);
            dp2[i] = (int) (sum1 % MOD);

            sum2 = (sum2 + dp2[i]) % MOD;
            if (i - a >= 0) {
                sum2 = (sum2 - dp2[i - a] + MOD) % MOD;
            }

            sum1 = (sum1 + dp1[i]) % MOD;
            if (i - b >= 0) {
                sum1 = (sum1 - dp1[i - b] + MOD) % MOD;
            }
        }

        System.out.println((dp1[n] + dp2[n]) % MOD);
    }
}
