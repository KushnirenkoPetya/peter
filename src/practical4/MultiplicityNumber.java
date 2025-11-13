package college.java.kushnirenko.basic.practical4;

import java.util.Scanner;

public class MultiplicityNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter, min range:");
        int minRange = scanner.nextInt();
        System.out.print("Enter, max range: ");
        int maxRange = scanner.nextInt();
        System.out.print("Enter, simple number:");
        int simpleNumber = scanner.nextInt();
        if ( simpleNumber >= 10 | simpleNumber < 0) {
            System.out.println("Error!!! ");
        }
        else {
        System.out.println();
        for (int i = minRange; i <= maxRange; i++) {
            int multiplicityNumber = i % simpleNumber;
            if (multiplicityNumber == 0) {
                continue;
            }
            System.out.println("|" + i + "|");
        }1
        }
    }
}

