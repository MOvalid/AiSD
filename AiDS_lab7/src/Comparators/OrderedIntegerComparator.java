package Comparators;

import java.util.Comparator;

public class OrderedIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return (int) o1 - (int) o2;
    }
}
