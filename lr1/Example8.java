package lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите день недели: ");
        String weekday = in.nextLine();
        System.out.println("Введите текущий месяц: ");
        String month = in.nextLine();
        System.out.println("Введите текущую дату: ");
        int day = in.nextInt();
        System.out.println("Сегодня " + weekday + ", " + day + " " + month);
        in.close();
    }
}
