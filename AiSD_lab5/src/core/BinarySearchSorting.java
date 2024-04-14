package core;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BinarySearchSorting<T> extends SortingAlgorithm<T>{

    public BinarySearchSorting(Comparator comparator) {
        super(comparator);
    }

//    @Override
//    public List<T> sort(List<T> list) {
//        int size = list.size();
//        int position;
//        int endIndex;
//        int changes = 1;
//
//        while (changes > 0) {
//            changes = 0;
//            for (int i = 1; i < size; i++) {
//                endIndex = i - 1;
//
//                position = binarySearch(list, i, 0, endIndex);
//
//                if (i != position) {
//                    swap(list, i, position);
//                    changes++;
//                }
//            }
//        }
//        return list;
//    }
//
//    private int binarySearch(List<T> list, int selectedIndex, int leftIndex, int rightIndex){
//        if(leftIndex >= rightIndex){
//            if(this.compare(list.get(selectedIndex),list.get(leftIndex)) >= 0){
//                return leftIndex+1;
//            } else {
//                return leftIndex;
//            }
//        }
//
//        int middleIndex = (leftIndex+rightIndex)/2;
//
//        if(this.compare(list.get(middleIndex),list.get(selectedIndex)) == 0){
//            return leftIndex + 1;
//        }
//
//        if (this.compare(list.get(selectedIndex),list.get(middleIndex)) > 0){
//            return binarySearch(list, selectedIndex, middleIndex+1, rightIndex);
//        } else {
//            return binarySearch(list,selectedIndex,leftIndex, middleIndex-1);
//        }
//    }


//    public List<T> sort(List<T> list){
//    poprzdnie
//        int size = list.size();
//        T current;
//        int leftIndex;
//        int midIndex;
//        int rightIndex;
//        int changes = 1;
//        while(changes > 0) {
//            changes = 0;
//            for (int i = 0; i < size - 1; i++) {
//                current = list.get(i);
//                leftIndex = i;
//                rightIndex = size;
//                while (rightIndex - leftIndex > 1) {
//                    midIndex = (leftIndex + rightIndex) / 2;
//                    if (this.compare(list.get(midIndex), current) >= 0) {
//                        rightIndex = midIndex;
//                    } else {
//                        leftIndex = midIndex;
//                    }
//                }
//                midIndex = i;
//                while (midIndex < leftIndex) {
//                    swap(list, midIndex, midIndex + 1);
//                    changes++;
//                    midIndex++;
//                }
//
//                list.set(leftIndex, current);
//            }
//        }
//        return list;
//    }

//    private int binarySearch(List<T> list, T target, int rightIndex){
//        int leftIndex = 0;
//        int middleIndex;
//        while(leftIndex <= rightIndex){
//            middleIndex = (leftIndex+rightIndex)/2;
//            System.out.println(target + " ?? " + list.get(middleIndex));
//            if(this.compare(target, list.get(middleIndex)) > 0){
//                leftIndex = middleIndex+1;
//            } else if (this.compare(target, list.get(middleIndex)) < 0){
//                if(middleIndex != 0) {
//                    rightIndex = middleIndex - 1;
//                } else {
//                    return 0;
//                }
//            } else {
////                System.out.println(middleIndex);
//                return middleIndex;
//            }
//        }
//        return -1;
//    }

    public List<T> sort(List<T> list){
        int size = list.size();
        int position;
        int j;
        T target;
        for (int i = 1; i < size; i++){
            target = list.get(i);
            position = binarySearch(list, target,0,i,i);

            j = i-1;
            while(j >= position){
                swap(list,j,j+1);
                j--;
            }
//            Iterator it = list.iterator();
//            System.out.println("\n\nNr i: " + i + " target " + target);
//            System.out.println("------------ " + position);
//            while(it.hasNext()){
//                System.out.print(it.next() + " ");
//            }



        }
        return list;
    }

        private int binarySearch(List<T> list, T target, int leftIndex, int rightIndex, int end) {

            if (leftIndex > rightIndex) {
                if (this.compare(target, list.get(leftIndex)) >= 0) {
                    return leftIndex + 1;
                } else {
                    return leftIndex;
                }
            }

            int middleIndex = (leftIndex + rightIndex) / 2;

            if (this.compare(list.get(middleIndex), target) == 0) {
                middleIndex = middleIndex + 1;
                while(this.compare(list.get(middleIndex), target) == 0 && middleIndex < end) {
                    middleIndex++;
                }
                return middleIndex;
            }

            if (this.compare(target, list.get(middleIndex)) > 0) {
                return binarySearch(list, target, middleIndex + 1, rightIndex,end);
            } else {
                return binarySearch(list, target, leftIndex, middleIndex - 1,end);
            }

        }
}
