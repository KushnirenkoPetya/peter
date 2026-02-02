package sempractical;

import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class RockPaperScissors {
    static final String[] choices = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;

        while (running) {
            int rounds = 0;
            int score = 0;
            boolean startGame = false;

            System.out.println("\n=== ROCK-PAPER-SCISSORS ===");
            System.out.println("-- Головне меню --");
            System.out.println("1. Обрати рівень складності");
            System.out.println("2. Обрати власні налаштування");
            System.out.println("3. Вийти");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("--- Виберіть рівень складності ---");
                    System.out.println("1. Легкий (3 раунди)");
                    System.out.println("2. Середній (5 раундів)");
                    System.out.println("3. Складний (7 раундів)");

                    int difficulty = sc.nextInt();
                    sc.nextLine();

                    if (difficulty == 1) rounds = 3;
                    else if (difficulty == 2) rounds = 5;
                    else rounds = 7;

                    startGame = true;
                    break;

                case 2:
                    System.out.print("Введіть кількість раундів: ");
                    rounds = sc.nextInt();
                    sc.nextLine();
                    startGame = true;
                    break;

                case 3:
                    running = false;
                    System.out.println("Бувай!");
                    break;

                default:
                    System.out.println("Невірний вибір!");
            }

            if (startGame) {
                for (int i = 1; i <= rounds; i++) {
                    System.out.println("\nРаунд " + i);
                    System.out.println("0 - Rock | 1 - Paper | 2 - Scissors");
                    System.out.print("Ваш вибір: ");

                    int userChoice = getIntInput(sc);
                    if (userChoice < 0 || userChoice > 2) {
                        System.out.println("Невірний вибір! Пропускаємо раунд.");
                        continue;
                    }

                    int computerChoice = rand.nextInt(3);

                    System.out.println("Ви обрали: " + choices[userChoice]);
                    System.out.println("Комп'ютер обрав: " + choices[computerChoice]);

                    String result = getResult(userChoice, computerChoice);
                    System.out.println("Результат: " + result);

                    if (result.equals("You win!")) score++;
                }

                System.out.println("\n=== Підсумок ===");
                System.out.printf("Ви виграли %d з %d раундів\n", score, rounds);
                if (score > rounds / 2) System.out.println("Вітаю! Ви перемогли!");
                else System.out.println("На жаль, ви програли.");
            }
        }

        sc.close();
    }

    static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Будь ласка, введіть число: ");
        }
        return sc.nextInt();
    }

    static String getResult(int user, int computer) {
        if (user == computer) return "Draw";
        return ((user - computer + 3) % 3 == 1) ? "You win!" : "You lose!";
    }
}


