/**
 * Implementing stack using single linked list(ADT)
 * As we know in single linked list we have head and tail nodes
 * but here we use only use head one (we have changed data structure based on our needs of ADT)
 * Peek() -> return the value of top element in stack -> O(1)
 * Push() -> adding a element on Top of stack -> O(1)
 * Pop() -> return value of the top of the list and will remove it -> O(1)
 * getSize() -> return size of Stack -> O(1)
 * IsEmpty() -> check if stack is empty or not -> O(1)
 * @param <T> as type of elements in stack
 */
public class LStack<T>{
    /**
     * creating nodes of linked list
     * @param <T> as type of value of nodes
     */
    private static class Node<T>{
        private Node<T>next;
        private T value;
        public Node(Node <T> next,T value){
            this.value=value;
            this.next=next;
        }
    }

    Node <T> top;
    int size;
    /**
     * Initialize stack empty
     */
    public LStack(){
        top=null;
        size=0;
    }

    /**
     * if the stack wasn't empty
     * @param top_value as head of stack
     */
    public LStack(T top_value){
        top = new Node<>(null,top_value);
        size=1;
    }

    /**
     * return the top node value
     * @return value in a top
     */
    public T peek(){
        return top.value;
    }

    /**
     * push an element in head of stack
     * @param new_value as node we are pushing
     */
    public void push(T new_value){
        top= new Node<T>(top,new_value);
        size++;
    }

    /**
     * return node in a top and remove it from stack
     * @return node in a top value
     */
    public T pop(){
        T temp=top.value;
        top=top.next;
        size--;
        return temp;
    }

    /**
     * get size of stack
     * @return size of stack
     */
    public int getSize(){
        return size;
    }

    /**
     * check if it is empty or not
     * @return if it is empty
     */
    public boolean isEmpty(){
        return size==0;
    }
    public void print(){
        Node<T> temp = top;
        while (temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
}
