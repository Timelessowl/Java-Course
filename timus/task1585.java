import java.util.Scanner;

public class task1585 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int countEmperor = 0, countLittle = 0, countMacaroni = 0;
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            if (s.equals("Emperor Penguin")) {
                countEmperor++;
            } else if (s.equals("Little Penguin")) {
                countLittle++;
            } else if (s.equals("Macaroni Penguin")) {
                countMacaroni++;
            }
        }

        if (countEmperor > countLittle && countEmperor > countMacaroni) {
            System.out.println("Emperor Penguin");
        } else if (countLittle > countEmperor && countLittle > countMacaroni) {
            System.out.println("Little Penguin");
        } else if (countMacaroni > countEmperor && countMacaroni > countLittle) {
            System.out.println("Macaroni Penguin");
        }

        in.close();
    }
}
