package lr6;

import java.util.Random;
import java.util.Arrays;

public class Task2 {
    public static int getMax(int[] arr) throws InterruptedException {
        int nproc = Runtime.getRuntime().availableProcessors();
        int chunkSize = arr.length / nproc;

        Thread[] threads = new Thread[nproc];
        int[] chunkMax = new int[nproc];
        for (int i = 0; i < nproc; i++) {
            final int threadId = i;

            threads[threadId] = new Thread(() -> {
                int start = threadId * chunkSize;
                int end = (threadId == nproc - 1) ? arr.length : (threadId + 1) * chunkSize;

                int max = arr[start];
                for (int j = start + 1; j < end; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                chunkMax[threadId] = max;
            });
            threads[i].start();
        }
        int max = chunkMax[0];
        System.out.println("Локальные максимумы: " + Arrays.toString(chunkMax));
        for (int i = 1; i < nproc; i++) {
            if (chunkMax[i] > max) {
                max = chunkMax[i];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("Массив: " + Arrays.toString(arr));
        try {
            int max = getMax(arr);
            System.out.println("Максимальное значение: " + max);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
