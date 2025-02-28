package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class task2012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int f = in.nextInt();
        boolean success = (12 - f) * 0.75 <= 4;

        out.println(success ? "YES" : "NO");
        out.flush();
        in.close();
    }
}
