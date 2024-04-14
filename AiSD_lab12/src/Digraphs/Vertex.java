package Digraphs;

public class Vertex {
    private final int number;
    private ListDisjointSet set;

    public Vertex(int number){
        this.number = number;
        this.set = new ListDisjointSet();
        this.set.makeSet();
    }

    public int getNumber(){
        return this.number;
    }

    public ListDisjointSet getSet(){
        return this.set;
    }
}
