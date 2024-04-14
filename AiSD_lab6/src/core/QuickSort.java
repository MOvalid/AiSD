package core;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort<T> extends SortingAlgorithm<T> {

    private Random random = new Random();
    protected boolean randomPivot;

    public QuickSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    public List<T> sort(List<T> list) {
        quicksort(list, 0, list.size());
        return list;
    }

    private void quicksort(List<T> list, int start, int end) {
        if(end - start > 1) {
            int correctPlaceForPivot = start;
            T pivot;
            int pivotPlace = pivot(start,end);
            pivot = list.get(pivotPlace);
            swap(list, pivotPlace, end - 1);
            for (int i = start; i < end - 1; i++) {
                if (this.compare(list.get(i), pivot) < 0) {
                    swap(list, correctPlaceForPivot, i);
                    correctPlaceForPivot++;
                }
            }
            swap(list, correctPlaceForPivot, end - 1);
            quicksort(list, start, correctPlaceForPivot);
            quicksort(list, correctPlaceForPivot + 1, end);
        }
    }

    protected int pivot(int start,int end){
        if(randomPivot){
            return random.nextInt(start,end);
        } else {
            return start;
        }
    }

}

