package college.java.kushnirenko.basic.practical17;

public class CustomList<T> {

    private Node<T> head;
    private int size;


    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


    public void add(T element) {

        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {

            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }


    public void add(int index, T element) {

        checkPositionIndex(index);

        Node<T> newNode = new Node<>(element);

        if (index == 0) {

            newNode.next = head;
            head = newNode;

        } else {

            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }


    public T remove(int index) {

        checkElementIndex(index);

        T removedData;

        if (index == 0) {

            removedData = head.data;
            head = head.next;

        } else {

            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            removedData = current.next.data;
            current.next = current.next.next;
        }

        size--;

        return removedData;
    }

    public T get(int index) {

        checkElementIndex(index);

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        return size;
    }


    public int capacity() {
        return size;
    }


    private void checkElementIndex(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException(
                    "Неправильний індекс: " + index
            );
        }
    }


    private void checkPositionIndex(int index) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException(
                    "Неправильний індекс: " + index
            );
        }
    }


    public void printList() {

        Node<T> current = head;

        System.out.print("[ ");

        while (current != null) {

            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println("]");
    }
}