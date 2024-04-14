import core.*;
import testing.MarkedValue;
import testing.Result;
import testing.Tester;
import testing.comparators.IntegerComparator;
import testing.comparators.MarkedValueComparator;
import testing.generation.Generator;
import testing.generation.OrderedIntegerArrayGenerator;
import testing.generation.RandomIntegerArrayGenerator;
import testing.generation.ReversedIntegerArrayGenerator;
import testing.generation.conversion.LinkedListGenerator;
import testing.generation.conversion.MarkingGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class main {

    public static void main(String[] args) {
//        List<Integer> a = new LinkedList<Integer>();
//
//        a.add(6);
//        a.add(2);
//        a.add(8);
//        a.add(30);
//        a.add(0);
//        a.add(1);
//        a.add(7);
//        a.add(4);
//        a.add(3);
//        printList(a);
//        MergeSort1<Integer> m = new MergeSort1<>(new IntegerComparator());
//        m.sort(a);
//        printList(a);

        int size = 10000;
        int repetitions = 20;

//        System.out.println("MERGE SORT STATISTICS FOR ARRAYLIST");
//        Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());
//
//        Generator<MarkedValue<Integer>> generator = new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(10));
//
//        SortingAlgorithm<MarkedValue<Integer>> algorithm = new MergeSort<>(markedComparator);
//
//        Result result = Tester.runNTimes(algorithm, generator, size, repetitions);
//
//
//        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
//        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
//        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());
//
//        System.out.println("always sorted: " + result.sorted());
//        System.out.println("always stable: " + result.stable());
//
//        System.out.println("\n---------------------");
//
//        System.out.println("MERGE SORT STATISTICS FOR LINKEDLIST");
//        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());
//
//        LinkedListGenerator<MarkedValue<Integer>> generatorLL = new LinkedListGenerator(new MarkingGenerator<>(new RandomIntegerArrayGenerator(10)));
//
//        algorithm = new MergeSort<>(markedComparator);
//
//        result = Tester.runNTimes(algorithm, generatorLL, size, repetitions);
//
//
//        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
//        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
//        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());
//
//        System.out.println("always sorted: " + result.sorted());
//        System.out.println("always stable: " + result.stable());
//
//        System.out.println("\n---------------------");

        System.out.println("MERGE SORT WITH QUEUE STATISTICS FOR ARRAYLIST");
        Comparator<MarkedValue<Integer>>  markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        Generator<MarkedValue<Integer>> generator = new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(10));

        SortingAlgorithm<MarkedValue<Integer>> algorithm = new MergeSort1<>(markedComparator);

        Result result = Tester.runNTimes(algorithm, generator, size, repetitions);


        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", ((MergeSort1<MarkedValue<Integer>>) algorithm).getSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());

        System.out.println("\n---------------------");

        System.out.println("MERGE SORT WITH QUEUE STATISTICS FOR LINKEDLIST");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        LinkedListGenerator<MarkedValue<Integer>> generatorLL = new LinkedListGenerator(new MarkingGenerator<>(new RandomIntegerArrayGenerator(10)));

        algorithm = new MergeSort1<>(markedComparator);

        result = Tester.runNTimes(algorithm, generatorLL, size, repetitions);


        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", ((MergeSort1<MarkedValue<Integer>>) algorithm).getSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());

//        System.out.println("\n---------------------");
//
//        System.out.println("NORMAL QUICK SORT STATISTICS FOR ARRAYLIST");
//        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());
//
//        generator = new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(10));
//
//        algorithm = new QuickSort<>(markedComparator,false);
//
//        result = Tester.runNTimes(algorithm, generator, size, repetitions);
//
//
//        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
//        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
//        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());
//
//        System.out.println("always sorted: " + result.sorted());
//        System.out.println("always stable: " + result.stable());
//
//        System.out.println("\n---------------------");
//
//        System.out.println("NORMAL QUICK SORT STATISTICS FOR LINKEDLIST");
//        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());
//
//        generatorLL = new LinkedListGenerator(new MarkingGenerator<>(new RandomIntegerArrayGenerator(10)));
//
//        algorithm = new QuickSort<>(markedComparator,false);
//
//        result = Tester.runNTimes(algorithm, generatorLL, size, repetitions);
//
//
//        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
//        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
//        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());
//
//        System.out.println("always sorted: " + result.sorted());
//        System.out.println("always stable: " + result.stable());

        System.out.println("\n---------------------");

        System.out.println("QUICK SORT LL FP STATISTICS FOR ARRAYLIST");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        generator = new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(10));

        algorithm = new QuickSortLL<>(markedComparator,new FirstPivot<>());

        result = Tester.runNTimes(algorithm, generator, size, repetitions);


        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", ((QuickSortLL<MarkedValue<Integer>>) algorithm).getSwaps()/(repetitions*(Math.log(size)/Math.log(2))) , result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());

        System.out.println("\n---------------------");

        System.out.println("QUICK SORT LL FP STATISTICS FOR LINKEDLIST");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        generatorLL = new LinkedListGenerator(new MarkingGenerator<>(new RandomIntegerArrayGenerator(10)));

        algorithm = new QuickSortLL<>(markedComparator,new FirstPivot<>());

        result = Tester.runNTimes(algorithm, generatorLL, size, repetitions);

        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", ((QuickSortLL<MarkedValue<Integer>>) algorithm).getSwaps()/(repetitions*(Math.log(size)/Math.log(2))), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());

        System.out.println("\n---------------------");

        System.out.println("QUICK SORT LL RP STATISTICS FOR ARRAYLIST");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        generator = new MarkingGenerator<Integer>(new RandomIntegerArrayGenerator(10));

        algorithm = new QuickSortLL<>(markedComparator,new RandomPivot<>());

        result = Tester.runNTimes(algorithm, generator, size, repetitions);


        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", ((QuickSortLL<MarkedValue<Integer>>) algorithm).getSwaps()/((Math.log(size)/Math.log(2))) , result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());

        System.out.println("\n---------------------");

        System.out.println("QUICK SORT LL RP STATISTICS FOR LINKEDLIST");
        markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        generatorLL = new LinkedListGenerator(new MarkingGenerator<>(new RandomIntegerArrayGenerator(10)));

        algorithm = new QuickSortLL<>(markedComparator,new RandomPivot<>());

        result = Tester.runNTimes(algorithm, generatorLL, size, repetitions);

        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", ((QuickSortLL<MarkedValue<Integer>>) algorithm).getSwaps()/(Math.log(size)/Math.log(2)), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());



    }

    private static void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private static String double2String(double value) {
        return String.format("%.12f", value);
    }


    public static<T> void printList(List<T> list){
        for(T t : list){
            System.out.print(t + " ");
        }
        System.out.println("\n-------------------");
    }
}
