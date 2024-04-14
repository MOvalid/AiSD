public class ListElement {

    private ListElement next;
    private ListElement head;
    private ListElement tail;
    private int rank;

    public ListElement(){
        this.next = null;
        this.head = this;
        this.tail = this;
        this.rank = 1;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    public ListElement getHead() {
        return head;
    }

    public void setHead(ListElement head) {
        this.head = head;
    }

    public ListElement getTail() {
        return tail;
    }

    public void setTail(ListElement tail) {
        this.tail = tail;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void incrementRank(){
        this.rank++;
    }




}
