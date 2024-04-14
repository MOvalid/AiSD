import java.util.Random;

public class Node<T> {
    private final Random random = new Random();
    private T value;
    private int priority;
    private Node left;
    private Node right;

    public Node(T value) {
        this.value = value;
        this.priority = random.nextInt(1, 10000);
    }

    public Node(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String toString() {
        return this.value + "(" + this.priority + ") ";
    }

}
