import core.*;
import testing.MarkedValue;
import testing.Result;
import testing.Tester;
import testing.comparators.IntegerComparator;
import testing.comparators.MarkedValueComparator;
import testing.generation.*;
import testing.generation.conversion.MarkingGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> integers = new ArrayList<>();
//        integers.add(7);
//        integers.add(2);
//        integers.add(5);
//        integers.add(0);
//        integers.add(3);
//        integers.add(1);
//        integers.add(4);
//        integers.add(6);
//        printList(integers);
//        BinarySearchSorting<Integer> b = new BinarySearchSorting<>(new IntegerComparator());
//        b.sort(integers);
//        printList(integers);

//        List<Integer> integers1 = new ArrayList<>();
//        integers1.add(7);
//        integers1.add(6);
//        integers1.add(7);
//        integers1.add(6);
//        integers1.add(7);
//        integers1.add(6);
//        integers1.add(7);
//        integers1.add(6);
//        integers1.add(7);
//        integers1.add(6);
//        integers1.add(7);
//        integers1.add(6);
//
//
//        printList(integers1);
//        BinarySearchSorting<Integer> b1 = new BinarySearchSorting<>(new IntegerComparator());
//        b1.sort(integers1);
//        printList(integers1);


        int size = 10000;
        int repetitions = 20;

        System.out.println("SELECTION SORT STATISTICS");
        Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        Generator<MarkedValue<Integer>> generator = new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator());

        SortingAlgorithm<MarkedValue<Integer>> algorithm = new SelectionMinMaxSort<MarkedValue<Integer>>(markedComparator);

        Result result = Tester.runNTimes(algorithm, generator, size, repetitions);


        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());

        System.out.println("\n-------------------");

        System.out.println("BUBBLE SORT STATISTICS");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        generator = new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator());

        algorithm = new BubbleSort<>(markedComparator);

        result = Tester.runNTimes(algorithm, generator, size, repetitions);

        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());

        System.out.println("\n-------------------");

        System.out.println("BINARY SEARCH STATISTICS");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        generator = new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator());

        algorithm = new BinarySearchSorting<>(markedComparator);

        result = Tester.runNTimes(algorithm, generator, size, repetitions);

        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());


        System.out.println("\n-------------------");
        System.out.println("SHAKER SORT STATISTICS");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        generator = new MarkingGenerator<Integer>(new ReversedIntegerArrayGenerator());

        algorithm = new ShakerSort<>(markedComparator);

        result = Tester.runNTimes(algorithm, generator, size, repetitions);

        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());
    }

    private static void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private static String double2String(double value) {
        return String.format("%.12f", value);
    }

    public static void printList(List list){
        Iterator i = list.iterator();
        System.out.println("\n-------------------");
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }
        System.out.println("\n-------------------");
    }
}
