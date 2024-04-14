public class Series<E> implements Iterable<E>{

    protected SeriesIterator seriesIterator;

    public Series(SeriesIterator seriesIterator){
        this.seriesIterator = seriesIterator;
    }

    public Series(SeriesGenerator seriesGenerator){
        this(new SeriesIterator(seriesGenerator));
    }

    public SeriesGenerator getSeriesGenerator(){
        return this.seriesIterator.getSeriesGenerator();
    }

    public void setSeriesIterator(SeriesIterator seriesIterator){
        this.seriesIterator = seriesIterator;
    }

    @Override
    public SeriesIterator<E> iterator() {
        return new SeriesIterator(this.seriesIterator.getSeriesGenerator());
    }

}
