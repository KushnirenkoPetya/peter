package college.java.kushnirenko.basic.practical19;


import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void increaseSort(int[] array) {
        for (int iteration = 1; iteration < array.length - 1; iteration++) {
            for (int i = 0; i < array.length - iteration; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    static void decreaseSort(int[] array) {
        for (int iteration = 1; iteration < array.length - 1; iteration++) {
            for (int i = 0; i < array.length - iteration; i++) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    static void main(String[] args) {
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

        System.out.println("Сортування за зростаням? (true/false)");
        boolean sorted = scanner.nextBoolean();
        System.out.println();

        LocalTime startTime = LocalTime.now();
        if (sorted) {
            increaseSort(array);
        } else decreaseSort(array);
        LocalTime finishTime = LocalTime.now();

        Duration timeSpent = Duration.between(startTime, finishTime);

        System.out.printf("Було відсортовано " + size + " елементів за " + timeSpent.toMillis() + " мс (" + timeSpent.toNanos() + " нс)");
        System.out.println();

        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(array));
    }
}
