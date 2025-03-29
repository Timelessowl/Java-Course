package lr3;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class linked_list {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        ListIterator<Integer> iterator = list.listIterator();
        while (list.size() > 1) {
            if (!iterator.hasNext()) {
                iterator = list.listIterator();
            }
            iterator.next();
            if (!iterator.hasNext()) {
                iterator = list.listIterator();
            }
            iterator.next();
            iterator.remove();
        }

        System.out.println("Последний оставшийся: " + list.getFirst());

        in.close();
    }
}
