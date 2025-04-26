package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Введите " + n + " целых чисел:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int sum = 0, count = 0;
            for (int x : arr) {
                if (x > 0) {
                    sum += x;
                    count++;
                }
            }
            double avg = (double) sum / count;
            System.out.println("Среднее значение среди положительных: " + avg);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: положительных элементов нет.");
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e);
        } finally {
            sc.close();
        }
    }
}
