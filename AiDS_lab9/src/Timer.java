import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Timer {

    private static double insertTimeBST = 0.0;
    private static double insertTimeHBST = 0.0;
    private static double searchTimeBST = 0.0;
    private static double searchTimeHBST = 0.0;
    private static double removingTimeBST = 0.0;
    private static double removingTimeHBST = 0.0;

    public static void start(int size,int repetitions){
        Comparator<Integer> comparator = new IntegerComparator();
        BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>(comparator);
        HeapyBinarySearchTree<Integer> HBST = new HeapyBinarySearchTree<Integer>(comparator,comparator);
        String bst = "\nBINARY SEARCH TREE";
        String hbst = "HEAPY BINARY SEARCH TREE";

        List<Integer> list1 = generateList(size);
        for(int i = 0; i < repetitions; i++) {
            BST.clear();
            HBST.clear();
            Collections.shuffle(list1);
            insertBoth(list1, BST, HBST);
            Collections.shuffle(list1);
            searchBoth(list1, BST, HBST);
            Collections.shuffle(list1);
            removeBoth(list1, BST, HBST);
        }

        printStatistics(doubleToString(insertTimeBST/repetitions), bst,"INSERT");
        printStatistics(doubleToString(insertTimeHBST/repetitions), hbst,"INSERT");
        printStatistics(doubleToString(searchTimeBST/repetitions), bst,"SEARCHING");
        printStatistics(doubleToString(searchTimeHBST/repetitions), hbst,"SEARCHING");
        printStatistics(doubleToString(removingTimeBST/repetitions), bst,"REMOVING");
        printStatistics(doubleToString(removingTimeHBST/repetitions), hbst,"REMOVING");
    }

    public static void startOrdered(int size,int repetitions){
        Comparator<Integer> comparator = new IntegerComparator();
        BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>(comparator);
        HeapyBinarySearchTree<Integer> HBST = new HeapyBinarySearchTree<Integer>(comparator,comparator);
        String bst = "\nBINARY SEARCH TREE";
        String hbst = "HEAPY BINARY SEARCH TREE";

        List<Integer> list1 = generateOrderedList(size);
        for(int i = 0; i < repetitions; i++) {
            BST.clear();
            HBST.clear();
            insertBoth(list1, BST, HBST);
            searchBoth(list1, BST, HBST);
            removeBoth(list1, BST, HBST);
        }

        printStatistics(doubleToString(insertTimeBST/repetitions), bst,"INSERT");
        printStatistics(doubleToString(insertTimeHBST/repetitions), hbst,"INSERT");
        printStatistics(doubleToString(searchTimeBST/repetitions), bst,"SEARCHING");
        printStatistics(doubleToString(searchTimeHBST/repetitions), hbst,"SEARCHING");
        printStatistics(doubleToString(removingTimeBST/repetitions), bst,"REMOVING");
        printStatistics(doubleToString(removingTimeHBST/repetitions), hbst,"REMOVING");
    }

    public static List<Integer> generateList(int size){
        List<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    public static List<Integer> generateOrderedList(int size){
        List<Integer> list = new ArrayList<Integer>(size);
        for(int i = 0; i < size; i++){
            list.add(i);
        }
        return list;
    }

    private static void insertBoth(List<Integer> list, BinarySearchTree<Integer> BST, HeapyBinarySearchTree<Integer> HBST){
        long start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            BST.insert(list.get(i));
        }

        long end = System.currentTimeMillis();

        insertTimeBST += end-start;

        start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            HBST.insert(list.get(i));
        }

        end = System.currentTimeMillis();

        insertTimeHBST += end-start;
    }

    private static void searchBoth(List<Integer> list, BinarySearchTree<Integer> BST, HeapyBinarySearchTree<Integer> HBST){
        long start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            BST.search(list.get(i));
        }

        long end = System.currentTimeMillis();

        searchTimeBST += end-start;

        start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            HBST.search(list.get(i));
        }

        end = System.currentTimeMillis();

        searchTimeHBST += end-start;
    }

    private static void removeBoth(List<Integer> list, BinarySearchTree<Integer> BST, HeapyBinarySearchTree<Integer> HBST){
        long start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            BST.remove(list.get(i));
        }

        long end = System.currentTimeMillis();

        removingTimeBST += end - start;

        start = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            HBST.remove(list.get(i));
        }

        end = System.currentTimeMillis();

        removingTimeHBST += end - start;
    }

    private static void printStatistics(String time, String label, String method){
        System.out.println(label + " " + method);
        System.out.println("time: " + time + " [ms]");
    }

    private static String doubleToString(double value){
        return String.format("%.12f", value);
    }
}
