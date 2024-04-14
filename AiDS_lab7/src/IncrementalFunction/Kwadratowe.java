package IncrementalFunction;

public class Kwadratowe<T> implements IncrementalFunction<T> {

    public Kwadratowe(){

    }

    @Override
    public int shift(T object, int trial) {
//        int shift = Math.pow(-1,trial-1)*Math.pow((I=))
        int x = (trial+1)/2;

        return (int) (Math.pow(-1,trial-1)* Math.pow(x,2));
    }
}
