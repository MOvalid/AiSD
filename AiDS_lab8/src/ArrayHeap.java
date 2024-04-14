import java.util.Comparator;

public class ArrayHeap<T> implements Heap<T> {

    private T[] array;
    private int capacity = 0;
    private final Comparator<T> comparator;

    public ArrayHeap(int size, Comparator comparator) {
        if (size > 0) {
            array = (T[]) new Object[size];
        } else {
            array = (T[]) new Object[10];
        }
        this.comparator = comparator;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[array.length];
        capacity = 0;
    }

    @Override
    public void add(T element) {
        if(element != null) {
            if (capacity >= array.length) {
                enlarge();
            }
            array[capacity] = element;
            capacity++;
            if (capacity > 1) {
                int child = capacity-1;
                while (child >= 1 && comparator.compare(array[child], array[(child-1)/2]) < 0) {
                    swap(child, (child-1)/ 2);
                    child = (child-1)/ 2;
                }
            }
        }
    }

    @Override
    public T minimum() {
        if (array[0] != null) {
            T temp = array[0];
            array[0] = null;
            capacity--;
            swap(0,capacity);
            repair();
            return temp;
        } else {
            throw new NullPointerException("KOPIEC JEST PUSTY!!!");
        }
    }

    @Override
    public boolean isEmpty() {
        return (array[0] == null);
    }

    private void enlarge() {
        T[] temp = (T[]) new Object[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    private void swap(int left, int right) {
        if(left != right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    private void repair(){
        int index = 0;
        int left, right;
        while(index < capacity){
            left = 2*index+1;
            right = 2*index+2;

            if(left >= capacity){
                break;
            }
            if(right >= capacity){
                if(comparator.compare(array[index],array[left]) <= 0){ //
                    break;
                }
                swap(index,left);
                index = left;
            } else if (comparator.compare(array[left],array[right]) < 0){
                if(comparator.compare(array[index], array[left]) <= 0){
                    break;
                }
                swap(index,left);
                index = left;
            } else {
                if(comparator.compare(array[index], array[right]) <= 0){
                    break;
                }
                swap(index,right);
                index = right;
            }
        }
    }

//    private void repair(){
//        int index = 0;
//        int left, right;
//        while(index < capacity){
//            left = 2*index+1;
//            right = 2*index+2;
//
//            if(left >= capacity){
//                break;
//            }
//            if(right >= capacity){
//                if(comparator.compare(array[index],array[left]) < 0){
//                    swap(index,left);
//                    index = left;
//                }
//
//            } else if (comparator.compare(array[left],array[right]) > 0){
//                if(comparator.compare(array[index], array[left]) < 0){
//                    swap(index,left);
//                    index = left;
//                }
//
//            } else {
//                if(comparator.compare(array[index], array[right]) < 0){
//                    swap(index,right);
//                    index = right;
//                }
//
//            }
//        }
//    }







    public void printHeap(){
        for(int i = 0; i < capacity; i++) {
            System.out.print(array[i] + " ");
        }
    }

//    private T root(){
//        if(capacity > 0){
//            return array[0];
//        }
//        return null;
//    }
//
//    private T left(int index){
//        if(index >= 0 && 2*index+1 < capacity) {
//            return array[2*index+1];
//        } else {
//            return null;
//        }
//    }
//
//    private T right(int index){
//        if(index >= 0 && 2*index+2 < capacity) {
//            return array[2*index+2];
//        } else {
//            return null;
//        }
//    }



}
