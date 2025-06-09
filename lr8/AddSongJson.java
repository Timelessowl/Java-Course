package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Scanner;

public class AddSongJson {

    private static final String FILE = "lr8/songs.json";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in, "UTF-8");

        System.out.print("Название песни : ");
        String title = sc.nextLine();
        System.out.print("Исполнитель    : ");
        String artist = sc.nextLine();
        System.out.print("Год            : ");
        int year = Integer.parseInt(sc.nextLine());

        JSONObject root = loadOrCreate();
        JSONArray arr = (JSONArray) root.get("songs");

        JSONObject song = new JSONObject();
        song.put("title", title);
        song.put("artist", artist);
        song.put("year", year);

        arr.add(song);
        save(root);
        System.out.println("Песня добавлена!");
    }

    private static JSONObject loadOrCreate() throws Exception {
        File f = new File(FILE);
        if (f.exists()) {
            return (JSONObject) new JSONParser().parse(new FileReader(f, java.nio.charset.StandardCharsets.UTF_8));
        }
        JSONObject obj = new JSONObject();
        obj.put("songs", new JSONArray());
        return obj;
    }

    private static void save(JSONObject obj) throws Exception {
        try (Writer w = new OutputStreamWriter(new FileOutputStream(FILE),
                java.nio.charset.StandardCharsets.UTF_8)) {
            w.write(obj.toJSONString());
        }
    }
}
