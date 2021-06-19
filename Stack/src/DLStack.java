import java.util.LinkedList;

/**
 * Implementing stack using doubly linked list
 * It has head and previous
 * The difference between doubly linked list and single linked list is top node is previous is null
 * And the last element in stack next is null.
 * The time complexity is same as implementing stack using single linked list.
 * @param <T> as type of values we want to store in stack.
 * Instead of implementing doubly linked list by ourselves we can import java linked list which it self is doubly linked list
 */
public class DLStack<T> {
    Node <T> top;
    int size;
    private class Node<T>{

        private Node<T> next;
        private Node<T> previous;
        private T value;
        public Node(T value,Node<T> next,Node<T> previous){
            this.value=value;
            this.next=next;
            this.previous=previous;
        }
    }
    //private java.util.LinkedList <T> list = new LinkedList<T>();

    public DLStack(){
        top=null;
        size=0;
    }
    public DLStack(T value){
        top=new Node<>(value,null,null);
        size=1;
        //push(value);
    }
    public void push(T value){
        top = new Node<>(value,top,null);
        size++;
        //list.addLast(value);
    }
    public T pop(){
        T temp= top.value;
        top=top.next;
        size--;
        //return list.removeLast();
        return temp;
    }
    public T peek(){
        //return list.peekLast();
        return top.value;
    }
    public int getSize(){
        //return list.size();
        return size;
    }
    public boolean isEmpty(){
        //return list.size()==0;
        return size==0;
    }
    public void print(){
        Node<T> temp = top;
        System.out.println("top is :" + temp.value);
        while (temp!=null){
            System.out.print(temp.value +" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
