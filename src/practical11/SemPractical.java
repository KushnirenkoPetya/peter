package practical11;

import java.util.Random;
import java.util.Scanner;

class InvalidMenuChoiceException extends Exception {
    public InvalidMenuChoiceException(String message) { super(message); }
}

class InvalidRoundsException extends Exception {
    public InvalidRoundsException(String message) { super(message); }
}

class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) { super(message); }
}

class NotANumberException extends Exception {
    public NotANumberException(String message) { super(message); }
}

public class SemPractical {
    static final String[] choices = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;

        while (running) {
            try {
                int rounds = 0;
                int score = 0;
                boolean startGame = false;

                System.out.println("\n=== ROCK-PAPER-SCISSORS ===");
                System.out.println("-- Головне меню --");
                System.out.println("1. Обрати рівень складності");
                System.out.println("2. Обрати власні налаштування");
                System.out.println("3. Вийти");

                int choice = getIntInput(sc);

                switch (choice) {
                    case 1:
                        System.out.println("--- Виберіть рівень складності ---");
                        System.out.println("1. Легкий (3 раунди)");
                        System.out.println("2. Середній (5 раундів)");
                        System.out.println("3. Складний (7 раундів)");

                        int difficulty = getIntInput(sc);

                        switch (difficulty) {
                            case 1: rounds = 3; break;
                            case 2: rounds = 5; break;
                            case 3: rounds = 7; break;
                            default:
                                throw new InvalidMenuChoiceException("Невірна складність!");
                        }
                        startGame = true;
                        break;

                    case 2:
                        System.out.print("Введіть кількість раундів: ");
                        rounds = getIntInput(sc);
                        if (rounds <= 0) throw new InvalidRoundsException("Кількість раундів має бути більше 0!");
                        startGame = true;
                        break;

                    case 3:
                        running = false;
                        System.out.println("Бувай!");
                        continue;

                    default:
                        throw new InvalidMenuChoiceException("Невірний пункт меню!");
                }

                if (startGame) {
                    printRules();
                    for (int i = 1; i <= rounds; i++) {
                        System.out.println("\nРаунд " + i);
                        System.out.println("0 - Rock | 1 - Paper | 2 - Scissors");
                        System.out.print("Ваш вибір: ");

                        int userChoice = getIntInput(sc);
                        if (userChoice < 0 || userChoice > 2)
                            throw new InvalidMoveException("Невірний хід! Введіть 0, 1 або 2.");

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

            } catch (NotANumberException e) {
                System.out.println(e.getMessage());
            } catch (InvalidMenuChoiceException e) {
                System.out.println(e.getMessage());
            } catch (InvalidRoundsException e) {
                System.out.println(e.getMessage());
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
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

    static String getResult(int user, int computer) {
        if (user == computer) return "Draw";
        return ((user - computer + 3) % 3 == 1) ? "You win!" : "You lose!";
    }

    static void printRules() {
        System.out.println("\n=== ПРАВИЛА ГРИ ROCK-PAPER-SCISSORS ===");
        System.out.println("1. Камінь (Rock) б'є ножиці (Scissors)");
        System.out.println("2. Ножиці (Scissors) ріжуть папір (Paper)");
        System.out.println("3. Папір (Paper) накриває камінь (Rock)");
        System.out.println("4. Якщо обидва вибрали одне і те ж, нічия");
        System.out.println("============================\n");
    }
}
