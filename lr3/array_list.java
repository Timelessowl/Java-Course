package lr3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class array_list {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + 2) % list.size();
            list.remove(index);
        }

        System.out.println("Последний оставшийся: " + list.get(0));

        in.close();
    }
}
