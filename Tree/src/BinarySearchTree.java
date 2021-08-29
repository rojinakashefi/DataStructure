/**
 * enum for traversal order
 */
enum TreeTraversalOrder {
    //print first then recurse on left and right subtrees
    Pre_Order,
    //recurse on one subtree then print between them and recurse on another one
    In_Order,
    //first recurse on both subtree and then print
    Post_Order,
    //print each level
    Level_Order

}

/**
 * Implementing Binary search tree
 * @param <T> as comparable element which we want to check binary search invariant
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private int size = 0;
    private node root = null;

    /**
     * trees are made of nodes
     * each node has a left child and a right child and a value
     */
    private class node {
        node right;
        node left;
        T value;

        public node(node right, node left, T value) {
            this.right = right;
            this.left = left;
            this.value = value;
        }

    }

    /**
     * recurse till it finds the element we are looking for
     * @param Node as the first node we want to start the searching from
     * @param element as value we are looking for
     * @return the node with element value
     */
    public node find(node Node, T element) {
        //if we dont find it we will return null
        if (Node == null) {
            return null;
            //if the element we are looking for is smaller than the current node
            //we will recurse on the left nodes of current node
        } else if (element.compareTo(Node.value) < 0) {
            return find(Node.left, element);
            //if the element we are looking for is bigger than the current node
            //we will recurse on the righy nodes of current node
        } else if (element.compareTo(Node.value) > 0) {
            return find(Node.right, element);
        } else {
            //if we find it we return the node
            return Node;
        }
    }

    /**
     * based of find method
     * if it returns null it means there is no such a value in tree
     * if not it returns the node of value we are looking for
     * @param Node as node we want to start searching from
     * @param element as value we want to make sure our tree contains
     * @return if it contains it or not
     */
    public boolean contain(node Node, T element) {
        return find(Node, element) != null;
    }

    /**
     * check if tree is empty or not
     * @return if it is empty returns true
     */

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * check size
     * @return size
     */

    public int size(){
        return size;
    }

    /**
     * adding an element to tree
     * @param element as we are adding to tree
     */
    public void add(T element) {
        //first check if the tree contains it  or not
        //if not we will add it
        //we cant have duplicate value
        if (contain(root, element)) {
            System.out.println("Element exists,duplicate value");
        } else {
            root = add(root, element);
            size++;
        }
    }

    /**
     * check where should we add a node to a tree
     * if the node we want to add is empty we create a one
     * @param Node as the root node of tree we want to add a element to its subtrees
     * @param element as value we want to add
     * @return the root node (it might be updated)
     */
    private node add(node Node, T element) {
        if (Node == null) {
            Node = new node(null, null, element);
        } else {
            if (element.compareTo(Node.value) < 0) {
                Node.left = add(Node.left, element);
            } else {
                Node.right = add(Node.right, element);
            }
        }
        return Node;
    }

    /**
     * removing element from tree
     * @param elem as element we want to remove
     */
    public void remove(T elem) {
        //check if there is such an element in tree
        if(!contain(root,elem)){
            System.out.println("No element with value " + elem);
        }
        else {
            root = remove(root, elem);
            size--;
        }

    }

    /**
     * first find that element
     * then replace it with 4 situations
     * @param Node as the root node of a tree we want to remove an element within it
     * @param elem as element we want to remove
     * @return the updated root node
     */

    private node remove(node Node, T elem) {
        if (Node == null) return null;
        int cmp = elem.compareTo(Node.value);
        //it will find the element we are looking for removing
        if (cmp < 0) {
            Node.left = remove(Node.left, elem);
        } else if (cmp > 0) {
            Node.right = remove(Node.right, elem);
            //found the element we are looking for removing
        } else {
            //we have 4 cases :
            //has only right subtree
            //has only left subtree
            //has both subtree
            //has no subtree -> return null
            if (Node.left == null) {
                return Node.right;
            } else if (Node.right == null) {
                return Node.left;
            } else {
                //we should replace the element we are removing
                //it can be smallest in right left subtree -> findMin
                //or it can be biggest in left subtree -> findMax
                node tmp = findMin(Node.right);
                //change the value of the node we want to remove
                //with element we have found to replace
                Node.value = tmp.value;
                //now we should remove the element we want to replace with node which we decide to remove
                //we call again the remove method on right subtree
                //cause we uses smallest element in right subtree
                //and it must be in there
                //whatever the result is it may affect the right subtree of the node we are replacing
                //
                Node.right = remove(Node.right, tmp.value);
                //node tmp = findMax(Node.left)
                //Node.value = tmp.value
                //Node.left = remove(Node.left,tmp.value)
            }
        }
        return Node;
    }

    /**
     * it is uses for finding the smallest value in right subtrees
     * which will be replaced with a node we want to delete
     * @param Node as start node of a tree we want to find smallest element
     * @return the smallest element
     */
    private node findMin(node Node) {
        //the smallest and downest element are in left subtrees
        while (Node.left != null) Node = Node.left;
        return Node;
    }

    /**
     * it is uses for finding the biggest value in left subtrees
     * which will be replaced with a node we want to delete
     * @param Node  as start node of a tree we want to find biggestt element
     * @return the biggest element
     */

    private node findMax(node Node) {
        //the biggest and downest element are in right subtrees
        while (Node.right != null) Node = Node.right;
        return Node;
    }

    /**
     * the height of tree
     * @return height
     */
    public int height(){
        return height(root);
    }

    /**
     * calculating height
     * @param Node as start of tree we want to calculate height
     * @return height
     */
    public int height(node Node){
        if(Node == null){
            return 0;
        }
        return Math.max(height(Node.left),height(Node.right))+1;
    }

    /**
     * getting root node
     * @return root node
     */
    public T get_root() {
        return root.right.right.value;
    }
//    public java.util.Iterator<T> TreeTraversalOrder (TreeTraversalOrder tree){
//        return switch (tree) {
//            case In_Order -> In_Order_traversal();
//            case Pre_Order -> Pre_Order_traversal();
//            case Post_Order -> Post_Order_traversal();
//            case Level_Order -> Level_Order_traversal();
//        };
//    }
//    public java.util.Iterator<T> In_Order_traversal(){
//
//    }
//    public java.util.Iterator<T> Pre_Order_traversal(){
//
//    }
//    public java.util.Iterator<T> Post_Order_traversal(){
//
//    }
//    public java.util.Iterator<T> Level_Order_traversal(){
//
//    }

}
