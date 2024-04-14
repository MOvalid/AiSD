import java.util.AbstractList;

public class Test {

    public static void main(String[] args) {
        TwoWayArrayLinkedList<String> lista1 = new TwoWayArrayLinkedList<String>(3);

        lista1.add("A");
        lista1.add("B");
        lista1.add("C");
        lista1.add("D");
        lista1.add("E");
        lista1.add("F");
        lista1.add("G");
        lista1.add("H");
        lista1.add("I");
        lista1.printList();

        System.out.println("---------------");

        lista1.add(0,"GA");
        lista1.printList();

        System.out.println("---------------");

        String replaced = lista1.set(1,"AA");
        System.out.println("Zwrócono " + replaced);
        lista1.printList();

        System.out.println("---------------");

        lista1.remove(5);
        lista1.printList();

        System.out.println("---------------");

        lista1.remove("F");
        lista1.printList();

        System.out.println("---------------");
        System.out.println("Rozmiar: " + lista1.size());
        System.out.println("End capacity: " + lista1.endCapacity());
        System.out.println("Capacity: " + lista1.capacity());

        System.out.println("---------------");

        lista1.defragment();
        lista1.printList();

        System.out.println("---------------");
        System.out.println("Rozmiar: " + lista1.size());
        System.out.println("End capacity: " + lista1.endCapacity());
        System.out.println("Capacity: " + lista1.capacity());

        System.out.println("---------------");

        TwoWayArrayLinkedList<Integer> i = new TwoWayArrayLinkedList<>(3);

        System.out.println("Rozmiar: " + i.size());
        System.out.println("End capacity: " + i.endCapacity());
        System.out.println("Capacity: " + i.capacity());

        System.out.println("---------------");

        i.add(0,34);
        i.printList();

        System.out.println("---------------");

        i.remove(0);
        System.out.println("Rozmiar: " + i.size());
        System.out.println("End capacity: " + i.endCapacity());
        System.out.println("Capacity: " + i.capacity());

        System.out.println("---------------");

        i.add(0,78);
        i.printList();

        System.out.println("---------------");

        System.out.println("Rozmiar: " + i.size());
        System.out.println("End capacity: " + i.endCapacity());
        System.out.println("Capacity: " + i.capacity());

        System.out.println("---------------");

        System.out.println("Rozmiar: " + i.size());
        System.out.println("End capacity: " + i.endCapacity());
        System.out.println("Capacity: " + i.capacity());


    }

}
