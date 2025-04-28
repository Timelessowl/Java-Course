package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк " +
                "и возвращает новый список, содержащий только те строки, " +
                "которые имеют длину больше заданного значения.";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("\n" + "Введите минимальную длину строки:");
        int minLength = in.nextInt();
        in.close();

        List<String> stringsAfter = filterByLength(strings, minLength);

        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
