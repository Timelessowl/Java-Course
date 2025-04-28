package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task6 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "Список до: " + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
            System.out.println(integers.get(i));
        }

        Scanner in = new Scanner(System.in);
        System.out.println("\n" + "Введите пороговое значение:");
        int threshold = in.nextInt();
        in.close();

        List<Integer> filtered = filterGreaterThan(integers, threshold);

        System.out.println("\n" + "Список чисел, которые больше " + threshold + ": " + "\n");

        for (Integer num : filtered) {
            System.out.println(num);
        }
    }

    public static List<Integer> filterGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(x -> x < threshold)
                .collect(Collectors.toList());
    }
}
