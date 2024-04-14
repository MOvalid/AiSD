public class Main {

    public static void main(String[] args) {

        //Nieskończony ciąg

        Series<String> series = new Series<>(new StringGenerator());
        for(String string : series){
            System.out.println(string);
        }


        System.out.println("-----------------------");

        //Skończony ciag

//        FiniteSeries<Integer> finiteSeries1 = new FiniteSeries<>(5,new IntegerGenerator(5));
//        for(Integer integer : finiteSeries1){
//            System.out.println(integer);
//        }


    }
}
