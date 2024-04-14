package core;

import java.util.Comparator;
import java.util.List;

public class InsertionSort<T> extends SortingAlgorithm<T> {

    public InsertionSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int i = 0 ; i < size ; i++) {

            T current = list.get(i);
            int j = i;
            while(j > 0 && compare(current,list.get(j-1)) < 0){
                swap(list,j,j-1);
                j--;
            }
            list.set(j,current);

        }
        return list;
    }
}
