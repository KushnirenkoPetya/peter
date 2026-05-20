package college.java.kushnirenko.basic.practical18;

public class MainArrayList {

    public static void main(String[] args) {
        MyList list = new MyList();

        list.add("САШКО");
        list.add("ОЛЯ");
        list.add("ІВАН");

        list.add(1, "Марія");

        System.out.println("Список після додавання:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(i + ": " + list.get(i));
        }

        list.remove(2);

        System.out.println("\nСписок після видалення:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(i + ": " + list.get(i));
        }

        System.out.println("\nКількість елементів: " + list.getSize());
        System.out.println("Розмір буфера: " + list.getCapacity());
    }
}
