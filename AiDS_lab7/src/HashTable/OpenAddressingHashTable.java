package HashTable;

import HashFunctions.HashFunction;
import IncrementalFunction.IncrementalFunction;
import IncrementalFunction.Przyrostowe;
import java.util.Comparator;

public class OpenAddressingHashTable<T> extends HashTable<T> {

    private T[] array;
    private IncrementalFunction<T> increment;


    public OpenAddressingHashTable(double maxLoadFactor, Comparator<? super T> comparator) {
        super(maxLoadFactor, comparator);
        this.array = (T[]) new Object[initialSize];
        this.increment = new Przyrostowe<T>();
    }

    public OpenAddressingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction, IncrementalFunction<T> increment) {
        super(maxLoadFactor, comparator,hashFunction);
        this.array = (T[]) new Object[initialSize];
        this.increment = increment;
    }


    @Override
    public int capacity() {
        int capacity = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] != null){
                capacity++;
            }
        }
        return capacity;

//        return this.capacity;
    }

    @Override
    public int size() {
        return this.array.length;
    }

    @Override
    public void insert(T object) {
        if(object != null) {
            if((double)this.capacity()/array.length >= maxLoadFactor) {
                enlarge();
            }
            int position = this.hashFunction.hashCode(object) % array.length;
            hash++;
            insertComparisons++;
            if (array[position] == null) {
                array[position] = object;
            } else {
                if (this.comparator.compare(array[position],object) != 0) {
                    int trial = 1;
                    while (array[position] != null && this.comparator.compare(array[position],object) != 0) {
                        position = (this.hashFunction.hashCode(object) + this.increment.shift(object, trial)) % array.length;
                        trial++;
                        hash++;
                        colisions++;
                        insertComparisons++;
                        if(position < 0) {
                            position = position * (-1);
                        }
                    }
                    array[position] = object;
//                    capacity++;
                }
            }
        }
    }

    @Override
    public boolean lookUp(T object) {
        if(object != null) {
            int trial = 1;
            int position = this.hashFunction.hashCode(object) % this.array.length;
            lookUpComparisons++;
            hash++;
            while(array[position] != null && this.comparator.compare(array[position],object) != 0){
                position = (this.hashFunction.hashCode(object) + this.increment.shift(object, trial)) % this.array.length;
                trial++;
                lookUpComparisons++;
                hash++;
            }
            return array[position] != null;
        }
        return false;
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

    public String toString(){
        StringBuilder text = new StringBuilder("\n[");
        for(int i = 0; i < array.length; i++){
            text.append(array[i] + ", ");
        }
        text.replace(text.length() - 2, text.length(), "]");
        return text.toString();
    }

    private void enlarge(){
        T[] temp = array;
        array = (T[]) new Object[temp.length*2];
        for(int i = 0; i < temp.length; i++){
            if(temp[i] != null){
                insert(temp[i]);
            }
        }
//        colisions = 0;
//        insertComparisons = 0;
//        lookUpComparisons = 0;
//        hash = 0;
    }

    public String statics(){
        double actualLoad = (double) this.capacity()/this.array.length;
        return "\nAktualny stopień wypełnienia tablicy: " + actualLoad + "\nLiczba kolizji: " + this.colisions +
                "\nLiczba porównań w insert(): " + this.insertComparisons + "\nLiczba wyliczeń funkcji mieszającej: " + this.hash;
    }
}
