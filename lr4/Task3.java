package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int n = sc.nextInt();

            byte[] arr = new byte[n];
            System.out.println("Введите " + n + " чисел (–128…127):");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextByte();
            }

            int sum = 0;
            for (byte b : arr) {
                sum += b;
                if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Переполнение диапазона byte");
                }
            }

            System.out.println("Сумма всех элементов (в byte): " + (byte) sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое в диапазоне –128…127");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка вычисления: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e);
        } finally {
            sc.close();
        }
    }
}
