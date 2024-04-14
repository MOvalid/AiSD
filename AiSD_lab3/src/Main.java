public class Main {
    public static void main(String[] args) {

        OneWayLinkedListWithSentinel<String> StringList = new OneWayLinkedListWithSentinel<>();

        StringList.add("Adrian");
        StringList.add("Kot");
        StringList.add("Krowa");
        StringList.add("Kaczka");


        System.out.println("Element o indeksie 0 " + StringList.get(0));
        System.out.println("Element o indeksie 1 " + StringList.get(1));
        System.out.println("----------------");
        printList(StringList);
        System.out.println("----------------");

        StringList.add(3,"Pies");
        System.out.println("Dodanie na indeksie 3 'Pies'");
        System.out.println("----------------");
        printList(StringList);
        System.out.println("----------------");
        System.out.println("Zamiana na indeksie 1. Z tego indeksu zwrócono " + StringList.set(1, "Mysz") + ", a jego zastąpiono " + StringList.get(1));
        System.out.println("----------------");
        printList(StringList);
        System.out.println("----------------");
        System.out.println("Słowo z indeksem 2: " + StringList.get(2));
        System.out.println("----------------");
        System.out.println("Przed odwróceniem");
        printList(StringList);
        System.out.println("----------");
        System.out.println("Po odwróceniu");
        StringList.reverse();
        printList(StringList);



        System.out.println("----------------");
        OneWayLinkedListWithSentinel<Integer> integers = new OneWayLinkedListWithSentinel<>();
        integers.add(9);
        integers.add(1);
        integers.add(3);
        integers.add(4);
        integers.add(2);
        integers.add(6);
        System.out.println("Przed odwróceniem");
        printList(integers);
        System.out.println("----------");
        System.out.println("Po odwróceniu");
        integers.reverse();
        printList(integers);
        System.out.println("----------");

        OneWayLinkedListWithSentinel<Integer> o = new OneWayLinkedListWithSentinel<>();
        o.add(0);
        o.add(1);
        System.out.println("Przed odwróceniem");
        printList(o);
        System.out.println("----------");
        System.out.println("Po odwróceniu");
        o.reverse();
        printList(o);
        System.out.println("----------");

        OneWayLinkedListWithSentinel<String> s = new OneWayLinkedListWithSentinel<>();
        s.add("AD");
        s.remove(0);
        printList(s);


    }

    private static void printList(OneWayLinkedListWithSentinel list){
       for(int i = 0; i < list.size(); i++){
           System.out.println(list.get(i));
       }
    }
}
