import java.util.Iterator;
import java.util.ListIterator;

public class OneWayLinkedListWithSentinel<E> {

    public class Element{
        private E value;
        private Element next;

        Element(E data){
            this.value = data;
        }

        public E getValue(){
            return this.value;
        }

        public void setValue(E value){
            this.value = value;
        }

        public Element getNext(){
            return next;
        }

        public void setNext(Element next){
            this.next = next;
        }

    }

    private Element sentinel = null;

    public OneWayLinkedListWithSentinel(){
        sentinel = new Element(null);
        sentinel.setNext(null);
    }

    public boolean add(E e){
        Element newElement = new Element(e);
        Element actualElement = sentinel;
        while(actualElement.getNext() != null){
            actualElement = actualElement.getNext();
        }
        actualElement.setNext(newElement);
        return true;
    }

    public void add(int index, E data){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        Element newElement = new Element(data);
        Element actualElement = getElement(index);
        newElement.setNext(actualElement.getNext());
        actualElement.setNext(newElement);
    }

    public void clear(){
        sentinel.setNext(null);
    }

    public boolean contains(E data){
        return indexOf(data) >= 0;
    }

    public E get(int index){
        Element actualElement = getElement(index+1);
        return actualElement.getValue();
    }

    private Element getElement(int index) {
        if (index < -1) {
            throw new IndexOutOfBoundsException();
        }
//        Element actualElement = sentinel.getNext();
        Element actualElement = sentinel;
        while (index > 0 && actualElement != null) {
            index--;
            actualElement = actualElement.getNext();
        }
        if (actualElement == null){
            throw new IndexOutOfBoundsException();
        }
        return actualElement;
    }

    public E set(int index, E data){
        Element actualElement = getElement(index+1);
        E elementData = actualElement.getValue();
        actualElement.setValue(data);
        return elementData;
    }

    public int indexOf(E data){
        int position = 0;
        Element actualElement = sentinel.getNext();
        while(actualElement != null){
            if(actualElement.getValue().equals(data)){
                return position;
            }
            position++;
            actualElement = actualElement.getNext();
        }
        return -1;
    }

    public boolean isEmpty() {
        return sentinel.getNext() == null;
    }

    public Iterator<E> iterator(){
        throw new IllegalArgumentException();
    }

    public ListIterator<E> listIterator(){
        throw new IllegalArgumentException();
    }

    public E remove(int index){
        Element previousElement;
        E removedValue;
        if(index == 0){
            previousElement = getElement(0);
            sentinel.setNext(previousElement.getNext());
            removedValue = previousElement.getValue();
        } else {
            previousElement = getElement(index);
            if (previousElement.getNext() == null) {
                throw new IndexOutOfBoundsException();
            }
            removedValue = previousElement.getNext().getValue();
            previousElement.setNext(previousElement.getNext().getNext());
        }

        return removedValue;
    }

    public boolean remove(Element e) {
        return remove(e.getValue());
    }

    public boolean remove(E data){
        Element removedElement = sentinel.getNext();

        while(removedElement.getNext() != null && !removedElement.getNext().getValue().equals(data)){
            removedElement = removedElement.getNext();
        }

        if(removedElement.getNext() == null)
            return false;

        removedElement.setNext(removedElement.getNext().getNext());
        return true;
    }


    public int size(){
        int counter = 0;
        Element element = sentinel.getNext();
        while(element != null){
           counter++;
           element = element.getNext();
        }
        return counter;
    }

    public void reverse(){
        Element previous = null;
        Element current = sentinel.getNext();
        Element next = current.getNext();
        while(next != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            next = next.getNext();
        }
        current.setNext(previous);
        sentinel.setNext(current);


    }



}
