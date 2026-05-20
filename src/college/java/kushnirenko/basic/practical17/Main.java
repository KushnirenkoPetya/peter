package college.java.kushnirenko.basic.practical17;

public class Main {

    public static void main(String[] args) {

        MyList list = new MyList();


        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.add(1, "Mango");

        System.out.println("Список:");

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(i + ": " + list.get(i));
        }

        list.remove(2);
        System.out.println("\nПісля видалення:");

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
        System.out.println("\nКількість елементів: " + list.getSize());
        System.out.println("Розмір буфера: " + list.getCapacity());
    }
}