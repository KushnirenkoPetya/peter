package practical10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();

        while (true) {
            System.out.println("\n1 - Додати");
            System.out.println("2 - Видалити");
            System.out.println("3 - Увійти");
            System.out.println("0 - Вихід");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Username: ");
                        String u = sc.nextLine();

                        System.out.print("Password: ");
                        String p = sc.nextLine();

                        manager.addUser(u, p);
                        break;

                    case 2:
                        System.out.print("Username: ");
                        String del = sc.nextLine();

                        manager.deleteUser(del);
                        break;

                    case 3:
                        System.out.print("Username: ");
                        String au = sc.nextLine();

                        System.out.print("Password: ");
                        String ap = sc.nextLine();

                        manager.authenticate(au, ap);
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println("Невірний вибір!");
                }

            } catch (UserLimitException |
                     InvalidUsernameException |
                     InvalidPasswordException |
                     UserNotFoundException |
                     AuthenticationException e) {

                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }
}
