public class StringGenerator implements SeriesGenerator<String> {

    private String word;

    public StringGenerator(){
        this.word = "A";
    }

    public StringGenerator(String word){
        this.word = word;
    }


    @Override
    public String generate(int n) {
        StringBuffer stringBuffer = new StringBuffer(word);
        while(n>1){
            stringBuffer.append(word);
            n--;
        }
        return stringBuffer.toString();
    }
}
