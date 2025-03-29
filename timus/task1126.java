package timus;

import java.util.*;

public class task1126 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        List<Integer> measurements = new ArrayList<>();

        while (in.hasNextInt()) {
            int value = in.nextInt();
            if (value == -1) {
                break;
            }
            measurements.add(value);
        }

        int N = measurements.size();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            while (!deque.isEmpty() && measurements.get(deque.peekLast()) <= measurements.get(i)) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        StringBuilder output = new StringBuilder();

        for (int i = M; i < N; i++) {
            output.append(measurements.get(deque.peekFirst())).append("\n");

            while (!deque.isEmpty() && deque.peekFirst() <= i - M) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && measurements.get(deque.peekLast()) <= measurements.get(i)) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        output.append(measurements.get(deque.peekFirst())).append("\n");
        System.out.print(output);
        in.close();
    }
}
