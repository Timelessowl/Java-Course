package lr5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк " +
                "и возвращает новый список, содержащий только те строки, " +
                "которые содержат заданную подстроку.";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }
        Scanner in = new Scanner(System.in);

        String substr = in.nextLine();
        List<String> stringsAfter = filterBySubstring(strings, substr);
        in.close();
        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterBySubstring(List<String> list, String substr) {
        return list.stream()
                .filter(s -> s.contains(substr))
                .collect(Collectors.toList());
    }
}
