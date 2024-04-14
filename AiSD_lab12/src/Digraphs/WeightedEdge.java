package Digraphs;

public class WeightedEdge implements Comparable<WeightedEdge> {

    public final int beginning;
    public final int end;
    public final double weight;

    public WeightedEdge(int beginning, int end, double weight){
        this.beginning = beginning;
        this.end = end;
        this.weight = weight;
    }


    public String toString(){
        return "(" + beginning + ", " + end + ", " + weight + ")";
    }

    @Override
    public int compareTo(WeightedEdge another) {
//        return (int) (this.weight - another.weight)
        if(this.weight > another.weight){
            return 1;
        } else if(this.weight < another.weight){
            return -1;
        } else {
            return 0;
        }
    }
}
