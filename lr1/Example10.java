package lr1;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите год рождения: ");
        System.out.println("Вероятно вам: " + (2025 - in.nextInt()));
        in.close();
    }
}
