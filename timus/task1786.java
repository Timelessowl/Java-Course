package timus;

import java.util.Scanner;

public class task1786 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = "Sandro";
        int n = s.length();
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 6; i++) {
            int cost = 0;
            for (int j = 0; j < 6; j++) {
                char c = s.charAt(i + j);
                char d = t.charAt(j);
                if (c == d) {
                    cost += 0;
                } else if (Character.toLowerCase(c) == Character.toLowerCase(d)) {
                    cost += 5;
                } else if (Character.isUpperCase(c) == Character.isUpperCase(d)) {
                    cost += 5;
                } else {
                    cost += 10;
                }
            }
            if (cost < minCost) {
                minCost = cost;
            }
        }
        System.out.println(minCost);
        in.close();
    }
}
