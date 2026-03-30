package practical14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX_ENTRIES = 50;

        String[] dates = new String[MAX_ENTRIES]; // хранит даты
        String[] texts = new String[MAX_ENTRIES]; // хранит тексты
        int count = 0;

        boolean running = true;
        while (running) {
            System.out.println("\n=== Мій щоденник ===");
            System.out.println("1 - Додати запис");
            System.out.println("2 - Видалити запис");
            System.out.println("3 - Переглянути усі записи");
            System.out.println("4 - Вийти");
            System.out.print("Вибір: ");

            int choice = getInt(sc);

            if (choice == 1) { // Додати запис
                if (count >= MAX_ENTRIES) {
                    System.out.println("Досягнуто максимум записів!");
                    continue;
                }

                System.out.print("Введіть дату (YYYY-MM-DD): ");
                sc.nextLine(); // очистка буфера
                String date = sc.nextLine();
                if (!isValidDate(date)) {
                    System.out.println("Невірний формат дати!");
                    continue;
                }

                System.out.print("Введіть текст запису: ");
                String text = sc.nextLine();

                dates[count] = date;
                texts[count] = text;
                count++;
                System.out.println("Запис додано!");

            } else if (choice == 2) { // Видалити запис
                System.out.print("Введіть дату для видалення (YYYY-MM-DD): ");
                sc.nextLine();
                String date = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (dates[i].equals(date)) {
                        for (int j = i; j < count - 1; j++) {
                            dates[j] = dates[j + 1];
                            texts[j] = texts[j + 1];
                        }
                        dates[count - 1] = null;
                        texts[count - 1] = null;
                        count--;
                        found = true;
                        System.out.println("Запис видалено!");
                        break;
                    }
                }
                if (!found) System.out.println("Запис з такою датою не знайдено!");

            } else if (choice == 3) { // Показати всі записи
                if (count == 0) {
                    System.out.println("Щоденник порожній!");
                } else {
                    System.out.println("=== Усі записи ===");
                    for (int i = 0; i < count; i++) {
                        System.out.println(dates[i] + ": " + texts[i]);
                    }
                }

            } else if (choice == 4) { // Вихід
                running = false;
                System.out.println("Бувай!");
            } else {
                System.out.println("Невірний вибір!");
            }
        }

        sc.close();
    }

    static int getInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Будь ласка, введіть число: ");
        }
        return sc.nextInt();
    }

    // Простая проверка формата даты (YYYY-MM-DD)
    static boolean isValidDate(String date) {
        if (date.length() != 10) return false;
        if (date.charAt(4) != '-' || date.charAt(7) != '-') return false;
        for (int i = 0; i < 10; i++) {
            if (i == 4 || i == 7) continue;
            if (date.charAt(i) < '0' || date.charAt(i) > '9') return false;
        }
        return true;
    }
}
