
package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NewsParser {

    private static final String URL = "http://fat.urfu.ru/index.html";

    private static final String OUTPUT_FILE = "example_news.txt";

    private static final int MAX_RETRY = 3;
    private static final int RETRY_DELAY_MS = 3_000;

    public static void main(String[] args) {

        Document doc = fetchDocumentWithRetry(URL, MAX_RETRY);
        if (doc == null) {
            System.err.println("Не удалось получить страницу после "
                    + MAX_RETRY + " попыток.");
            return;
        }

        Elements newsParent = doc.select(
                "body > table > tbody > tr > td > div > table > tbody > tr:nth-child(5)"
                        + " > td:nth-child(3) > table > tbody > tr > td:nth-child(1)");

        try (BufferedWriter out = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

            for (int i = 3; i < 20; i++) {
                if (i % 2 == 0) {
                    List<Node> nodes = newsParent.get(0).childNodes();

                    String title = ((Element) nodes.get(i))
                            .getElementsByClass("blocktitle")
                            .get(0).childNodes().get(0).toString().trim();

                    String date = ((Element) nodes.get(i))
                            .getElementsByClass("blockdate")
                            .get(0).childNodes().get(0).toString().trim();

                    String line = String.format("Тема: %s | Дата: %s", title, date);
                    System.out.println(line);
                    out.write(line);
                    out.newLine();
                }
            }
            System.out.println("Данные сохранены в файл: " + OUTPUT_FILE);

        } catch (IOException ioe) {
            System.err.println("Ошибка записи в файл: " + ioe.getMessage());
        }
    }

    private static Document fetchDocumentWithRetry(String url, int maxAttempts) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                return Jsoup.connect(url)
                        .timeout(5_000)
                        .userAgent("Mozilla/5.0 (compatible)")
                        .get();

            } catch (IOException e) {
                System.err.printf("Попытка %d: ошибка подключения (%s)%n",
                        attempt, e.getMessage());
                if (attempt < maxAttempts) {
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
        return null;
    }
}
