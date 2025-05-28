package lr7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = in.nextLine();
        System.out.print("Введите текст для записи: ");
        String text = in.nextLine();
        in.close();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            System.out.println("Количество записанных символов: " + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
