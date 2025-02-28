package lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите месяц: ");
        String month = in.nextLine();
        System.out.println("Введите число дней в месяце: ");
        int days_in_month = in.nextInt();
        System.out.println("Число дней в " + month + ": " + days_in_month);
        in.close();
    }
}
