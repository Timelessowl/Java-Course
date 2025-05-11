package lr6;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 1; i <= 10; i++) {
            final int threadNumber = i;
            threads[i - 1] = new Thread(() -> {
                System.out.println("Поток " + threadNumber);
            });
        }

        for (Thread t : threads) {
            t.start();
            t.join();
        }
    }
}
