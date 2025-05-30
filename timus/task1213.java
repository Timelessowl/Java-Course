package timus;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class task1213 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String root = in.nextLine().trim();
        Set<String> vertices = new HashSet<>();
        vertices.add(root);
        while (true) {
            String line = in.nextLine().trim();
            if (line.equals("#"))
                break;
            String[] parts = line.split("-");
            vertices.add(parts[0]);
            vertices.add(parts[1]);
        }
        in.close();
        System.out.println(vertices.size() - 1);
    }
}
