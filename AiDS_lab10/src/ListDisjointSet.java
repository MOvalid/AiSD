public class ListDisjointSet {

    public ListDisjointSet(){

    }

    public ListElement makeSet(){
        ListElement listElement = new ListElement();
        return listElement;
    }

    public boolean isDisjoint(ListElement first, ListElement second){
        if(first == null || second == null){
            throw new NullPointerException();
        }
        return this.findSet(first) != this.findSet(second);
    }

    public boolean isJoint(ListElement first, ListElement second){
        if(first == null || second == null){
            throw new NullPointerException();
        }
        return this.findSet(first) == this.findSet(second);
    }

    public ListElement union(ListElement first, ListElement second){
        if(second == null || first == null){
            throw new NullPointerException();
        }
        if(this.isJoint(first,second)){
            return this.findSet(first);
        }
        if(first != second) {
            if (second.getHead().getRank() > first.getHead().getRank()) {
                return this.unionElement(this.findSet(second), this.findSet(first));
            } else {
                return this.unionElement(this.findSet(first), this.findSet(second));
            }
        } else {
            return this.findSet(first);
        }
    }

    private ListElement unionElement(ListElement first, ListElement second){
        ListElement temp;
        first.getTail().setNext(second.getHead());
        first.getHead().setTail(second.getHead().getTail());
        temp = second.getHead();
        while (temp != null) {
            temp.setHead(first.getHead());
            temp.setTail(null);
            temp.setRank(0);
            temp = temp.getNext();
            first.getHead().incrementRank();
        }
        return first;
    }

    public ListElement findSet(ListElement listElement){
        return listElement.getHead();
    }

}
