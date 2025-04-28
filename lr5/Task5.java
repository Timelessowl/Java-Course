package lr5;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        String string = "Напишите функцию1, которая принимает2 на вход список3 "
                + "строк! и возвращает1 новый список, содержа3щий только те с5троки, "
                + "которые содержат только бук:3вы без цифр и символов.";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> filtered = filterOnlyLetters(strings);

        System.out.println("\n" + "Строка после преобразования : " + "\n");
        for (String e : filtered) {
            System.out.println(e);
        }
    }

    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }
}
