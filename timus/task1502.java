import java.util.Scanner;

public class task1502 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long maxPoints = in.nextLong();
        long diamondsNeeded = maxPoints * (maxPoints + 1) * (maxPoints + 2) / 2;
        System.out.println(diamondsNeeded);
        in.close();
    }
}
