public class FiniteSeries<E> extends Series<E>{

    private int N;

    public FiniteSeries(int N, SeriesGenerator seriesGenerator){
        super(new SeriesIterator(seriesGenerator,N));
        if(N<0){
            throw new IllegalArgumentException("N nie może być mniejsze od zera");
        }
    }

    @Override
    public SeriesIterator<E> iterator() {
        return new SeriesIterator(this.seriesIterator.getSeriesGenerator(), this.seriesIterator.getSize());
    }

    public int getSize() {
        return N;
    }


}
