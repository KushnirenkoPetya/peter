package college.java.kushnirenko.basic.practical15;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int MAX_ENTRIES = 50;
        String[] dates = new String[MAX_ENTRIES];
        String[] texts = new String[MAX_ENTRIES];
        int count = 0;

        System.out.println("1 - Новый щоденник");
        System.out.println("2 - Загрузить щоденник из файла");
        int startChoice = sc.nextInt();
        sc.nextLine(); // очистка буфера

        if (startChoice == 2) {
            System.out.print("Введите путь к файлу: ");
            String path = sc.nextLine();
            count = loadDiary(path, dates, texts);
            System.out.println("Загружено " + count + " записей");
        }

        System.out.println("Выберите формат даты (пример: yyyy-MM-dd HH:mm): ");
        String dateFormat = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        boolean running = true;
        while (running) {
            System.out.println("\n=== Мій щоденник ===");
            System.out.println("1 - Додати запис");
            System.out.println("2 - Видалити запис");
            System.out.println("3 - Переглянути усі записи");
            System.out.println("4 - Вийти");
            System.out.print("Вибір: ");
            int choice = getInt(sc);

            if (choice == 1) {
                if (count >= MAX_ENTRIES) {
                    System.out.println("Досягнуто максимум записів!");
                    continue;
                }
                System.out.print("Введіть дату та час (" + dateFormat + "): ");
                String date = sc.nextLine();
                System.out.print("Введіть текст запису: ");
                String text = sc.nextLine();

                dates[count] = date;
                texts[count] = text;
                count++;
                System.out.println("Запис додано!");

            } else if (choice == 2) {
                System.out.print("Введіть дату для видалення: ");
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

            } else if (choice == 3) {
                if (count == 0) System.out.println("Щоденник порожній!");
                else {
                    System.out.println("=== Усі записи ===");
                    for (int i = 0; i < count; i++) {
                        System.out.println(dates[i] + ": " + texts[i]);
                    }
                }

            } else if (choice == 4) {
                System.out.print("Зберегти щоденник? (y/n): ");
                String save = sc.nextLine();
                if (save.equalsIgnoreCase("y")) {
                    System.out.print("Введіть шлях для збереження: ");
                    String path = sc.nextLine();
                    saveDiary(path, dates, texts, count);
                    System.out.println("Щоденник збережено!");
                }
                running = false;
            } else System.out.println("Невірний вибір!");
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
    static void saveDiary(String path, String[] dates, String[] texts, int count) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (int i = 0; i < count; i++) {
            bw.write(dates[i]);
            bw.newLine();
            bw.write(texts[i]);
            bw.newLine();
            bw.newLine(); // пустая строка для разделения записей
        }
        bw.close();
    }

    static int loadDiary(String path, String[] dates, String[] texts) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            dates[count] = line;
            if ((line = br.readLine()) != null) texts[count] = line;
            count++;
        }
        br.close();
        return count;
    }
}
