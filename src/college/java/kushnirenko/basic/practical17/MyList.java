package college.java.kushnirenko.basic.practical17;

public class MyList {
    private String[] elementData;
    private int size = 0;

    public class MyList {

        private String[] elementData;
        private int size;

        public MyList() {
            elementData = new String[10];
            size = 0;
        }

        // Додавання в кінець
        public void add(String element) {
            ensureCapacity();

            elementData[size] = element;
            size++;
        }

        // Додавання за індексом
        public void add(int index, String element) {
            checkPositionIndex(index);

            ensureCapacity();

            System.arraycopy(
                    elementData,
                    index,
                    elementData,
                    index + 1,
                    size - index
            );

            elementData[index] = element;
            size++;
        }

        // Видалення за індексом
        public void remove(int index) {
            checkElementIndex(index);

            int moved = size - index - 1;

            if (moved > 0) {
                System.arraycopy(
                        elementData,
                        index + 1,
                        elementData,
                        index,
                        moved
                );
            }

            size--;
            elementData[size] = null;
        }

        // Отримання елемента
        public String get(int index) {
            checkElementIndex(index);

            return elementData[index];
        }

        // Кількість елементів
        public int getSize() {
            return size;
        }

        // Розмір буфера
        public int getCapacity() {
            return elementData.length;
        }

        // Збільшення буфера
        private void ensureCapacity() {
            if (size == elementData.length) {
                grow();
            }
        }

        private void grow() {
            int newCapacity = elementData.length * 2;

            String[] newArray = new String[newCapacity];

            System.arraycopy(
                    elementData,
                    0,
                    newArray,
                    0,
                    elementData.length
            );

            elementData = newArray;
        }

        // Перевірка індекса
        private void checkElementIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(
                        "Невірний індекс: " + index
                );
            }
        }

        private void checkPositionIndex(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException(
                        "Невірний індекс: " + index
                );
            }
        }
    }