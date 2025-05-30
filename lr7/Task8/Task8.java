package lr7.Task8;

import java.io.*;

public class Task8 {
    public static void main(String[] args) {
        Obj obj = new Obj(123, "qwerty");

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("obj.ser"))) {
            out.writeObject(obj);
            System.out.println("Объект сохранён в файл obj.ser");
        } catch (IOException e) {
            System.err.println("Ошибка при записи объекта: " + e.getMessage());
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("obj.ser"))) {
            Obj restored = (Obj) ois.readObject();

            System.out.println("Восстановленный объект:");
            System.out.println("numField = " + restored.getNumField());
            System.out.println("strField = " + restored.getStrField());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении объекта: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Класс Obj не найден: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
