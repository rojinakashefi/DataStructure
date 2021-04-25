import java.util.Iterator;

/**
 * Singular linked list
 * each node has a next node and value
 * Size -> O(1)
 * Empty ->O(1)
 * AddLast -> O(1)
 * AddFirst ->O(1)
 * IndexOf -> O(n)
 * Insert (not first and last) ->O(n)
 * Contains -> O(n)
 * Remove element -> O(n)
 * Remove at-> finding index ->O(n)
 * RemoveFirst -> O(1)
 * RemoveLast ->O(n)
 * PeekFirst -> O(1)
 * PeekLast -> O(1)
 * ToString -> O(n)
 * @author rojina
 * @since April 2021
 */
public class SingularLinkedlist<T> implements Iterable<T> {

    int size;
    node<T> head, tail;

    /**
     * Creating node
     */
    private static class node<T> {
        T data;
        node<T> next;

        public node(T data, node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Constructor for singular linkedlist
     */
    public SingularLinkedlist() {
        size = 0;
        tail = head = null;
    }

    /**
     * size of linked list
     * @return size of linked list
     */
    public int size() {
        return size;
    }

    /**
     * Check if linked list is empty
     * @return if linked list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adding an element with value of data
     * creating node adding to tail next
     * @param data as value we want to make node with
     */
    public void addLast(T data) {
        addLast(new node<>(data, null));
        size++;
    }

    /**
     * we call this method in previous method
     * @param last as node we want to be tail
     */
    private void addLast(node<T> last) {
        if (size == 0) {
            head = tail = last;
        } else {
            tail.next = last;
            tail = tail.next;
        }
    }

    /**
     * adding an element to first of linked list
     * @param data as value of node we want to be head
     */
    public void addFirst(T data) {
        addFirst(new node<>(data, head));
        size++;
    }

    /**
     * we call this method in previous method
     * @param first as node we want to be head of list
     */
    private void addFirst(node<T> first) {
        if (size == 0) {
            head = tail = first;
        } else {
            head = first;
        }
    }

    /**
     * we want to find index of element -> O(n)
     * @param element as element we want to get index of
     * @return index of element
     */
    public int indexOf(T element) {
        node<T> tmp = head;
        for (int i = 0; i < size; i++, tmp = tmp.next) {
            if (tmp.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * if we want to insert in first place -> addFirst() ->O(1)
     * if we want to insert in last place -> addLast() ->O(1)
     * if we want to insert in middle of list ->O(n)
     * @param element as element we want to insert
     * @param index we want to add
     */
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is valid");
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {

            node<T> tmp = head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = new node<>(element, tmp.next.next);
            size++;
        }
    }

    /**
     * if our list contains of specific element ->O(n)
     * @param element as element we are looking for in a list
     * @return if our list contains our element
      */
    public boolean contain(T element) {
        for (node<T> tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.data.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * we should find the index of element to remove it ->O(n)
     * @param element as element we want to remove
     */
    public void remove(T element) {
        node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(element)) {
                removeAt(i);
            }
            temp = temp.next;
        }

    }

    /**
     * Remove from list using index
     * if index ==0 remove first element -> O(1)
     * if index==size-1 remove last element -> O(1)
     * if its middle it takes -> O(n)
     * @param index we want to remove from list
     */
    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            node<T> tmp = head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            size--;
        }

    }

    /**
     * removing first element
     * no time for searching to find the element
     * we know what it is because we know head and tail -> o(1)
     *
     */
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("no element to remove");
        } else if (size == 1) {
            head = tail = null;
            size--;
        } else {
            head = head.next;
            size--;
        }
    }

    /**
     * removing the last element based on tail
     * to find previous element of tail we should iterate to find it and make it tail of list -> O(n)
     */
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("no element to remove");
        } else if (size == 1) {
            head = tail = null;
            size--;
        } else {
            node<T> temp;
            for (temp = head; temp.next.next != null; temp = temp.next) {
            }
            temp.next = null;
            tail = temp;
            size--;
        }
    }

    /**
     * return head value
     * @return value of head
     */
    public T peekFirst() {
        if (size != 0) {
            return head.data;
        }
        return null;
    }

    /**
     * return tail value
     * @return value of tail
     */
    public T peekLast() {
        if (size != 0) {
            return tail.data;
        }
        return null;
    }

    /**
     * making string by iterating throw our list -> O(n)
     * @return string of our linked list
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Linked list : [");
        for (node<T> tmp = head; tmp != null; tmp = tmp.next) {
            stringBuilder.append(tmp.data).append(" -> ");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * used for each
     * @return iterator of our program
     */
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            node<T> temp=head;
            @Override
            public boolean hasNext() {
                return temp!=null;
            }
            @Override
            public T next() {
                T data=temp.data;
                temp=temp.next;
                return data;
            }
        };
    }
}
