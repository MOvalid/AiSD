package core;

import java.util.Comparator;
import java.util.List;

public class ShakerSort<T> extends SortingAlgorithm<T>{
    public ShakerSort(Comparator comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        boolean change = true;
        int start,end;
        int firstChange = 0;
        int lastChange = list.size()-1;
        T element,anotherElement;
        while(change) {
            change = false;
            start = firstChange;
            end = lastChange;
            firstChange = 0;
            lastChange = 0;
            element = list.get(start);
            for (int i = start; i < end; i++) {
                anotherElement = list.get(i+1);
                if (this.compare(element, anotherElement) > 0) {
                    swap(list, i, i + 1);
                    change = true;
                    lastChange = i;
                } else {
                    element = anotherElement;
                }
            }
            if(!change){
                break;
            }
            element = list.get(lastChange);
            for(int i = lastChange; i > start; i--){
                anotherElement = list.get(i-1);
                if(this.compare(anotherElement,element) > 0){
                    swap(list, i, i - 1);
                    change = true;
                } else {
                    element = anotherElement;
                }
            }

        }
        return list;
    }
}
