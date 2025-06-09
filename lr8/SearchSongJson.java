package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SearchSongJson {

    private static final String FILE = "songs.json";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.print("Введите имя исполнителя: ");
        String artistKey = sc.nextLine().trim();

        JSONObject root = (JSONObject) new JSONParser()
                .parse(new FileReader(FILE, StandardCharsets.UTF_8));
        JSONArray arr = (JSONArray) root.get("songs");

        arr.stream()
                .filter(o -> o instanceof JSONObject)
                .map(o -> (JSONObject) o)
                .filter(o -> artistKey.equalsIgnoreCase((String) o.get("artist")))
                .forEach(SearchSongJson::printSong);
    }

    private static void printSong(JSONObject s) {
        System.out.printf("♪ %s — %s (%s)%n",
                s.get("title"), s.get("artist"), s.get("year"));
    }
}
