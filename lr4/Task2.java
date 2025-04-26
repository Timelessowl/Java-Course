package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите число строк: ");
            int rows = sc.nextInt();
            System.out.print("Введите число столбцов: ");
            int cols = sc.nextInt();

            int[][] mat = new int[rows][cols];
            System.out.println("Введите элементы матрицы построчно:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            System.out.print("Номер столбца для вывода (0–" + (cols - 1) + "): ");
            int colIndex = sc.nextInt();

            System.out.println("Элементы столбца " + colIndex + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(mat[i][colIndex]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: столбца с таким индексом не существует.");
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e);
        } finally {
            sc.close();
        }
    }
}
