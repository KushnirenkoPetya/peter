package college.java.kushnirenko.basic.practical17;

public class MyList {
    private String[] elementData;
    private int size = 0;

    public MyList() {
        this.elementData = new String[10];
    }

    public void add(String element) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = element;
        size++;
    }

    public void add(int index, String element) {
        if (index < 0 || index > size) return;

        if (size == elementData.length) {
            grow();
        }

        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        elementData[index] = element;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) return;

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        size--;
        elementData[size] = null;
    }

    public void removeLast() {
        if (size > 0) {
            size--;
            elementData[size] = null;
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return elementData.length;
    }

    private void grow() {
        String[] newArray = new String[elementData.length + 1];
        System.arraycopy(elementData, 0, newArray, 0, elementData.length);
        elementData = newArray;
    }
}