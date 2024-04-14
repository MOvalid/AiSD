package core;

import java.util.*;

public class MergeSort1<T> extends SortingAlgorithm<T>{
    private static long swaps = 0;

    public MergeSort1(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        LinkedList<LinkedList<T>> kolejka = new LinkedList<LinkedList<T>>();
        for(T t: list){
            LinkedList<T> element = (LinkedList<T>) new LinkedList<Object>();
            element.addFirst(t);
            kolejka.addLast(element);
        }
        mergesort(list,kolejka);
        return list;
    }

    private List<T> mergesort(List<T> list, LinkedList<LinkedList<T>> kolejka){
//        int counter;
//        int size;
//        List<T> first;
//        List<T> second;
//        while(kolejka.size() > 1){
//            counter = 0;
//            size = kolejka.size();
//            while(counter < size){
//                first = kolejka.removeFirst();
//                second = kolejka.removeFirst();
//                kolejka.addLast(merge(first,second,list));
//                counter += 2;
//            }
//        }
//        list.clear();
//        list.addAll(kolejka.getFirst());
//
//        return kolejka.getFirst();
        int size = list.size();
        while(kolejka.size() > 1){
            if(size > 1) {
                kolejka.addLast(merge(kolejka.pollFirst(), kolejka.pollFirst()));
                size = size - 2;
            } else {
                if(size == 1){
                    kolejka.addLast(kolejka.pollFirst());
                }
                size = kolejka.size();
            }
        }
        list.clear();
        list.addAll(kolejka.getFirst());
        return list;
    }

    private LinkedList<T> merge(LinkedList<T> left, LinkedList<T> right) {
        LinkedList<T> result = new LinkedList<T>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (this.compare(left.peekFirst(), right.peekFirst()) > 0) {
                result.addLast(right.pollFirst());
            } else {
                result.addLast(left.pollFirst());
            }
            countSwaps();
        }
        while (!left.isEmpty()) {
            result.addLast(left.pollFirst());
            countSwaps();
        }
        while (!right.isEmpty()) {
            result.addLast(right.pollFirst());
            countSwaps();
        }
        return result;
    }
//        if (right != null) {
//            List<T> result = new ArrayList<T>();
//            for (T t : left) {
//                result.add(t);
//            }
//            for (T t : right) {
//                result.add(t);
//            }
//            int first = 0;
//            int second = left.size();
//            int correctPlace;
//
//            if (first < left.size() - 1) {
//                while (first < left.size() && second < result.size()) {
//                    if (this.compare(list.get(first), list.get(second)) <= 0) {
//                        first++;
//                    } else {
//                        correctPlace = second;
//                        while (correctPlace > first) {
//                            swap(result, correctPlace, correctPlace - 1);
//                            --correctPlace;
//
//                        }
//                        first++;
//                        second++;
//                    }
//
//                }
//            } else {
//                if (compare(result.get(0), list.get(1)) > 0) {
//                    swap(result, 0, 1);
//                }
//            }
//        }
//        return left;
//        return result;
//        if(right != null){
//            List<T> result = new ArrayList<T>();
//            Iterator<T> l = left.iterator();
//            Iterator<T> r = right.iterator();
//            T elemL = null;
//            T elemR = null;
//            boolean contL;
//            boolean contR;
//            if(contL=l.hasNext()){
//                elemL=l.next();
//            }
//            if(contR=r.hasNext()){
//                elemR=r.next();
//            }
//            while (contL && contR) {
//                if (this.compare(elemL, elemR) <= 0){
//                    result.add(elemL);
//                    if(contL=l.hasNext()){
//                        elemL=l.next();
//                    } else {
//                        result.add(elemR);
//                    }
//                } else {
//                    result.add(elemR);
//                    if(contR=r.hasNext()){
//                        elemR=r.next();
//                    } else {
//                        result.add(elemL);
//                    }
//                }
//            }
//            while(l.hasNext()){
//                result.add(l.next());
//            }
//            while(r.hasNext()){
//                result.add(r.next());
//            }
//            return result;
//        }
//        return left;
//    }
     private void countSwaps(){
        this.swaps++;
     }

     public long getSwaps(){
        long returnSwaps = this.swaps;
        swaps = 0;
        return returnSwaps;
     }

}
