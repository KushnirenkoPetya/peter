package college.java.kushnirenko.basic.practical21;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[] countSort(int[] array, int from, int to) {
        int range = to - from + 1;

        int[] count = new int[range];

        for (int i = 0; i < array.length; i++) {
            count[array[i] - from]++;
        }

        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[arrayIndex] = i + from;
                arrayIndex++;
            }
        }

        return array;
    }


    static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < current) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] =  current;
        }
        return array;
    }

    static int[] increaseSort(int[] array) {
        for (int iteration = 1; iteration < array.length - 1; iteration++) {
            for (int i = 0; i < array.length - iteration; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] array;

        System.out.println("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        System.out.println();
        System.out.println("Введіть діапазон значень");

        System.out.println("Від: ");
        int from = scanner.nextInt();

        System.out.println("До: ");
        int to = scanner.nextInt();

        array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(from, to);
        }
        System.out.println("Не відсортований масив:");
        System.out.println(Arrays.toString(array));
        System.out.println();

        System.out.printf("Виберіть спосіб сортування:%n1. Бульбашкове%n2. Вставкою%n3. Вибіркою%n4. Підрахунком");
        System.out.println();
        int choice = scanner.nextInt();

        LocalTime startTime = LocalTime.now();
        switch (choice) {
            case 1:
                increaseSort(array);
                break;
            case 2:
                insertionSort(array);
                break;
            case 3:
                selectionSort(array);
                break;
            case 4:
                countSort(array, from, to);
                break;
            default:
                System.out.println("Такого варіанту немає!!!");
                return;
        }
        LocalTime finishTime = LocalTime.now();

        Duration timeSpent = Duration.between(startTime, finishTime);

        System.out.printf("Було відсортовано " + size + " елементів за " + timeSpent.toMillis() + " мс (" + timeSpent.toNanos() + " нс)");
        System.out.println();

        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(array));
    }
}
