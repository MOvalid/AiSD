package core;

import java.util.*;

public class MergeSort<T> extends SortingAlgorithm<T> {

    public MergeSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();
        int i = 0;
        int j = 0;
        int indexNewArray = 1;

        for (j = 2 ; j < size ; j += j) {
            for (i = 0; i+j <= size; i += j) {
                mergesort(list, i,indexNewArray, i+j-1);
                indexNewArray += j;
            }

            if (size % j != 0) {
                mergesort(list,i,indexNewArray,size-1);
            }
            indexNewArray = j;

        }

        mergesort(list,0,indexNewArray,size-1);


        return list;
    }

    private void mergesort(List<T> list, int start, int indexSecondArray, int end) {
        int first = start;
        int second = indexSecondArray;
        int correctPlace;

        if (first < indexSecondArray-1) {
            while (first < indexSecondArray && second <= end && indexSecondArray <= end) {
                if (this.compare(list.get(first), list.get(second)) <= 0) {
                        first++;
                } else {
                    correctPlace = second;
                    while (correctPlace > first) {
                        swap(list, correctPlace, correctPlace - 1);
                        --correctPlace;

                    }
                    first++;
                    second++;
                    indexSecondArray++;
                }

            }
        } else {
            if(compare(list.get(start),list.get(end)) > 0){
                swap(list,start,end);
            }
        }

    }



}
