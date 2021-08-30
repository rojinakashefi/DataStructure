import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(10);
        bst.add(12);
        bst.add(11);
        bst.add(14);
        bst.add(13);
        bst.add(15);
        bst.add(8);
        bst.add(9);
        bst.add(7);
        Iterator<Integer> it = bst.Post_Order_traversal();
        while(it.hasNext()){
            Integer i = it.next();
            System.out.println(i);
        }
    }
}
