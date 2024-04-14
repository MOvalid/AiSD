public class ForestElement{
    private ForestElement parent;
    private int rank;

    public ForestElement(){
        this.parent = this;
        this.rank = 0;
    }

    public void setParent(ForestElement parent){
        this.parent = parent;
    }

    public ForestElement getParent(){
        return this.parent;
    }

    public void setRank(int rank){
        if(rank < 0){
            throw new IllegalArgumentException();
        }
        this.rank = rank;
    }

    public int getRank(){
        return this.rank;
    }

    public void incrementRank(){
        this.rank++;
    }
}
