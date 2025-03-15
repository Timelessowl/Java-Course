package lr2;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Введите размер массива: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = rand.ints(n, 0, 200).toArray();

        System.out.println("Массив: " + Arrays.toString(arr));

        int min_element = Integer.MAX_VALUE;
        String indexes_of_min_elements = "";

        for (int i = 0; i < n; i++) {
            if (arr[i] < min_element) {
                min_element = arr[i];
                indexes_of_min_elements = String.valueOf(i);
            } else if (arr[i] == min_element) {
                indexes_of_min_elements += ", " + i;
            }
        }

        System.out.println("Минимальный элемент массива: " + min_element);
        System.out.println("Индексы минимальных элементов массива: " + indexes_of_min_elements);
        in.close();
    }

}
