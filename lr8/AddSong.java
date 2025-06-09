package lr8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class AddSong {

    private static final String FILE = "songs.xml";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in, "UTF-8");
        System.out.print("Название песни: ");
        String title = in.nextLine();
        System.out.print("Исполнитель  : ");
        String artist = in.nextLine();
        System.out.print("Год          : ");
        String year = in.nextLine();
        in.close();

        Document doc = loadOrCreateDoc();
        Element root = doc.getDocumentElement();

        Element song = doc.createElement("song");
        Element eTitle = doc.createElement("title");
        eTitle.setTextContent(title);
        Element eArt = doc.createElement("artist");
        eArt.setTextContent(artist);
        Element eYear = doc.createElement("year");
        eYear.setTextContent(year);

        song.appendChild(eTitle);
        song.appendChild(eArt);
        song.appendChild(eYear);
        root.appendChild(song);

        save(doc);
        System.out.println("Песня добавлена");
    }

    private static Document loadOrCreateDoc() throws Exception {
        File f = new File(FILE);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        if (f.exists()) {
            return db.parse(f);
        } else {
            Document doc = db.newDocument();
            doc.appendChild(doc.createElement("songs"));
            save(doc);
            return doc;
        }
    }

    private static void save(Document doc) throws Exception {
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File(FILE)));
    }
}
