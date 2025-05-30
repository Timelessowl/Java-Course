package timus;

import java.util.Scanner;

public class task1401 {
    static int[][] board;
    static int idCounter = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        int size = 1 << n;
        board = new int[size][size];
        tile(0, 0, size, x - 1, y - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.setLength(0);
            for (int j = 0; j < size; j++) {
                if (j > 0)
                    sb.append(' ');
                sb.append(board[i][j]);
            }
            System.out.println(sb.toString());
        }
    }

    static void tile(int r, int c, int size, int mx, int my) {
        if (size == 2) {
            int id = idCounter++;
            for (int i = r; i < r + 2; i++) {
                for (int j = c; j < c + 2; j++) {
                    if (i == mx && j == my)
                        continue;
                    board[i][j] = id;
                }
            }
            return;
        }
        int s2 = size / 2;
        int cx = r + s2 - 1;
        int cy = c + s2 - 1;
        int quadrant;
        if (mx <= cx && my <= cy)
            quadrant = 1;
        else if (mx <= cx && my > cy)
            quadrant = 2;
        else if (mx > cx && my <= cy)
            quadrant = 3;
        else
            quadrant = 4;
        int id = idCounter++;
        if (quadrant != 1)
            board[cx][cy] = id;
        if (quadrant != 2)
            board[cx][cy + 1] = id;
        if (quadrant != 3)
            board[cx + 1][cy] = id;
        if (quadrant != 4)
            board[cx + 1][cy + 1] = id;
        tile(r, c, s2, quadrant == 1 ? mx : cx, quadrant == 1 ? my : cy);
        tile(r, c + s2, s2, quadrant == 2 ? mx : cx, quadrant == 2 ? my : cy + 1);
        tile(r + s2, c, s2, quadrant == 3 ? mx : cx + 1, quadrant == 3 ? my : cy);
        tile(r + s2, c + s2, s2, quadrant == 4 ? mx : cx + 1, quadrant == 4 ? my : cy + 1);
    }
}
