package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "Список до: " + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
            System.out.println(integers.get(i));
        }

        Scanner in = new Scanner(System.in);
        int divisor = in.nextInt();
        in.close();

        List<Integer> integersAfter = filterDivisibleBy(integers, divisor);

        System.out.println("\n" + "Список чисел, делящихся на " + divisor + " без остатка: " + "\n");

        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }

    public static List<Integer> filterDivisibleBy(List<Integer> list, int divisor) {
        return list.stream()
                .filter(x -> x % divisor == 0)
                .collect(Collectors.toList());
    }
}
