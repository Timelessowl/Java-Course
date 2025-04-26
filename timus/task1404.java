package timus;

import java.util.Scanner;

public class task1404 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String enc = in.nextLine();
        int len = enc.length();
        char[] dec = new char[len];

        int firstCv = enc.charAt(0) - 'a';
        int firstVal = (firstCv - 5 + 26) % 26;
        dec[0] = (char) (firstVal + 'a');

        for (int i = 1; i < len; i++) {
            int curCv = enc.charAt(i) - 'a';
            int prevCv = enc.charAt(i - 1) - 'a';
            int origVal = (curCv - prevCv + 26) % 26;
            dec[i] = (char) (origVal + 'a');
        }

        System.out.println(new String(dec));
        in.close();
    }
}
