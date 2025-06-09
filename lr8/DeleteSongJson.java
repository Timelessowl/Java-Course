package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

public class DeleteSongJson {

    private static final String FILE = "songs.json";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in, "UTF-8");
        System.out.print("Название песни для удаления: ");
        String titleKey = in.nextLine().trim();
        in.close();

        JSONObject root = (JSONObject) new JSONParser()
                .parse(new FileReader(FILE, StandardCharsets.UTF_8));
        JSONArray arr = (JSONArray) root.get("songs");

        boolean removed = false;
        for (Iterator<?> it = arr.iterator(); it.hasNext();) {
            JSONObject song = (JSONObject) it.next();
            if (titleKey.equalsIgnoreCase((String) song.get("title"))) {
                it.remove(); // Iterator.remove()
                removed = true;
                break;
            }
        }

        if (removed) {
            try (Writer w = new OutputStreamWriter(
                    new FileOutputStream(FILE), StandardCharsets.UTF_8)) {
                w.write(root.toJSONString());
            }
            System.out.println("Песня удалена.");
        } else {
            System.out.println("Песня не найдена.");
        }
    }
}
