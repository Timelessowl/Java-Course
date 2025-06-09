package timus;

import java.util.Scanner;

public class task1573 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int B = in.nextInt();
        int R = in.nextInt();
        int Y = in.nextInt();
        int K = in.nextInt();
        long ways = 1;
        for (int i = 0; i < K; i++) {
            String color = in.next();
            if (color.equals("Blue")) {
                ways *= B;
            } else if (color.equals("Red")) {
                ways *= R;
            } else if (color.equals("Yellow")) {
                ways *= Y;
            }
        }
        System.out.println(ways);
        in.close();
    }
}
