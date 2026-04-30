package homework.hw10;

import java.util.Scanner;

public class SwCs {
    public static void main (String[] args){
            Scanner scan = new Scanner(System.in);
        System.out.println("Введите число");
            int day = scan.nextInt();
            switch (day) {
                case 1 :
                    System.out.println("Понедельник");
                    break;
                case 2 :
                    System.out.println("Вторник ");
                    break;
                case 3:
                System.out.println("Среда ");
                break;
                default:
                    System.out.println("Другой день");


            }
    }
}
