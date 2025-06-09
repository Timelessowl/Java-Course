package lr8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.POIXMLException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFileExample {
    public static void main(String[] args) {
        String filePath = "example.xlsx";

        try (FileInputStream inputStream = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                System.err.println("Лист \"Товары\" не найден в файле " + filePath);
                return;
            }

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath +
                    ". Проверьте путь и имя файла.");
        } catch (POIXMLException e) {
            System.err.println("Файл не является корректным .xlsx: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
