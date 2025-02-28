package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class task1409 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int garry_bottles = in.nextInt();
        int larry_bottles = in.nextInt();
        int total = garry_bottles + larry_bottles - 1;
        out.println((total - garry_bottles) + " " + (total - larry_bottles));
        out.flush();
        in.close();
    }
}
