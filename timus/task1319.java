import java.util.Scanner;

public class task1319 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        int currentNumber = 1;

        for (int startColumn = size - 1; startColumn >= 0; startColumn--) {
            int row = 0;
            int col = startColumn;
            while (row < size && col < size) {
                matrix[row][col] = currentNumber;
                currentNumber++;
                row++;
                col++;
            }
        }

        for (int startRow = 1; startRow < size; startRow++) {
            int row = startRow;
            int col = 0;
            while (row < size && col < size) {
                matrix[row][col] = currentNumber;
                currentNumber++;
                row++;
                col++;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
