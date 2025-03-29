package timus;

import java.util.Scanner;

public class task1296 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long maxPotential = 0;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();
            currentSum += p;
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (currentSum > maxPotential) {
                maxPotential = currentSum;
            }
        }

        System.out.println(maxPotential);
        in.close();
    }
}
