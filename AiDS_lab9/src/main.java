import java.util.List;
import java.util.Random;

public class main {
    private static Random random = new Random();

    public static void main(String[] args) {
        HeapyBinarySearchTree<Integer> HBST = new HeapyBinarySearchTree<Integer>(new IntegerComparator(), new IntegerComparator());
        BinarySearchTree<Integer> BST = new BinarySearchTree<>(new IntegerComparator());

        for(int i = 10; i >= 0; i--){
            HBST.insert(i);
        }

//        System.out.println("Size: " + HBST.getSize());
//        HBST.printTree();
//        HBST.remove(random.nextInt(0,11));
//        System.out.println("\nSize: " + HBST.getSize());
//        HBST.printTree();
//        System.out.println("\n" + HBST.search(random.nextInt(0,11)));

        List<Integer> list = Timer.generateList(10);

        for(int i = 9; i >= 0; --i){
            HBST.printTree();
            System.out.println();
            HBST.remove(list.get(i));
        }
        HBST.printTree();
        System.out.println();

//        BST.insert(10,100);
//        BST.insert(20, 50);
//        BST.insert(25, 500);
//        BST.insert(40, 150);
//        BST.insert(30, 150);
//        BST.insert(35, 200);
//        BST.insert(45, 350);
//        BST.insert(5,50);
//        BST.insert(15,200);
//        BST.insert(0,300);
//        BST.insert(-5,200);
//        BST.insert(-15,0);
//        BST.printTree();
//        System.out.println();
//        BST.remove(45);
//        BST.printTree();
//        System.out.println();

        Timer.startOrdered(5000,10);

    }

}
