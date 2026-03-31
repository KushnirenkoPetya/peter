package sempractical.sempractical3;

import java.util.Scanner;

public class HfKd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите ваш возраст:");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.println("Доступ разрешен");
            System.out.println("Велком нахуй");
        } else {
            System.out.println("Доступ запрещен");
        }
        input.close();
    }
}