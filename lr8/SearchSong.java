package lr8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SearchSong {

    private static final String FILE = "songs.xml";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in, "UTF-8");
        System.out.print("Введите исполнителя ИЛИ год: ");
        String key = in.nextLine().trim();
        in.close();

        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File(FILE));
        NodeList list = doc.getElementsByTagName("song");

        IntStream.range(0, list.getLength())
                .mapToObj(list::item)
                .map(n -> (Element) n)
                .filter(el -> {
                    String artist = el.getElementsByTagName("artist")
                            .item(0).getTextContent();
                    String year = el.getElementsByTagName("year")
                            .item(0).getTextContent();
                    return artist.equalsIgnoreCase(key) || year.equals(key);
                })
                .forEach(SearchSong::printSong);
    }

    private static void printSong(Element song) {
        System.out.printf(
                "♪ %s — %s (%s)%n",
                song.getElementsByTagName("title").item(0).getTextContent(),
                song.getElementsByTagName("artist").item(0).getTextContent(),
                song.getElementsByTagName("year").item(0).getTextContent());
    }
}
