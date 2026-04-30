package homework.hw9;

import java.util.Scanner;

public class MaInIn {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите звание ");
        String rank = scan.nextLine();
        System.out.println("Введите код");
        String code = scan.nextLine();
        if (rank.equals("General") && code.equals("1234"))
           System.out.println("велком");
        else {
            System.out.println("ИДИ В ПИЗДУ");
        }

    }

}
