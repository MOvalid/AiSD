public class TwoWayArrayLinkedList<E> {

    private class Element {

        private E array[];
        private Element previous;
        private Element next;
        private int usedPlaces;

        Element() {
            this.array = (E[]) new Object[N];
            this.previous = null;
            this.next = null;
            this.usedPlaces = 0;
        }

        public E getValue(int index) {
            if (index >= this.array.length) {
                throw new IndexOutOfBoundsException();
            }
            return array[index];
        }

        public E setValue(E e, int index) {
            if (index >= N || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            E replaced = array[index];
            array[index] = e;
            return replaced;
        }

        public Element getNext() {
            return next;
        }

        public Element getPrevious() {
            return previous;
        }

        public void setPrevious(Element previous) {
            this.previous = previous;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public boolean hasNext(){
            return this.next != null;
        }

        public boolean hasPrevious(){
            return this.previous != null;
        }

        public E remove(int index) {
            E removed;
            if (index >= N || index < 0) {
                throw new IllegalArgumentException();
            }
            removed = array[index];
            array[index] = null;
            --usedPlaces;
            if (usedPlaces == 0) {
                this.remove();
            } else {
                int last = 0;
                for(int i = index; i < array.length-1; i++){
                    if(array[i+1] != null) {
                        array[i] = array[i + 1];
                        last = i + 1;
                    } else {
                        break;
                    }
                }
                if(last != 0) {
                    array[last] = null;

                }
            }
            return removed;
        }

        public void remove() {
            if(this == tail){
               tail = this.getPrevious();
            }
            if(this == head){
                head = this.getNext();
            }
            if(this.getNext() != null) {
                this.getNext().setPrevious(this.getPrevious());
            }
            if(this.getPrevious() != null) {
                this.getPrevious().setNext(this.getNext());
            }
        }

        public boolean add(E data) {
            if(data != null) {
                if (this.usedPlaces == N) {
                    throw new IllegalStateException();
                }

                for (int i = 0; i < array.length; i++) {
                    if (array[i] == null) {
                        array[i] = data;
                        usedPlaces++;
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean add(int index, E data) {
            if (index < 0 || index >= N || index > this.usedPlaces) {
                throw new IndexOutOfBoundsException();
            }
            if(array[index] == null){
                usedPlaces++;
                array[index] = data;
            } else {
                for(int i = usedPlaces-1; i > index; i--){
                    array[i] = array[i-1];
                }
                array[index] = data;
            }
            return true;
        }

        public int check(E value) {
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (array[i] != null) {
                    if (array[i] == value) {
                        return index;
                    } else {
                        index++;
                    }
                }
            }
            return -1;
        }

        public int getUsedPlaces() {
            return usedPlaces;
        }

        public boolean isFull() {
            return usedPlaces == N;
        }

        public void printArray(){
            for(int i = 0; i < N; i++){
                System.out.println(array[i]);
            }
        }

        public void printReverseArray(){
            for(int i = usedPlaces-1; i >= 0; i--){
                System.out.println(array[i]);
            }
        }

        public void insertAfter(Element elem){
            elem.setNext(this.getNext());
            elem.setPrevious(this);
            if(this.getNext() != null) {
                this.getNext().setPrevious(elem);
            }
            this.setNext(elem);
        }

        public void insertBefore(Element elem){
            elem.setNext(this);
            elem.setPrevious(this.getPrevious());
            if(this.getPrevious() != null) {
                this.getPrevious().setNext(elem);
            }
            this.setPrevious(elem);
        }
    }

    private int N;
    private Element head = null;
    private Element tail = null;

    public TwoWayArrayLinkedList(int N){
        if(N < 1){
            throw new IllegalArgumentException();
        }
        this.N = N;

    }

    public boolean add(E e) {
        if(tail == null){
            tail = new Element();
            head = tail;
        }

        if(tail.isFull()){
            Element newElement = new Element();
            newElement.add(e);
            tail.setNext(newElement);
            newElement.setPrevious(tail);
            tail = newElement;
        } else {
            tail.add(e);
        }
        return true;
    }

    public void add(int index, E e){
        if(index == 0) {
            Element newElement = new Element();
            newElement.add(e);
            if(head != null) {
                head.insertBefore(newElement);
            }
            head = newElement;
            if(!head.hasNext()) {
                tail = head;
            }


        } else {
            Element actual = head;
            while (actual != null && index >= actual.usedPlaces) {
                index = index - actual.usedPlaces;

                if (index == 0) {
                    Element next = new Element();
                    actual.insertAfter(next);
                    actual = actual.getNext();
                    break;
                }
                actual = actual.getNext();
            }

            if (actual == null) {
                throw new IndexOutOfBoundsException();
            }

            if (actual.isFull()) {
                E value = actual.getValue(actual.usedPlaces - 1);
                E temp;
                for (int i = index; i < actual.usedPlaces - 1; i++) {
                    temp = actual.getValue(i + 1);
                    actual.add(i + 1, actual.getValue(i));
                }
                actual.add(index, e);
                Element next = new Element();
                next.add(value);
                actual.insertAfter(next);
            } else {
                actual.add(index, e);
            }
        }
    }

    public void clear(){
        head = null;
        tail = null;
    }

    public int indexOf(E data){
        Element actual = head;
        int index = -1;
        int elements = 0;
        while(actual != null && index == -1){
            index = actual.check(data);
            if(index == -1) {
                elements += actual.usedPlaces;
                actual = actual.getNext();
            }
        }
        if(index == -1){
            return index;
        }
        return elements + index ;
    }

    public E get(int index){
//        if(index < 0){
//            throw new IllegalArgumentException();
//        }
//        Element actual = head;
//        while(actual != null && index >= actual.getUsedPlaces()){
//            index = index - actual.usedPlaces;
//            actual = actual.getNext();
//        }
//        if(actual == null){
//            throw new IndexOutOfBoundsException();
//        }
        Object[] list = findActual(index);
        Element actual = (Element) list[0];
        return actual.getValue((int) list[1]);
    }

    public E set(int index, E data){
//        E actual = get(index);
//        add(index, data);
//        return actual;

//        while(actual != null && index >= actual.getUsedPlaces()){
//            index = index - actual.usedPlaces;
//            actual = actual.getNext();
//        }
//        if(actual == null){
//            throw new IndexOutOfBoundsException();
//        }
        Object[] list = findActual(index);
        Element actual = (Element) list[0];
        E replaced = actual.setValue(data,(int) list[1]); //0
//        actual.add((int) list[1] ,data);
        return replaced;
    }

    public E remove(int index){
//        Element actual = head;
//
//        if(index < 0 || head == null){
//            throw new IndexOutOfBoundsException();
//        }
//
//        while(actual != null && index >= actual.getUsedPlaces()){
//            index = index - actual.usedPlaces;
//            actual = actual.getNext();
//        }
//
//        if(actual == null){
//            throw new IndexOutOfBoundsException();
//        }

        Object[] list = findActual(index);
        Element actual = (Element) list[0];
        return actual.remove((int) list[1]);
    }

    public boolean remove(E data){
        Element actual = head;
        int x = -1;
        while(actual != null){
            x = actual.check(data);
            if(x != -1){
                actual.remove(x);
                return true;
            } else {
                actual = actual.getNext();
            }
        }
        return false;
    }

    public int getN(){
        return N;
    }

    public int size() {
        Element actual = head;
        int size = 0;
        while(actual != null){
            size += actual.getUsedPlaces();
            actual = actual.getNext();
        }
        return size;
    }

    public void printList(){
        Element actual = head;
        while(actual != null){
            actual.printArray();
            actual = actual.getNext();
        }
    }

    public void printReverseList(){
        Element actual = tail;
        while(actual != null){
            actual.printReverseArray();
            actual = actual.getPrevious();
        }
    }

    public int amountElements(){
        int i = 1;
        Element actual = head;
        while(actual.hasNext()){
            i++;
            actual = actual.getNext();
        }
        return i;
    }

    public boolean isHeadFull(){
        return head.isFull();
    }

    public void printHead(){
        head.printArray();
    }

    private Object[] findActual(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        Element actual = head;
        while(actual != null && index >= actual.getUsedPlaces()){
            index = index - actual.usedPlaces;
            actual = actual.getNext();
        }
        if(actual == null){
            throw new IndexOutOfBoundsException();
        }
        Object[] list = new Object[2];
        list[0] = actual;
        list[1] = index;

        return list;
    }

    public int endCapacity(){
        if(tail != null) {
            return this.N - tail.usedPlaces;
        } else {
            return 0;
        }
    }

    public int capacity(){
        Element actual = head;
        int capacity = 0;
        while(actual != null){
            capacity += N - actual.usedPlaces;
            actual = actual.getNext();
        }
        return capacity;
    }

    public void defragment(){
        Element previous = head;
        Element next = null;
        if(head != null) {
            next = head.getNext();
        }
        while(next != null) {
            if (previous != null) {

                while (!previous.isFull()) {
                    E e = next.remove(0);
                    if (next.usedPlaces==0){
                        next = next.getNext();
                    }
                    if(e != null) {
                        previous.add(e);

                    } else {
                        previous = previous.getNext();
                        next = next.getNext();
                    }
                }
                previous = previous.getNext();
                next = next.getNext();
            }
        }
    }
}
