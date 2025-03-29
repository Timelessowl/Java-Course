package lr3;

public class linked_list_example {
    Node head;

    // ============================
    // Методы с использованием цикла
    // ============================

    public void createHead(int[] arr) {
        head = null;
        for (int value : arr) {
            head = new Node(value, head);
        }
    }

    public void createTail(int[] arr) {
        head = null;
        if (arr.length == 0)
            return;
        head = new Node(arr[0], null);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i], null);
            tail = tail.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value, null);
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Индекс за пределами списка");
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Индекс за пределами списка");
        }
        Node newNode = new Node(value, current.next);
        current.next = newNode;
    }

    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }
        head = head.next;
    }

    public void removeLast() {
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Индекс за пределами списка");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("Индекс за пределами списка");
            }
            current = current.next;
        }
        if (current.next == null) {
            throw new IndexOutOfBoundsException("Индекс за пределами списка");
        }
        current.next = current.next.next;
    }

    // ============================================
    // Методы с использованием рекурсии
    // ============================================

    public void createHeadRec(int[] arr) {
        head = _createHeadRec(arr, arr.length - 1);
    }

    private Node _createHeadRec(int[] arr, int index) {
        if (index < 0)
            return null;
        return new Node(arr[index], _createHeadRec(arr, index - 1));
    }

    public void createTailRec(int[] arr) {
        head = _createTailRec(arr, 0);
    }

    private Node _createTailRec(int[] arr, int index) {
        if (index >= arr.length)
            return null;
        Node node = new Node(arr[index], null);
        node.next = _createTailRec(arr, index + 1);
        return node;
    }

    public String toStringRec() {
        return _toStringRec(head);
    }

    private String _toStringRec(Node node) {
        if (node == null)
            return "";
        if (node.next == null)
            return Integer.toString(node.value);
        else
            return node.value + " -> " + _toStringRec(node.next);
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5 };

        linked_list_example list = new linked_list_example();

        System.out.println("Пример реализации с использованием циклов:");

        list.createHead(data);
        System.out.println("Ввод с головы: " + list.toString());

        list.createTail(data);
        System.out.println("Ввод с хвоста: " + list.toString());

        list.addFirst(0);
        System.out.println("После addFirst(0): " + list.toString());

        list.addLast(6);
        System.out.println("После addLast(6): " + list.toString());

        list.insert(3, 99);
        System.out.println("После insert(4, 20): " + list.toString());

        list.removeFirst();
        System.out.println("После removeFirst(): " + list.toString());

        list.removeLast();
        System.out.println("После removeLast(): " + list.toString());

        list.remove(2);
        System.out.println("После remove(2): " + list.toString());

        System.out.println("Пример реализации с использованием рекурсии:");

        list.createHeadRec(data);
        System.out.println("Ввод с головы: " + list.toString());

        list.createTailRec(data);
        System.out.println("Ввод с хвоста: " + list.toString());

        System.out.println("Вывод списка: " + list.toStringRec());
    }
}
