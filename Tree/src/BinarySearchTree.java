enum TreeTraversalOrder {
    Pre_Order,
    In_Order,
    Post_Order,
    Level_Order

}

public class BinarySearchTree<T extends Comparable<T>> {
    private int size = 0;
    private node root = null;

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
    public node find(node Node, T element) {
        if (Node == null) {
            return null;
        }
        else if (element.compareTo(Node.value) < 0) {
            return find(Node.left, element);
        } else if (element.compareTo(Node.value) > 0) {
            return find(Node.right, element);
        } else {
            return Node;
        }
    }
    public boolean contain(node Node,T element){
        return find(Node, element) != null;
    }


    public void add(T element) {
        if (contain(root,element)) {
            System.out.println("Element exists,duplicate value");
        } else {
            if (size == 0) {
                root = new node(null, null, element);
            } else {
                add_subtrees(element);
            }
            size++;
        }
    }

    public void add_subtrees(T element) {
        node tmp = root;
        while (tmp != null) {
            if (element.compareTo(tmp.value) < 0) {
                if (tmp.left == null) {
                    tmp.left = new node(null, null, element);
                    break;
                }
                tmp = tmp.left;

            } else {
                if (tmp.right == null) {
                    tmp.right = new node(null, null, element);
                    break;
                }
                tmp = tmp.right;
            }
        }
    }

    public void remove(T element) {
        if (!contain(root, element)) {
            System.out.println("No elements with value " + element + " to be removed");
        } else {
            if (size == 1) {
                root = null;
            } else {
//                remove_subtrees(element);
            }
            size--;
        }
    }


    public node get_root() {
        return root;
    }
}
