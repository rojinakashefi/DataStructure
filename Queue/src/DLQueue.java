import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implemented Queue with doubly linked list
 * We can create our nodes which has previous and back
 * Or we can just use java linked list which is doubly linked list
 * Enqueue = add = offering    -> O(1)
 * Dequeue = poll = remove     -> O(1)
 * peeking -> O(1)
 * getSize  -> O(1)
 * isEmpty()  -> O(1)
 * print -> O(n)
 * @param <T> as type of elements we want to add to our queue
 */
public class DLQueue<T> implements Iterable<T>{
    //points to head of list
    node<T> head;
    //points to back of list
    node<T> back;
    int size;

    LinkedList<T> linkedList = new java.util.LinkedList<T>();

    private static class node<T> {

        node<T> next;
        node<T> prev;
        T value;

        private node(T value, node<T> next, node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public DLQueue() {
        head = null;
        back = null;
        size = 0;
    }

    public DLQueue(T value) {
        node<T> first = new node<>(value, null, null);
        head = back = first;
        size++;
        //linkedList.addLast(value);
    }

    /**
     * get size of list
     * @return size
     */
    public int getSize() {
        return size;
        //return linkedList.size();
    }

    /**
     * check if it is empty
     * @return true or false
     */

    public boolean isEmpty() {
        return size == 0;
        //return getSize()==0;
    }

    /**
     * adding T value at last of list
     * @param value as value we want to add
     */
    public void EnQueue(T value) {
        if(isEmpty()){
            node<T> first = new node<>(value, null, null);
            head = back = first;
        }
        else {
            back.next = new node<>(value, null, back);
            back = back.next;
        }
        size++;
        print();
        //linkedList.addLast(value);
    }

    /**
     * removing first element
     * @return the value we are removing
     */
    public T DeQueue() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        T temp = head.value;
        head = head.next;
        size--;
        //linkedList.removeFirst();
        print();
        return temp;
    }

    /**
     * give our first element in list
     * @return first element
     */
    public T peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("The queue is empty");

        }
        return head.value;
        //return linkedList.peek();
    }

    /**
     * printing linked list using iterator
     */
    public void print(){
//        for(T element: linkedList){
//            System.out.println(element);
//        }
//        System.out.println("================");
        node<T> temp=head;
        while (temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
        System.out.println("==================================");
    }

    /**
     * @return iterator for iterating the list
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            node<T> temp =head;
            @Override
            public boolean hasNext() {
                return temp!=null;
            }
            @Override
            public T next() {
                T data=temp.value;
                temp=temp.next;
                return data;
            }
        };
      //  return linkedList.iterator();

    }

    public LinkedList<T> getLinkedList() {
        return linkedList;
    }
}
