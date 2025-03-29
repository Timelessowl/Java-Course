package lr3;

import java.util.*;

public class time {

    static final int N = 10000000;

    public static void main(String[] args) {

        System.out.println("=== ArrayList Operations ===");
        System.out.println("Add to Head: " + ArrayListAddToHead() + " ms");
        System.out.println("Add to Middle: " + ArrayListAddToMiddle() + " ms");
        System.out.println("Add to Tail: " + ArrayListAddToTail() + " ms");
        System.out.println("Remove from Head: " + ArrayListRemoveFromHead() + " ms");
        System.out.println("Remove from Middle: " + ArrayListRemoveFromMiddle() + " ms");
        System.out.println("Remove from Tail: " + ArrayListRemoveFromTail() + " ms");
        System.out.println("Get by Index (random accesses): " + ArrayListGetByIndex() + " ms");

        System.out.println("\n=== HashSet Operations ===");
        System.out.println("Add: " + HashSetAdd() + " ms");
        System.out.println("Remove (element 0): " + HashSetRemove(0) + " ms");
        System.out.println("Remove (element in middle): " + HashSetRemove(N / 2) + " ms");
        System.out.println("Remove (element tail): " + HashSetRemove(N - 1) + " ms");

        System.out.println("\n=== LinkedHashMap Operations ===");
        System.out.println("Add Head: " + LinkedHashMapAddHead() + " ms");
        System.out.println("Add: " + LinkedHashMapAdd() + " ms");
        System.out.println("Remove Head (first inserted key): " + LinkedHashMapRemoveHead() + " ms");
        System.out.println("Remove Middle (middle key): " + LinkedHashMapRemoveMiddle() + " ms");
        System.out.println("Remove Tail (last inserted key): " + LinkedHashMapRemoveTail() + " ms");
        System.out.println("Get by Index (middle element): " + LinkedHashMapGetByIndex() + " ms");
    }

    public static long ArrayListAddToHead() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
        long start = System.currentTimeMillis();
        list.add(0, 1);
        return System.currentTimeMillis() - start;
    }

    public static long ArrayListAddToMiddle() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
        long start = System.currentTimeMillis();
        int middle = list.size() / 2;
        list.add(middle, 1);
        return System.currentTimeMillis() - start;

    }

    public static long ArrayListAddToTail() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
        long start = System.currentTimeMillis();
        list.add(1);
        return System.currentTimeMillis() - start;
    }

    public static long ArrayListRemoveFromHead() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
        long start = System.currentTimeMillis();
        list.remove(0);
        return System.currentTimeMillis() - start;
    }

    public static long ArrayListRemoveFromMiddle() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
        long start = System.currentTimeMillis();
        int middle = list.size() / 2;
        list.remove(middle);
        return System.currentTimeMillis() - start;
    }

    public static long ArrayListRemoveFromTail() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
        long start = System.currentTimeMillis();
        list.remove(list.size() - 1);
        return System.currentTimeMillis() - start;
    }

    public static long ArrayListGetByIndex() {
        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));
        long start = System.currentTimeMillis();
        int index = (int) (Math.random() * list.size());
        int value = list.get(index);
        return System.currentTimeMillis() - start;
    }

    public static long HashSetAdd() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        long start = System.currentTimeMillis();
        set.add(0);
        return System.currentTimeMillis() - start;
    }

    public static long HashSetRemove(int element) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        long start = System.currentTimeMillis();
        set.remove(element);
        return System.currentTimeMillis() - start;
    }

    public static long LinkedHashMapAddHead() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i < N + 1; i++) {
            map.put(i, i);
        }
        long start = System.currentTimeMillis();
        LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<>();
        newMap.put(0, 0);
        newMap.putAll(map);
        return System.currentTimeMillis() - start;
    }

    public static long LinkedHashMapAdd() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }
        long start = System.currentTimeMillis();
        map.put(N + 1, N + 1);
        return System.currentTimeMillis() - start;
    }

    public static long LinkedHashMapRemoveHead() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }
        long start = System.currentTimeMillis();
        Integer firstKey = map.keySet().iterator().next();
        map.remove(firstKey);
        return System.currentTimeMillis() - start;
    }

    public static long LinkedHashMapRemoveMiddle() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }
        long start = System.currentTimeMillis();
        map.remove(N / 2);
        return System.currentTimeMillis() - start;
    }

    public static long LinkedHashMapRemoveTail() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }
        long start = System.currentTimeMillis();
        map.remove(N - 1);
        return System.currentTimeMillis() - start;
    }

    public static long LinkedHashMapGetByIndex() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }
        long start = System.currentTimeMillis();
        map.get(N * 1000 / 2);
        return System.currentTimeMillis() - start;
    }
}
