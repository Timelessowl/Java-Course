package lr3;

import java.util.Scanner;

public class print_array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");
        inputArray(in, arr, 0);

        System.out.println("Введенный массив:");
        printArray(arr, 0);

        in.close();
    }

    public static void inputArray(Scanner scanner, int[] arr, int index) {
        if (index < arr.length) {
            arr[index] = scanner.nextInt();
            inputArray(scanner, arr, index + 1);
        }
    }

    public static void printArray(int[] arr, int index) {
        if (index < arr.length) {
            System.out.print(arr[index] + " ");
            printArray(arr, index + 1);
        }
    }
}
