import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class HeapyBinarySearchTree<T>{
    private Node root;
    private final Comparator<T> tComparator;
    private final Comparator<Integer> iComparator;
    private int size = 0;

    public HeapyBinarySearchTree(Comparator<T> tComparator, Comparator<Integer> iComparator){
        this.tComparator = tComparator;
        this.iComparator = iComparator;
        this.root = null;
    }

    public void insert(T value){
        if(value != null) {
            root = insert(root, value, null);
        }
    }

//    public void insert(T value, int priority){
//        if(value != null) {
//            root = insert(root, value, null, priority);
//        }
//    }

    private Node insert(Node node, T value, Node previous){
        if(node == null){
            node = new Node(value);
            size++;
            return node;
        }
        if(tComparator.compare((T) node.getValue(),value) > 0){
            node.setLeft(insert(node.getLeft(), value, node));
            if(node.getLeft() != null && iComparator.compare(node.getPriority(), node.getLeft().getPriority()) < 0){
                return rightRotation(previous, node);
            }
        } else if (tComparator.compare((T) node.getValue(),value) < 0){
            node.setRight(insert(node.getRight(), value, node));
            if(node.getRight() != null && iComparator.compare(node.getPriority(), node.getRight().getPriority()) < 0){
                return leftRotation(previous, node);
            }
        } else {
            throw new IllegalArgumentException("Duplikat: " + value);
        }
        return node;
    }

//    private Node insert(Node node, T value, Node previous, int priority){
//        if(node == null){
//            node = new Node(value, priority);
//            return node;
//        }
//        if(tComparator.compare((T) node.getValue(),value) > 0){
//            node.setLeft(insert(node.getLeft(), value, node, priority));
//            if(node.getLeft() != null && node.getPriority() < node.getLeft().getPriority()){
//                return rightRotation(previous, node);
//            }
//        } else if (tComparator.compare( (T) node.getValue(),value) < 0){
//            node.setRight(insert(node.getRight(), value, node, priority));
//            if(node.getRight() != null && node.getPriority() < node.getRight().getPriority()){
//                return leftRotation(previous, node);
//            }
//        } else {
//            throw new IllegalArgumentException("Duplikat: " + value);
//        }
//        return node;
//    }

    private Node leftRotation(Node previous, Node node){
        if(node.getRight() != null){
            Node temp = node.getRight();
            if (previous == null) {
                this.root = temp;
                node.setRight(temp.getLeft());
                temp.setLeft(node);
                return temp;
            } else if (previous.getRight() == node) {
                previous.setRight(temp);
                node.setRight(temp.getLeft());
                previous.getRight().setLeft(node);
                return previous.getRight();
            } else {
                previous.setLeft(temp);
                node.setRight(temp.getLeft());
                previous.getLeft().setLeft(node);
                return previous.getLeft();
            }
        } else {
            throw new NullPointerException();
        }
    }

    private Node rightRotation(Node previous, Node node){
        if(node.getLeft() != null){
            Node temp = node.getLeft();
            if (previous == null) {
                this.root = temp;
                node.setLeft(temp.getRight());
                temp.setRight(node);
                return temp;
            } else if (previous.getLeft() == node) {
                previous.setLeft(temp);
                node.setLeft(temp.getRight());
                previous.getLeft().setRight(node);
                return previous.getLeft();
            } else {
                previous.setRight(temp);
                node.setLeft(temp.getRight());
                previous.getRight().setRight(node);
                return previous.getRight();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public boolean search(T value){
        if(value != null) {
            Node node = search(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    private Node search(Node node, T value){
        if(node == null || tComparator.compare((T) node.getValue(), value) == 0){
            return node;
        }
        if(tComparator.compare((T) node.getValue(),value) > 0){
            return search(node.getLeft(), value);
        }
        return search(node.getRight(), value);
    }

    public void remove(T value){
        if(value != null) {
            remove(root, value);
        }
    }

    private void remove(Node node, T value){
        Node previous = null;
        int compare = 1;
        while(node != null & compare != 0){
            compare = tComparator.compare((T)node.getValue(), value);
            if(compare > 0){
                previous = node;
                node = node.getLeft();
            } else if (compare < 0) {
                previous = node;
                node = node.getRight();
            }
        }
        if(node == null){
            System.out.println("W drzewie nie ma wartości " + value);
        } else {
            --size;
            if(node.getLeft() == null && node.getRight() == null){
                if(node == root){
                    root = null;
                } else if(previous.getLeft() == node){
                    previous.setLeft(null);
                } else {
                    previous.setRight(null);
                }
            } else {
                while(node.getLeft() != null || node.getRight() != null){
                    if(node.getLeft() != null && node.getRight() != null){
                        compare = iComparator.compare(node.getLeft().getPriority(), node.getRight().getPriority());
                    } else {
                        compare = 0;
                    }
                    if(node.getRight() != null && compare < 0) {
                        previous = leftRotation(previous, node);
                        node = previous.getLeft();
                    } else if(node.getLeft() != null){
                        previous = rightRotation(previous, node);
                        node = previous.getRight();
                    } else {
                        previous = leftRotation(previous, node);
                        node = previous.getLeft();
                    }
                }
                if(previous.getLeft() == node){
                    previous.setLeft(null);
                } else {
                    previous.setRight(null);
                }
            }
        }
    }

    public void clear(){
        this.size = 0;
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getSize(){
        return this.size;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node != null){
            printNode(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node != null){
            inOrder(node.getLeft());
            printNode(node);
            inOrder(node.getRight());
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            printNode(node);
        }
    }

    private void printNode(Node node){
        System.out.print(node.toString());
    }

    public void printTree(){
        if(root != null) {
            printTree(root);
        } else {
            System.out.println("DRZEWO JEST PUSTE!!!!!");
        }
    }

    private void printTree(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node actual = queue.poll();
            printNode(actual);

            if (actual.getLeft() != null) {
                queue.add(actual.getLeft());
            }

            if (actual.getRight() != null) {
                queue.add(actual.getRight());
            }
        }
    }

    public Node getRoot(){
        return root;
    }

}



























//        if(node == null){
//            node = new Node(value);
//            return node;
//        }
//        if(comparator.compare(node.value,value) > 0){
//            node.left = insert(node.left, value, node);
//            if(node.priority < node.left.priority){
//                rightRotation(previous, node);
//                return node.left;
//            }
//        } else if (comparator.compare(node.value,value) < 0){
//            node.right = insert(node.right, value, node);
//            if(node.priority < node.right.priority){
//                leftRotation(previous, node);
//                return node.right;
//            }
//        } else {
//            throw new IllegalArgumentException("Duplikat: " + value);
//        }
//        return node;