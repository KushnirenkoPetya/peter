package college.java.kushnirenko.basic.practical17;

public class Main {
    static void main(String[] args) {
        MyList myVec = new MyList();

        myVec.add("баба бу ");
        myVec.add("бу баба");
        System.out.println("элементов: " + myVec.getSize());
        System.out.println("в буфере: " + myVec.getCapacity());
    }
}