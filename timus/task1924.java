import java.util.Scanner;

public class task1924 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n % 4 == 0 || n % 4 == 3) {
            System.out.println("black");
        } else {
            System.out.println("grimy");
        }

        in.close();
    }
}
