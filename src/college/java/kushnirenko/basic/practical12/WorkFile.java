package college.java.kushnirenko.basic.practical12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// === Власні виключення ===
class InvalidMenuChoiceException extends Exception {
    public InvalidMenuChoiceException(String message) { super(message); }
}

class FileAccessException extends Exception {
    public FileAccessException(String message) { super(message); }
}

class NotANumberException extends Exception {
    public NotANumberException(String message) { super(message); }
}

public class WorkFile {
    static final String FILE_NAME = "file.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                printMenu();
                int choice = getIntInput(sc);

                switch (choice) {
                    case 1:
                        writeToFile(sc);
                        break;
                    case 2:
                        readFromFile();
                        break;
                    case 3:
                        running = false;
                        System.out.println("Вихід з редактора...");
                        break;
                    default:
                        throw new InvalidMenuChoiceException("Невірний вибір меню!");
                }

            } catch (InvalidMenuChoiceException e) {
                System.out.println(e.getMessage());
            } catch (FileAccessException e) {
                System.out.println("Помилка роботи з файлом: " + e.getMessage());
            } catch (NotANumberException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n=== Простий текстовий редактор ===");
        System.out.println("1. Записати до файлу");
        System.out.println("2. Прочитати увесь вміст файлу");
        System.out.println("3. Вийти");
        System.out.print("Ваш вибір: ");
    }

    static int getIntInput(Scanner sc) throws NotANumberException {
        try {
            int value = sc.nextInt();
            sc.nextLine();
            return value;
        } catch (java.util.InputMismatchException e) {
            sc.nextLine();
            throw new NotANumberException("Потрібно ввести число!");
        }
    }

    static void writeToFile(Scanner sc) throws FileAccessException {
        System.out.print("Введіть рядок для запису у файл: ");
        String input = sc.nextLine();

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true); // true = дозапис
            writer.write(input + "\n");
            writer.close();
            System.out.println("Запис успішно виконано!");
        } catch (IOException e) {
            throw new FileAccessException(e.getMessage());
        }
    }

    static void readFromFile() throws FileAccessException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Файл ще не існує.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\n=== Вміст файлу ===");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            System.out.println("==================");
        } catch (IOException e) {
            throw new FileAccessException(e.getMessage());
        }
    }
}
