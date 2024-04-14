import Generator.Generator;
import Generator.ShuffledIntegerArrayGenerator;

import java.util.*;

public class main {

    private static Random random = new Random();
    private static double averageTime1 = 0.0;
    private static double averageTimeSquared1 = 0.0;
    private static double averageTime2 = 0.0;
    private static double averageTimeSquared2 = 0.0;

    public static void main(String[] args) {
        int size = 10000;
        int repetitions = 20;
        Comparator<Integer> comparator = new IntegerComparator();
//        Generator<Integer> generator = new OrderedIntegerArrayGenerator();
        Generator<Integer> generator = new ShuffledIntegerArrayGenerator();
//        Generator<Integer> generator = new ReversedIntegerArrayGenerator();
        PriorityQueueSorter<Integer> sorter = new PriorityQueueSorter<>(new ArrayHeap<>(10,comparator));


        ArrayHeap<Integer> heap1 = new ArrayHeap<Integer>(10,new IntegerComparator());
        TreeHeap<Integer> heap2 = new TreeHeap<Integer>(new IntegerComparator());

        randomInt(heap1,heap2,10);

        List<Integer> list = generator.generate(10);
        System.out.println("PRZED SORTOWANIEM ARRAYHEAP");
        printList(list);
        System.out.println("\n------------------------");
        System.out.println("PO SORTOWANIU ARRAYHEAP");
        printList(sorter.sort(list));
        System.out.println("\n------------------------");
        sorter = new PriorityQueueSorter<>(new TreeHeap<>(comparator));
        list = generator.generate(10);
        System.out.println("PRZED SORTOWANIEM TREEHEAP:");
        printList(list);
        System.out.println("\n------------------------");
        System.out.println("PO SORTOWANIU TREEHEAP:");
        printList(sorter.sort(list));

        measureTime(size,repetitions,generator,comparator);

        System.out.println("\n------------------------");

        System.out.println("SORTOWANIE DLA ARRAYHEAP");
        printStatistic("time [ms]", averageTime1, calculateStdDev(averageTime1,averageTimeSquared1));

        System.out.println("\n------------------------");


        System.out.println("SORTOWANIE DLA TREEHEAP");
        printStatistic("time [ms]", averageTime2, calculateStdDev(averageTime2,averageTimeSquared2));

    }

    public static <T> void printList(List<T> list){
        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private static String double2String(double value) {
        return String.format("%.12f", value);
    }

    private static void randomInt(ArrayHeap<Integer> heap1, TreeHeap<Integer> heap2, int size){
        int x;
        for(int i = 0; i < size; i++){
            x = random.nextInt(-1000000000,1000000000);
            heap1.add(x);
            heap2.add(x);
        }
    }

    private static <T> void compare(ArrayHeap<T> heap1, TreeHeap<T> heap2){
        System.out.println("\n----------------");
        heap1.printHeap();
        System.out.println("\n----------------");
        heap2.printHeap();
        while(!heap1.isEmpty() && !heap2.isEmpty()){
            System.out.println("\n----------------");
            heap1.minimum();
            heap1.printHeap();
            System.out.println("\n----------------");
            heap2.minimum();
            heap2.printHeap();
        }
    }

    private static double updatedAverage(double average, double value, int n) {
        return average + (value - average) / n;
    }

    private static double calculateStdDev(double average, double averagedSquares) {
        return Math.sqrt(averagedSquares - (average * average));
    }
    private static void measureTime(int size, int repetitions, Generator<Integer> generator, Comparator<Integer> comparator){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        RunResult result1;
        RunResult result2;
        for(int i = 1; i <= repetitions; i++) {
            list1.clear();
            list2.clear();
            list1 = generator.generate(size);
            list2.addAll(list1);

            result1 = Tester.runOnce(size,new ArrayHeap<Integer>(size, comparator), list1);
            result2 = Tester.runOnce(size,new TreeHeap<Integer>(comparator), list2);

            averageTime1 = updatedAverage(averageTime1, result1.timeInMilliseconds(), i);
            averageTimeSquared1 = updatedAverage(averageTimeSquared1,
                    (double)result1.timeInMilliseconds() * (double) result1.timeInMilliseconds(), i);
            averageTime2 = updatedAverage(averageTime2, result2.timeInMilliseconds(), i);
            averageTimeSquared2 = updatedAverage(averageTimeSquared2,
                    (double)result2.timeInMilliseconds() * (double) result2.timeInMilliseconds(), i);
        }
    }
}
