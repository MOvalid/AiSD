import java.util.Iterator;
import java.util.List;

public class PriorityQueueSorter<T> {
    private Heap<T> heap;

    public PriorityQueueSorter(Heap<T> heap){
        this.heap = heap;
    }

    public List<T> sort(List<T> list){
        this.heap.clear();
        Iterator<T> iterator = list.iterator();

        while(iterator.hasNext()){
            heap.add(iterator.next());
        }

        for(int i = 0; i < list.size(); i++) {
            list.set(i, heap.minimum());
        }

        return list;
    }




}
