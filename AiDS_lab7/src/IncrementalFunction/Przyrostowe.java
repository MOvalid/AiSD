package IncrementalFunction;

public class Przyrostowe<T> implements IncrementalFunction<T> {

    public Przyrostowe(){

    }

    @Override
    public int shift(T object, int trial) {
        return trial;
    }
}
