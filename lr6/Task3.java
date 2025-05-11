package lr6;

import java.util.Random;
import java.util.Arrays;

public class Task3 {
    public static int getSum(int[] arr) throws InterruptedException {
        int nproc = Runtime.getRuntime().availableProcessors();
        int chunkSize = arr.length / nproc;

        Thread[] threads = new Thread[nproc];
        int[] chunkSum = new int[nproc];
        for (int i = 0; i < nproc; i++) {
            final int threadId = i;

            threads[threadId] = new Thread(() -> {
                int start = threadId * chunkSize;
                int end = (threadId == nproc - 1) ? arr.length : (threadId + 1) * chunkSize;

                int sum = 0;
                for (int j = start + 1; j < end; j++) {
                    sum += arr[j];
                }
                chunkSum[threadId] = sum;
            });
            threads[i].start();
        }
        int sum = 0;
        System.out.println("Локальные суммы: " + Arrays.toString(chunkSum));
        for (int i = 1; i < nproc; i++) {
            sum += chunkSum[i];
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("Массив: " + Arrays.toString(arr));
        try {
            int sum = getSum(arr);
            System.out.println("Сумма: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
