public interface Heap<T>{
    void clear();
    void add (T element);
    T minimum();
    boolean isEmpty();

}
