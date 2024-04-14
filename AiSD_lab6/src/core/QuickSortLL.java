package core;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QuickSortLL<T> extends QuickSort<T>{
    private static long swaps = 0;
    private ChoosePivot<T> choosePivot;

    public QuickSortLL(Comparator<? super T> comparator, ChoosePivot<T> choosePivot) {
        super(comparator);
        this.choosePivot = choosePivot;
    }

    @Override
    public List<T> sort(List<T> list) {
//        Iterator<T> iterator = list.iterator();
//        T pivot;
//        if(iterator.hasNext()){
//            pivot = iterator.next();
//        }
//
//
//        return null;
        if(list.size() > 1){
            return quicksort(list);
        } else {
            return list;
        }
    }

    private List<T> quicksort(List<T> list) {
//        if(end - start > 1) {
//            int placeForPivot = start;
//            T pivot = list.get(start);
//            swap(list, start, end - 1);
//            for (int i = start; i < end - 1; i++) {
//                if (this.compare(list.get(i), pivot) < 0) {
//                    swap(list, placeForPivot, i);
//                    placeForPivot++;
//                }
//            }
//            swap(list, placeForPivot, end - 1);
//            quicksort(list, start, placeForPivot);
//            quicksort(list, placeForPivot + 1, end);
//        }
        if(list.size() < 2){
            return list;
        }
        T pivot = list.remove(this.choosePivot.choosePivot(0, list.size()));
        T current;

        LinkedList<T> result = new LinkedList<T>();
        LinkedList<T> left = new LinkedList<T>();
        LinkedList<T> right = new LinkedList<T>();

        Iterator<T> i = list.iterator();
        while(i.hasNext()){
            current = i.next();
            if(this.compare(pivot,current) > 0){
                left.addLast(current);
            } else {
                right.addLast(current);
            }
            countSwaps();
            i.remove();
        }

        result.addAll(quicksort(left));
        result.addLast(pivot);
        result.addAll(quicksort(right));

        list.addAll(result);
        return list;
    }

    private void countSwaps(){
        this.swaps++;
    }

    public long getSwaps(){
        long returnSwaps = this.swaps;
        swaps = 0;
        return returnSwaps;
    }
}
