package college.java.kushnirenko.basic.practical16;

import java.util.Scanner;

public class MaIn {
    public static void main(String[] args) {
        MyList list = new MyList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - Додати в кінець");
            System.out.println("2 - Додати за індексом");
            System.out.println("3 - Видалити за індексом");
            System.out.println("4 - Отримати елемент");
            System.out.println("5 - Розмір");
            System.out.println("6 - Буфер");
            System.out.println("7 - Вивести список");
            System.out.println("0 - Вихід");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Значення: ");
                        list.add(sc.nextInt());
                        break;

                    case 2:
                        System.out.print("Індекс: ");
                        int i = sc.nextInt();
                        System.out.print("Значення: ");
                        int v = sc.nextInt();
                        list.add(i, v);
                        break;

                    case 3:
                        System.out.print("Індекс: ");
                        list.remove(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Індекс: ");
                        System.out.println("Елемент: " + list.get(sc.nextInt()));
                        break;

                    case 5:
                        System.out.println("Розмір: " + list.size());
                        break;

                    case 6:
                        System.out.println("Буфер: " + list.capacity());
                        break;

                    case 7:
                        list.print();
                        break;

                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }
}
