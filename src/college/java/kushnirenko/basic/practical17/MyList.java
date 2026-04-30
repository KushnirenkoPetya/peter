package college.java.kushnirenko.basic.practical17;

public class MyList {
    private int[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            int newCapacity = data.length * 2;
            int[] newData = new int[newCapacity];

            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public void add(int value) {
        ensureCapacity();
        data[size++] = value;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Невірний індекс");

        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Невірний індекс");

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        data[size] = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Невірний індекс");

        return data[index];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Список порожній");
            return;
        }

        System.out.print("Список: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}