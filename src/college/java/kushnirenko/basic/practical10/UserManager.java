package college.java.kushnirenko.basic.practical10;

public class UserManager {
    private User[] users = new User[15];

    // 🔸 Додавання
    public void addUser(String username, String password)
            throws UserLimitException, InvalidUsernameException, InvalidPasswordException {

        validateUsername(username);
        validatePassword(password);

        int index = findEmptySlot();
        if (index == -1) {
            throw new UserLimitException("Досягнуто максимум користувачів!");
        }

        users[index] = new User(username, password);
        System.out.println("Користувача додано!");
    }

    // 🔸 Видалення
    public void deleteUser(String username) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getUsername().equals(username)) {
                users[i] = null;
                System.out.println("Користувача видалено!");
                return;
            }
        }
        throw new UserNotFoundException("Користувача не знайдено!");
    }

    // 🔸 Аутентифікація
    public void authenticate(String username, String password)
            throws AuthenticationException {

        for (User user : users) {
            if (user != null &&
                    user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {

                System.out.println("Успішна аутентифікація!");
                return;
            }
        }
        throw new AuthenticationException("Невірний логін або пароль!");
    }

    // 🔸 Пошук вільного місця
    private int findEmptySlot() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) return i;
        }
        return -1;
    }

    // 🔸 Перевірка username
    private void validateUsername(String username)
            throws InvalidUsernameException {

        if (username.length() < 5) {
            throw new InvalidUsernameException("Ім'я менше 5 символів!");
        }

        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == ' ') {
                throw new InvalidUsernameException("Ім'я містить пробіл!");
            }
        }
    }

    // 🔸 Перевірка password
    private void validatePassword(String password)
            throws InvalidPasswordException {

        if (password.length() < 10) {
            throw new InvalidPasswordException("Пароль менше 10 символів!");
        }

        int digits = 0;
        boolean special = false;

        String forbidden[] = {"admin", "pass", "password", "qwerty", "ytrewq"};

        for (String word : forbidden) {
            if (password.contains(word)) {
                throw new InvalidPasswordException("Пароль містить заборонене слово!");
            }
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (c == ' ') {
                throw new InvalidPasswordException("Пароль містить пробіл!");
            }

            if (Character.isDigit(c)) digits++;

            if (!Character.isLetterOrDigit(c)) {
                special = true;
            }
        }

        if (digits < 3) {
            throw new InvalidPasswordException("Менше 3 цифр!");
        }

        if (!special) {
            throw new InvalidPasswordException("Немає спецсимвола!");
        }
    }
}