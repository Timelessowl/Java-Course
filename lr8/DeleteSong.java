package lr8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class DeleteSong {

    private static final String FILE = "songs.xml";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in, "UTF-8");
        System.out.print("Название песни для удаления: ");
        String title = in.nextLine().trim();
        in.close();

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(new File(FILE));
        NodeList list = doc.getElementsByTagName("song");

        boolean removed = false;
        for (int i = 0; i < list.getLength(); i++) {
            Element song = (Element) list.item(i);
            String t = song.getElementsByTagName("title").item(0).getTextContent();
            if (t.equalsIgnoreCase(title)) {
                song.getParentNode().removeChild(song);
                removed = true;
                break;
            }
        }

        if (removed) {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.transform(new DOMSource(doc), new StreamResult(new File(FILE)));
            System.out.println("Удалено.");
        } else {
            System.out.println("Песня не найдена.");
        }
    }
}
