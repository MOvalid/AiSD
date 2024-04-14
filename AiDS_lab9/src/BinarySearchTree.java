import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T> {
    private Node root;
    private Comparator<T> comparator;
    private int size = 0;

    public BinarySearchTree(Comparator<T> comparator){
        this.root = null;
        this.comparator = comparator;
    }

    public void remove(T value){
        root = remove(root, value);
    }

    private Node remove(Node node, T value){
       if(node == null){
           return node;
       }
       if(comparator.compare((T) node.getValue(), value) > 0){
           node.setLeft(remove(node.getLeft(), value));
       } else if(comparator.compare((T) node.getValue(), value) < 0){
           node.setRight(remove(node.getRight(), value));
       } else {
           if(node.getLeft() == null){
               return node.getRight();
           } else if(node.getRight() == null){
               return node.getLeft();
           }
           node.setValue(minValue(node.getRight()));
           node.setRight(remove(node.getRight(),(T) node.getValue()));
       }
       return node;
    }

    public T minValue(Node node){
        T minimum = (T) this.root.getValue();
        while(node.getLeft() != null){
            minimum = (T) node.getLeft().getValue();
            node = node.getLeft();
        }
        return minimum;
    }

    public void insert(T value){
        root = insert(root, value);
    }


    private Node insert(Node node, T value) {
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(comparator.compare( (T) node.getValue(),value) > 0){
            node.setLeft(insert(node.getLeft(), value));
        } else if (comparator.compare( (T) node.getValue(),value) < 0){
            node.setRight(insert(node.getRight(), value));
        } else {
           throw new IllegalArgumentException("Duplikat: " + value);
        }
        return node;
    }

    public boolean search(T value){
        Node node = root;
        int compare;
        while(node != null){
            compare = comparator.compare( (T) node.getValue(), value);
            if(compare > 0){
                node = node.getLeft();
            } else if (compare < 0){
                node = node.getRight();
            } else {
                return true;
            }
        }
        return false;
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
            System.out.print(node);
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
            System.out.print(node);
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
            System.out.print(node);
        }
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
            System.out.print(actual);

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
