import java.util.*;

public class TreeHeap<T> implements Heap<T> {

    class Node{
        T value;
        Node left;
        Node right;

        Node(T value){
            this.value = value;
        }

        Node(T value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private final Comparator<T> comparator;
    private Node root;
    private int capacity = 0;

    public TreeHeap(Comparator<T> comparator){
        this.comparator = comparator;
        this.root = null;
    }

    @Override
    public void clear() {
        root = null;
        capacity = 0;
    }

    @Override
    public void add(T element) {
        if(element != null) {
            Node node = root;
            if (node == null) {
                root = new Node(element);
            } else {
                int[] move = binary(capacity + 1);
                Node previous = null;
                T actual = element;
                for (int i = 0; i < move.length; i++) {
                    if (comparator.compare(node.value, actual) > 0) {
                       actual = swap(actual,node);
                    }
                    previous = node;
                    if (move[i] == 1) {
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                }
                if (move[move.length - 1] == 1) {
                    previous.right = new Node(actual);
                } else {
                    previous.left = new Node(actual);
                }
            }
            capacity++;
        }
    }

    private int[] binary(int n){
        int x = n;
        int size = 0;
        while(x > 1){
            x = x/2;
            size++;
        }
        int[] moves = new int[size];
        for (int top = size-1; n > 1; top--){
            moves[top] = n % 2;
            n = n/2;
        }
        return moves;
    }

    private T swap(T actual, Node node){
        T temp;
        temp = actual;
        actual = node.value;
        node.value = temp;
        return actual;
    }

    @Override
    public T minimum() {
        if(root != null){
            T minimum = root.value;
            Node previous = null;
            Node actual = root;
            while(actual != null) {
                if (actual.left != null && actual.right != null) {
                    previous = actual;
                    if (comparator.compare(actual.left.value, actual.right.value) > 0) {
                        actual.value = actual.right.value;
                        actual = actual.right;
                    } else {
                        actual.value = actual.left.value;
                        actual = actual.left;
                    }
                } else if (actual.left != null) {
                    actual.value = actual.left.value;
                    actual.left = null;
                    break;
                } else if (previous == null){
                    root = null;
                    break;
                } else {
                    int[] move = binary(capacity);
                    Node temp = root;
                    for (int i = 0; i < move.length; i++) {
                        previous = temp;
                        if (move[i] == 1) {
                            temp = temp.right;
                        } else {
                            temp = temp.left;
                        }
                    }
                    actual.value = temp.value;
                    if(move[move.length-1] == 0){
                        previous.left = null;
                    } else {
                        previous.right = null;
                    }
                    break;
                }
            }
            --capacity;
            return minimum;
        } else {
            System.out.println("KOPIEC JEST PUSTY!!!!!!!");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public void printHeap(){
        if(root != null) {
            printHeap(root);
        }
    }

    private void printHeap(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node actual = queue.poll();
            System.out.print(actual.value + " ");

            if (actual.left != null) {
                queue.add(actual.left);
            }

            if (actual.right != null) {
                queue.add(actual.right);
            }
        }
    }

    public void getCapacity(){
        System.out.println(capacity);
    }






















































//    public void add(T element){
//        if(element != null) {
//            Node previous = null;
//            Node actual = root;
//            capacity++;
//            if (actual == null) {
//                root = new Node(element);
//            } else {
//                int[] move = binary(capacity);
//                for(int i = 0; i < move.length; i++){
//                    previous = actual;
//                    if (move[i] == 1) {
//                        actual = actual.right;
//                    } else {
//                        actual = actual.left;
//                    }
//                }
//                actual = new Node(element);
//                if(move[move.length-1] == 1){
//                    previous.right = actual;
//                } else {
//                    previous.left = actual;
//                }
//                actual.value = root.value;
//                root.value = element;
//                repair(move);
//            }
//        }
//
//    }

//    private void repair(int[] move){
//        Node previous;
//        Node actual;
//        T temp;
//        int counter = capacity;
//        while(counter > 0){
//            previous = null;
//            actual = root;
//            for (int i = 0; i < move.length; i++) {
//                previous = actual;
//
//                if (move[i] == 1) {
//                    actual = actual.right;
//                } else {
//                    actual = actual.left;
//                }
//                if(actual != null) {
//                    if (comparator.compare(previous.value, actual.value) > 0) {
//                        temp = previous.value;
//                        previous.value = actual.value;
//                        actual.value = temp;
//                    }
//                }
//                if(previous.left != null && move[i] == 1){
//                    if (comparator.compare(previous.value, previous.left.value) > 0) {
//                        temp = previous.value;
//                        previous.value = previous.left.value;
//                        previous.left.value = temp;
//                    }
//                }
//                if(previous.right != null && move[i] == 0){
//                    if (comparator.compare(previous.value, previous.right.value) > 0) {
//                        temp = previous.value;
//                        previous.value = previous.right.value;
//                        previous.right.value = temp;
//                    }
//                }
//            }
//            move = binary(counter);
//            counter = counter/2;
//        }
//    }


//    public T minimum(){
//        if(root != null) {
//            T minimum = root.value;
//            Node previous = null;
//            Node actual = root ;
//            int[] move = binary(capacity);
//            for(int i = 0 ; i < move.length; i++){
//                previous = actual;
//                if(move[i] == 1){
//                    actual = actual.right;
//                } else {
//                    actual = actual.left;
//                }
//            }
//            root.value = actual.value;
//            capacity--;
//            if(previous != null) {
//                if (move[move.length - 1] == 1) {
//                    previous.right = null;
//                } else {
//                    previous.left = null;
//                }
//                repair(move);
//            } else {
//                root = null;
//            }
//            return minimum;
//        }
//        return null;
//    }

}
