public class ForestDisjointSet {

    public ForestDisjointSet(){

    }

    public ForestElement makeSet(){
        ForestElement newElement = new ForestElement();
        return newElement;
    }

    public boolean isDisjoint(ForestElement first, ForestElement second){
        if(first == null || second == null){
            throw new NullPointerException();
        }
        return this.findSet(first) != this.findSet(second);
    }

    public boolean isJoint(ForestElement first, ForestElement second){
        if(first == null || second == null){
            throw new NullPointerException();
        }
        return this.findSet(first) == this.findSet(second);
    }

    public ForestElement union(ForestElement first, ForestElement second){
        if(first == null || second == null){
            throw new NullPointerException();
        }
        if(first.getRank() > second.getRank()){
            second.setParent(this.findSet(first));
        } else {
            first.setParent(this.findSet(second));
            if(first.getRank() == second.getRank()){
                second.incrementRank();
            }
        }
        return first;
    }

    public ForestElement findSet(ForestElement forestElement){
        if(forestElement != forestElement.getParent()){
           forestElement.setParent(this.findSet(forestElement.getParent()));
        }
        return forestElement.getParent();
    }


}
