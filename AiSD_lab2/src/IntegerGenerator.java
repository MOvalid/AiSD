public class IntegerGenerator implements SeriesGenerator<Integer>{

    private int multiplier;

    public IntegerGenerator(){
        this.multiplier = 2;
    }

    public IntegerGenerator(int multiplier){
        this.multiplier = multiplier;
    }

    @Override
    public Integer generate(int n) {
        return this.multiplier*n;
    }
}
