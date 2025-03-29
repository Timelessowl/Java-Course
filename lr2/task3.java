package lr2;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст для шифрования: ");
        String text = in.nextLine();
        System.out.println("Введите ключ: ");
        int shift = in.nextInt();
        text = encrypt(text, shift);
        System.out.println("Текст после преобразования: " + text);
        System.out.println("Выполнить обратное преобразование? (y/n)");
        chooseOption(in, text, shift);
        in.close();
    }

    public static String encrypt(String text, int shift) {
        char[] ch_text = text.toCharArray();
        for (int i = 0; i < ch_text.length; i++) {
            ch_text[i] += shift;
        }
        return new String(ch_text);

    }

    public static String decrypt(String text, int shift) {
        char[] ch_text = text.toCharArray();
        for (int i = 0; i < ch_text.length; i++) {
            ch_text[i] -= shift;
        }
        return new String(ch_text);
    }

    public static void chooseOption(Scanner in, String text, int shift) {
        char answer = in.next().charAt(0);
        if (answer == 'y') {
            System.out.println("Текст после обратного преобразования: " + decrypt(text, shift));
        } else if (answer == 'n') {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ.");
            chooseOption(in, text, shift);
        }
    }

}
