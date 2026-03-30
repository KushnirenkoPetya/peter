package sempractical3;

import java.util.Scanner;

public class DoTa {
    public static void main(String[] args) {
        System.out.println("Information about primitive data types");
        System.out.println("");
        System.out.println("Цілочисельні");
        System.out.println("byte");
        System.out.println("short");
        System.out.println("int");
        System.out.println("long");
        System.out.println("");
        System.out.println("З плавоючою комою");
        System.out.println("float");
        System.out.println("double");
        System.out.println("");
        System.out.println("Символи");
        System.out.println("char");
        System.out.println("");
        System.out.println("Логічні");
        System.out.println("boolean");
        System.out.println("Ввведите тип данных");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        if (type.equals("byte")) {
            System.out.println("Размер " + Byte.BYTES + " байт");
        } else if (type.equals("short")) {
            System.out.println("Размер " + Short.BYTES + " байт");
        } else if (type.equals("int")) {
            System.out.println("Размер " + Integer.BYTES + " байт");
        } else if (type.equals("long")) {
            System.out.println("Размер " + Long.BYTES + " байт");
        } else if (type.equals("float")) {
            System.out.println("Размер " + Float.BYTES + " байт");
        } else if (type.equals("double")) {
            System.out.println("Размер " + Double.BYTES + " байт");
        } else if (type.equals("char")) {
            System.out.println("Размер " + Character.BYTES + " байт");
        } else if (type.equals("boolean")) {
            System.out.println("Размер 1 логічне значення");
        } else {
            System.out.println("Неизвестный тип данных");
        }
    }
}