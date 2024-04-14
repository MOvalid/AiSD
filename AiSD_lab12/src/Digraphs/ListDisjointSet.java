package Digraphs;

public class ListDisjointSet {
    private ListDisjointSet next;
    private ListDisjointSet head;
    private ListDisjointSet tail;
    private int rank;

    public void makeSet(){
        this.next = null;
        this.head = this;
        this.tail = this;
        this.rank = 1;
    }

    public boolean isDisjoint(ListDisjointSet second){
        return !this.isJoint(second);
    }

    public boolean isJoint(ListDisjointSet second){
        if(second == null){
            throw new NullPointerException();
        }
        return this.findSet() == second.findSet();
    }

    public ListDisjointSet union(ListDisjointSet second){
        if(second == null){
            throw new NullPointerException();
        }
        if(this.isJoint(second)){
            return this.findSet();
        }
        if(this != second) {
            if (second.head.rank > this.head.rank) {
                return this.unionElement(second.findSet(), this.findSet());
            } else {
                return this.unionElement(this.findSet(), second.findSet());
            }
        } else {
            return this.findSet();
        }
    }

    private ListDisjointSet unionElement(ListDisjointSet first, ListDisjointSet second){
        ListDisjointSet temp;
        first.tail.next = second.head;
        first.head.tail = second.head.tail;
        temp = second.head;
        while (temp != null) {
            temp.head = first.head;
            temp.tail = null;
            temp.rank = 0;
            temp = temp.next;
            first.head.rank++;
        }
        return first;
    }

    public ListDisjointSet findSet(){
        return this.head;
    }

}
