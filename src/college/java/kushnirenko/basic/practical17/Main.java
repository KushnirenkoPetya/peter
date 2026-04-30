package college.java.kushnirenko.basic.practical17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 Add");
            System.out.println("2 Add by index");
            System.out.println("3 Remove");
            System.out.println("4 Get");
            System.out.println("5 Size");
            System.out.println("6 Capacity");
            System.out.println("7 Print");
            System.out.println("0 Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> list.add(sc.nextInt());
                    case 2 -> list.add(sc.nextInt(), sc.nextInt());
                    case 3 -> list.remove(sc.nextInt());
                    case 4 -> System.out.println(list.get(sc.nextInt()));
                    case 5 -> System.out.println(list.size());
                    case 6 -> System.out.println(list.capacity());
                    case 7 -> list.print();
                    case 0 -> {
                        sc.close();
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
