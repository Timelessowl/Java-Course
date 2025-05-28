package lr7;

import java.io.File;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = in.nextLine();
        in.close();

        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            System.out.println("Размер файла в байтах: " + file.length());
        } else {
            System.out.println("Файл не найден или это не файл: " + fileName);
        }
    }
}
