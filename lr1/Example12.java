package lr1;

import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Ваш год рождения: " + (2025 - age));
        in.close();
    }
}
