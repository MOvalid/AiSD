package HashTable;

import HashFunctions.HashFunction;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

//Ta z linkedlistami
public class SeparateChainingHashTable<T> extends HashTable<T> {
    LinkedList<T>[] array;

    public SeparateChainingHashTable(double maxLoadFactor, Comparator<? super T> comparator) {
        super(maxLoadFactor, comparator);
        this.array = new LinkedList[initialSize];
        for(int i = 0; i < array.length; i++){
            array[i] = new LinkedList<T>();
        }
    }

    public SeparateChainingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction){
        super(maxLoadFactor, comparator, hashFunction);
        this.array = new LinkedList[initialSize];
        for(int i = 0; i < array.length; i++){
            array[i] = new LinkedList<T>();
        }
    }

    @Override
    public int capacity() {
        int capacity = 0;
        Iterator<T> iterator;
        for(int i = 0; i < array.length; i++){
            iterator = array[i].iterator();
            while (iterator.hasNext()){
                capacity++;
                iterator.next();
            }
        }
        return capacity;

//       return this.capacity;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void insert(T object) {
        int position;
        Iterator<T> iterator;
        boolean duplication = false;
        if(object != null){
            if((double)this.capacity()/array.length >= maxLoadFactor){
                enlarge();
            }
            position = this.hashFunction.hashCode(object) % this.array.length;
            hash++;

            if(!array[position].isEmpty()){
                colisions++;
            }
            iterator = array[position].iterator();

            while(iterator.hasNext()){
                this.insertComparisons++;
                if(this.comparator.compare(object,iterator.next()) == 0){
                    duplication = true;
                    break;
                }
            }
            if(!duplication){
                array[position].addLast(object);
            }
//            this.capacity++
        }
    }

    @Override
    public boolean lookUp(T object) {
        if(object != null) {
            Iterator<T> iterator;
            int position = this.hashFunction.hashCode(object) % this.array.length;
            hash++;
            iterator = array[position].iterator();
            while (iterator.hasNext()) {
                lookUpComparisons++;
                if (object.equals(iterator.next())){
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public int collisions() {
        return this.colisions;
    }

    @Override
    public int insertComparisons() {
        return this.insertComparisons;
    }

    @Override
    public int lookUpComparisons() {
        return this.lookUpComparisons;
    }

    @Override
    public int hashFunctionEvaluations() {
        return this.hash;
    }

    public void enlarge(){

        LinkedList<T>[] temp = array;
        array = new LinkedList[temp.length*2];
        for(int i = 0; i < array.length; i++){
            array[i] = new LinkedList<T>();
        }
        Iterator<T> iterator;
        for(int i = 0; i < temp.length; i++){
            iterator = temp[i].iterator();
            while(iterator.hasNext()){
                insert(iterator.next());
            }
        }
//        colisions = 0;
//        insertComparisons = 0;
//        lookUpComparisons = 0;
//        hash = 0;
    }

    public String toString(){
        StringBuilder text = new StringBuilder("\n[ ");
        Iterator iterator;
        boolean hasChanged = false;
        for(int i = 0; i < array.length; i++){
            iterator = array[i].iterator();
            while(iterator.hasNext()){
                text.append(iterator.next() + ", ");
                hasChanged = true;
            }

                if (i != array.length - 1) {
                    if(hasChanged) {
                        text.delete(text.length() - 2, text.length());
                    }
                    text.append(" | ");
                } else {
                    if(hasChanged) {
                        text.delete(text.length() - 2, text.length());
                    }
                    text.append(" ]");
                }

            hasChanged = false;
        }
        return text.toString();
    }

    @Override
    public String statics() {
        double actualLoad = (double) this.capacity()/this.array.length;
        return "\nAktualny stopień wypełnienia tablicy: " + actualLoad + "\nLiczba kolizji: " + this.colisions +
                "\nLiczba porównań w insert(): " + this.insertComparisons + "\nLiczba wyliczeń funkcji mieszającej: " + this.hash;
    }
}
