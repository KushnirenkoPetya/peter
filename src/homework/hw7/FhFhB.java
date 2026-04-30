package homework.hw7;

import java.util.Scanner;

public class FhFhB {
    public static void main (String[] args) {
        Scanner coc = new Scanner(System.in);
        System.out.println("Введите число 1");
        double num1 = coc.nextDouble();

        System.out.println("Введите число 2 ");
        double num2 = coc.nextDouble();

        double res1 = num1 + num2;
        double res2 = num1 / num2;

        System.out.println("Результат: ");
        System.out.println(res1 + "\n" + res2 + "\n" );






    }
}
