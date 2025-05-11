package timus;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class task1079 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n;
        int maxn = 0;
        while ((n = in.nextInt()) != 0) {
            list.add(n);
            if (n > maxn)
                maxn = n;
        }
        in.close();
        int[] a = new int[maxn + 3];
        a[0] = 0;
        if (maxn >= 1)
            a[1] = 1;
        for (int i = 1; 2 * i <= maxn; i++) {
            a[2 * i] = a[i];
            if (2 * i + 1 <= maxn) {
                a[2 * i + 1] = a[i] + a[i + 1];
            }
        }
        int[] mx = new int[maxn + 3];
        int cur = 0;
        for (int i = 0; i <= maxn; i++) {
            if (a[i] > cur)
                cur = a[i];
            mx[i] = cur;
        }
        StringBuilder sb = new StringBuilder();
        for (int v : list) {
            sb.append(mx[v]).append('\n');
        }
        System.out.print(sb);
    }
}
