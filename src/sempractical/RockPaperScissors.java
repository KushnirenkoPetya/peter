package sempractical;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static String[] choices = {"Rock", "Scissors", "Paper"};

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int menuChoice = getIntInput();

            switch (menuChoice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    System.out.println("Exiting the game...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid menu option.");
            }
        }
    }
    static void showMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
    }
    static void startGame() {
        boolean playing = true;

        while (playing) {
            System.out.println("\n=== GAME SCENE ===");
            System.out.println("0. Rock");
            System.out.println("1. Scissors");
            System.out.println("2. Paper");
            System.out.print("Your choice: ");

            int userChoice = getIntInput();

            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            int computerChoice = random.nextInt(3);

            System.out.println("You chose: " + choices[userChoice]);
            System.out.println("Computer chose: " + choices[computerChoice]);
            System.out.println("Result: " + getResult(userChoice, computerChoice));

            System.out.println("\n1. Play again");
            System.out.println("2. Back to menu");
            System.out.print("Choose an option: ");

            int next = getIntInput();
            if (next != 1) {
                playing = false;
            }
        }
    }

    static String getResult(int user, int computer) {
        if (user == computer) {
            return "Draw";
        }

        if ((user == 0 && computer == 1) ||
                (user == 1 && computer == 2) ||
                (user == 2 && computer == 0)) {
            return "You win!";
        }

        return "You lose!";
    }
    static int getIntInput() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a number: ");
        }
        return scanner.nextInt();
    }
}

