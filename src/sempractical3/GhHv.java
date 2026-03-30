package sempractical3;

import java.util.Scanner;

public class GhHv {
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

        System.out.println("Ввведите тип данных:");

        Scanner input = new Scanner(System.in);
        String type = input.nextLine();

        switch (type) {
            case "byte":
                System.out.println("Размер " + Byte.BYTES + " байт");
                break;
            case "short":
                System.out.println("Размер " + Short.BYTES + " байт");
                break;
            case "int":
                System.out.println("Размер " + Integer.BYTES + " байт");
                break;
            case "long":
                System.out.println("Размер " + Long.BYTES + " байт");
                break;
            case "float":
                System.out.println("Размер " + Float.BYTES + " байт");
                break;
            case "double":
                System.out.println("Размер " + Double.BYTES + " байт");
                break;
            case "char":
                System.out.println("Размер " + Character.BYTES + " байт");
                break;
            case "boolean":
                System.out.println("Размер 1 логічне значення");
                break;
            default:
                System.out.println("Неизвестный тип данных");
        }

        input.close();
    }
}