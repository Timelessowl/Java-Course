package lr1;

import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите год рождения: ");
        int year = in.nextInt();
        System.out.println("Ваше имя: " + name + "\nВаш возраст: " + (2025 - year));
        in.close();
    }
}
