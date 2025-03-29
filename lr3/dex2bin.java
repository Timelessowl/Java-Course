package lr3;

import java.util.Scanner;

public class dex2bin {
    public static String convert(int num) {
        if (num < 2) {
            return Integer.toString(num);
        } else {
            return convert(num / 2) + (num % 2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int dex_num = in.nextInt();

        System.out.println(convert(dex_num));
        in.close();

    }
}
