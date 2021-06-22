import java.util.Iterator;
/**
 * Implemented our queue with single linked list
 * each node has only next pointer
 * getSize() -> O(1)
 * IsEmpty() -> O(1)
 * Enqueue() -> O(1)
 * Dequeue() -> O(1)
 * Peek()  -> O(1)
 * print() -> O(n)
 * @param <T>
 */
public class SLQueue<T> implements Iterable<T>{

    node<T>head;
    node<T>back;
    int size;

    private static class node<T>{
        node<T> next;
        T value;
        private node(T value,node<T> next){
            this.value=value;
            this.next=next;
        }
    }

    public SLQueue(){
        head=back=null;
        size=0;
    }

    public SLQueue(T value){
        head=back = new node<>(value,null);
    }

    /**
     * get size of linked list
     * @return size of linked list
     */
    public int getSize(){
        return size;
    }

    /**
     * check if linekd list is empty or not
     * @return true or false
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * adding element at last of queue
     * @param value as value we want to add
     */
    public void Enqueue(T value){
        if(!isEmpty()) {
            back.next = new node<>(value, null);
            back = back.next;
        }
        else {
            head=back = new node<>(value,null);
        }
        size++;
        print();
    }

    /**
     * removing first element of queue
     * @return the value of element we are removing
     */
    public T deQueue(){
        T temp= head.value;
        head=head.next;
        size--;
        print();
        return temp;
    }

    /**
     * @return value of head of queue
     */
    public T peek(){
        return head.value;
    }

    /**
     * printing
     */
    public void print(){
        node<T> temp=head;
        while (temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
        System.out.println("==========================");
    }

    /**
     * @return an iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            node<T> temp=head;
            @Override
            public boolean hasNext() {
                return temp!=null;
            }

            @Override
            public T next() {
               T value =temp.value;
               temp=temp.next;
               return value;
            }
        };
    }
}
