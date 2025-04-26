package timus;

import java.util.*;

public class task1290 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }
        List<Integer> b = transform(a);
        int[] bArr = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            bArr[i] = b.get(i);
        }
        List<Integer> c = transform(bArr);
        for (int x : c) {
            System.out.println(x);
        }
        in.close();
    }

    private static List<Integer> transform(int[] arr) {
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int idx = 0;
        for (int j = 0;; j++) {
            while (idx < n && arr[idx] <= j) {
                idx++;
            }
            if (idx >= n) {
                break;
            }
            res.add(n - idx);
        }
        return res;
    }
}
