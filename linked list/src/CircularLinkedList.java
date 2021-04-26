import java.util.Iterator;

/**
 * Circular linkedlist
 * A linked list which in tail next is head and head previous is tail
 * size() -> O(1)
 * Empty()-> O(1)
 * AddLast()-> O(1)
 * AddFirst()->O(1)
 * Insert(not first and last) -> O(n)
 * IndexOf() -> O(n)
 * Contain() -> O(n)
 * Remove () -> O(n)
 * RemoveAt(not first and last) -> O(n)
 * RemoveFirst() -> O(1)
 * RemoveLast() -> O(1)
 * PeekFirst() -> O(1)
 * PeekLast() -> O(1)
 * toString() ->O(n)
 * @author rojina kashefi
 * @since April 2021
 */
public class CircularLinkedList<T> implements Iterable {
    node<T> head, tail;
    int size;

    /**
     * each linked list contains of nodes which each node has previous and next node
     */
    private static class node<T> {
        T data;
        node<T> next;
        node<T> prev;

        node(T data, node<T> next, node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * constructor for making a linked list
     */
    public CircularLinkedList() {
        size = 0;
        head = tail = null;
    }

    /**
     * making list with first element in linked list
     * @param element as value of a node we want to add
     */
    public CircularLinkedList(T element) {
        this.size = 1;
        head = tail = new node<>(element, null, null);
        head.prev = tail;
        tail.next = head;
    }

    /**
     * size of linked list -> o(1)
     * @return size of linked list
     */
    public int size() {
        return size;
    }

    /**
     * check if linked list has any element or not
     * @return if list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adding in last of linked list
     * first we create a node and because we have tail we say tail.next=new node
     * @param element as value we want to make node and add it last
     */
    public void addLast(T element) {
        addLast(new node<>(element, head, tail));
        size++;
    }

    /**
     * we call this method at previous method
     * @param element as node we want to add last
     */
    private void addLast(node<T> element) {
        if (size == 0) {
            head = tail = element;
        } else {
            head.prev = element;
            tail.next = element;
            tail = element;
        }
    }

    /**
     * adding a node in front of list by telling head.prev=new node
     * @param element as value of node we want to add last
     */
    public void addFirst(T element) {
        addFirst(new node<>(element, head, tail));
        size++;
    }

    /**
     * we call this method at previous method to addFirst a node
     * @param element as node we want to add first
     */
    private void addFirst(node<T> element) {
        if (size == 0) {
            head = tail = element;
        } else {
            tail.next = element;
            head.prev = element;
            head = element;
        }
    }

    /**
     * inserting a node with value of element in a list
     * if we insert in index=0 it means we are adding in first of list -> O(1)
     * if we insert in index=size it means we are adding in last of list -> O(1)
     * if we want to inset in middle of list it takes O(n) to find the index we want to insert in
     * @param index as place we want to add node in
     * @param element as node we want to add in a list
     */
    public void insert(int index, T element) {
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }
        else {
            node<T> temp = head;
            for (int i = 0; i < index - 1; i++,temp=temp.next);
            node<T> new_node = new node<>(element, temp.next, temp);
            temp.next.prev = new_node;
            temp.next = new_node;
            size++;
        }

    }

    /**
     * get index number of a node
     * @param element as value of a node we are looking in
     * @return the index number of a element
     */
    public int indexOf(T element) {
        node<T> tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.data.equals(element)) {
                return i;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    /**
     * check if list contain element
     * @param element as value of node we are searching in list
     * @return if our list contains that element or not
     */
    public boolean contains(T element) {
        node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * removing an element
     * we search index of element -> O(n)
     * if index==0 ->remove first() -> O(1)
     * if index==last element ->remove last() ->O(1)
     * the we use method remove at -> O(n)
     * @param element the element we want to remove
     */
    public void remove(T element) {
        removeAt(indexOf(element));
    }

    /**
     * we use this method in previous method
     * @param index of element we want to remove
     */
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
            size--;
        }

    }

    /**
     * removing first element of a list -> O(1)
     */
    public void removeFirst() {
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
    }

    /**
     * removing last element of a list -> O(1)
     */
    public void removeLast() {
        if(size==0){
            throw new IndexOutOfBoundsException("no element to remove");
        }
        else if(size==1){
            head=tail=null;
        }
       else {
            tail=tail.prev;
            tail.next=head;
            head.prev=tail;
        }
        size--;
    }

    /**
     * getting first node value of list -> O(1)
     * @return value
     */
    public T peekFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("no elements to peek");
        }
        return head.data;
    }

    /**
     * getting value of last node of list -> O(1)
     * @return value
     */
    public T peekLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("no elements to peek");
        }
        return tail.data;
    }

    /**
     * making iterator for our list use it in for eaches
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index=0;
            node<T> temp = head;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                if(index>=size){
                    System.out.println("");
                    throw new RuntimeException("end of list");
                }
                T data = temp.data;
                temp = temp.next;
                index++;
                return data;
            }
        };

    }

    /**
     * convert our list to string ->O(n)
     * @return string of our list
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("linked list : [");
        node<T> temp = head;
        for (int i = 0; i < size; i++, temp = temp.next) {
            stringBuilder.append(temp.data).append(" <-> ");
        }
        return stringBuilder.append("]").toString();
    }
}
