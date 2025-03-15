package lr2;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Будет создан массив n x m");
        System.out.println("Введите n: ");
        int n = in.nextInt();

        System.out.println("Введите m: ");
        int m = in.nextInt();

        int[][] arr = new int[n][m];
        boolean moving_forward = true;
        int val = 1;
        for (int i = 0; i < n; i++) {
            if (moving_forward) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = val;
                    val++;
                }
                moving_forward = false;
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    arr[i][j] = val;
                    val++;
                }
                moving_forward = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\t" + arr[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
