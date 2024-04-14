import Comparators.OrderedIntegerComparator;
import Comparators.Student;
import Comparators.StudentComparator;
import HashFunctions.Example;
import HashFunctions.StudentHashFunction;
import HashTable.OpenAddressingHashTable;
import HashTable.SeparateChainingHashTable;
import IncrementalFunction.Kwadratowe;
import IncrementalFunction.Przyrostowe;

import java.util.*;

public class main {

    public static void main(String[] args) {
        int size = 1000;
        double maxLoad = 0.9;

        OpenAddressingHashTable<Integer> h1 = new OpenAddressingHashTable<Integer>(maxLoad, new OrderedIntegerComparator(), new Example(), new Przyrostowe<Integer>());

        OpenAddressingHashTable<Integer> h2 = new OpenAddressingHashTable<Integer>(maxLoad, new OrderedIntegerComparator(), new Example(), new Kwadratowe<Integer>());

        SeparateChainingHashTable<Integer> h3 = new SeparateChainingHashTable<Integer>(maxLoad, new OrderedIntegerComparator(), new Example());


//        OpenAddressingHashTable<Integer> h1 = new OpenAddressingHashTable<Integer>(maxLoad, new OrderedIntegerComparator<Integer>(), new NewIntegerHashFunction<>(), new Przyrostowe<Integer>());
//
//        OpenAddressingHashTable<Integer> h2 = new OpenAddressingHashTable<Integer>(maxLoad, new OrderedIntegerComparator<Integer>(),new NewIntegerHashFunction<>(), new Kwadratowe<Integer>());
//
//        SeparateChainingHashTable<Integer> h3 = new SeparateChainingHashTable<Integer>(maxLoad, new OrderedIntegerComparator<Integer>(), new NewIntegerHashFunction<>());

        int[] array = randomIntArray(size);

        for(int i = 0 ; i < array.length; i++){
            h1.insert(array[i]);
            h2.insert(array[i]);
            h3.insert(array[i]);
        }

        System.out.println(h1.statics());
        System.out.println(h2.statics());
        System.out.println(h3.statics());


        OpenAddressingHashTable<Student> s1 = new OpenAddressingHashTable<Student>(maxLoad, new StudentComparator(),new StudentHashFunction(), new Przyrostowe<Student>());

        int[] grades = new int[]{2,3,5};
        int[] grades2 = new int[]{2,3,5,2};
        s1.insert(new Student("Jan","Kowalski",20,grades));
        s1.insert(new Student("Jan","Kowalski",20,grades));
        s1.insert(new Student("Jan","Kowalski",20,grades));
        s1.insert(new Student("Kamil", "Nowak",24,grades));
        s1.insert(new Student("Kamil", "Nowak",24,grades));
        s1.insert(new Student("Ola", "Bujak",19,grades));

        System.out.println(s1);




    }

    public static int[] shuffleIntArray(int size){
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = i;
        }
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] randomIntArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt();
        }
        return array;
    }

    public static int[] randomArray(int size){
        int[] array = new int[size];
        Random random= new Random();
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt(0,5000);
        }
        return array;
    }
}
