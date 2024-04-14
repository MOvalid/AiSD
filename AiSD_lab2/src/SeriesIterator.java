import java.util.Iterator;
import java.util.NoSuchElementException;

public class SeriesIterator<E> implements Iterator {

    private int position;
    private SeriesGenerator<E> generator;
    private int size = -1;

    //Dla nieskończonych ciągów

    public SeriesIterator(SeriesGenerator generator){
        this.position = 0;
        if(generator == null){
            throw new IllegalArgumentException("SeriesGenerator nie może być nullem!!!");
        }
        this.generator = generator;
    }

    //Dla skończonych ciągów
    public SeriesIterator(SeriesGenerator generator, int size){
        this(generator);
        if(size >= 0){
            this.size = size;
        } else {
            this.size = 0;
        }
    }


    public SeriesGenerator<E> getSeriesGenerator(){
        return this.generator;
    }


    @Override
    public boolean hasNext() {
        if(position < size || size == -1){
            return true;
        } else {
            return false;
        }
    }


    @Override
    public E next() {
        if(hasNext()){
            return this.generator.generate(++position);
        } else {
            throw new NoSuchElementException();
        }
    }

    public int getSize(){
        return this.size;
    }
}
