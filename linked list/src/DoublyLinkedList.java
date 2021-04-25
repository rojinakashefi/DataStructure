import java.util.Iterator;

/**
 * Doubly linked list
 * In this implementations of linked list each node beside next node has previous node.
 * Clear list() -> O(n)
 * Size() -> O(1)
 * Is Empty() -> O(1)
 * AddLast() -> O(1)
 * AddFirst() -> O(1)
 * Insertion in middle -> O(n)
 * Index number -> O(n)
 * PeekFirst -> O(1)
 * PeekLast -> O(1)
 * RemoveFirst -> O(1)
 * RemoveLast -> O(1)
 * RemoveMiddle -> O(1)
 * RemoveIndex(not first or last) -> O(n)
 * RemoveElement -> O(n)
 * Contain -> O(n)
 * ToString -> O(n)
 * @since April 2021
 * @author rojina kashefi
 */
public class DoublyLinkedList<T> implements Iterable<T> {
    int size;
    node<T> head;
    node<T> tail;

    /**
     * Class node
     * linked list are made of nodes
     */
    private static class node<T> {
        T data;
        node<T> prev, next;
        public node(T data, node<T> prev, node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Making a doubly linked list with constructor
     */
    public DoublyLinkedList() {
        size = 0;
        head = tail = null;
    }

    /**
     * clearing list in O(n)
     * making all elements null
     */
    public void clearList() {
        node<T> temp = head;
        while (temp != null) {
            node<T> next_of_temp = temp.next;
            //deallocate with setting to null
            temp.prev = null;
            temp.next = null;
            temp.data = null;
            temp = next_of_temp;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * return size in time of O(1)
     * @return size as size of linked list
     */
    public int size() {
        return size;
    }

    /**
     * check if list is empty based on it size O(1)
     * @return if a list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adding an element to last of list
     * if list is empty we will just create node o(1)
     * If list is full we will create node and declare it as tail O(1)
     * @param data as the date the node we should add at tail
     */
    public void addLast(T data) {
        if (isEmpty()) {
            tail = head = new node<>(data, null, null);
        } else {
            tail.next = new node<>(data, tail, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * same implementation as top we can call this method at previous method
     * @param element as node we have to add in end
     */
    private void addLast(node<T> element){
        if(tail==null){
            head=tail=element;
        }
        tail.next=element;
        tail=tail.next;
    }

    /**
     * We add a node in front of list as head of list
     * we should make a node an make it head of list O(1)
     * @param data as value of node we should add infront of list
     */
    public void addFirst(T data) {
        if (isEmpty()) {
            tail = head = new node<>(data, null, null);
        } else {
            head.prev = new node<>(data, null, head);
            head = head.prev;
        }
        size++;
    }

    /**
     * we can call this method in previous method.O(1)
     * @param element as node we want add in front
     */
    private void addFirst(node<T> element){
        if(isEmpty()){
            tail=head=element;
        }
        else{
            element.next=head;
            head=element;
        }
    }

    /**
     * Insertion is a fast operation for linkedlist
     * if index=0 means we want to add in first element O(1)
     * if index=size means we want to add at last O(1)
     * else if we should iterate to find index O(n)
     * insertion of an elemenet takes o(1)
     * @param index as place of element we want to add
     * @param element as value of element we want to add
     */
    public void insert(int index,T element){
        node<T> temp=head;
        if(index==0){
            addFirst(element);
        }
        if(index==size){
            addLast(element);
        }
        else{
            node <T> trav = head;
            for (int i = 0; i < index - 1; i++, trav = trav.next);
            node<T> newNode = new node<>(element,trav,trav.next);
            trav.next.prev = newNode;
            trav.next = newNode;
            ++size;
        }
    }

    /**
     * finding index of an element O(n)
     * @param data as element we are looking index for
     * @return index number of element
     */
    public int indexOf(T data){
        int index=-1;
        for (node<T> temp=head;temp!=null;temp=temp.next){
            index++;
            if(temp.data.equals(data)){
                return index;
            }
        }
        return index;
    }

    /**
     * get head value O(1)
     * @return value of head
     */
    public T peekFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException("List is empty");
        return head.data;
    }

    /**
     * get tail value O(1)
     * @return value of last
     */
    public T peekLast() {
        if (isEmpty()) throw new IndexOutOfBoundsException("List is empty");
        return tail.data;
    }

    /**
     * Removing first elements o(1)
     */
    public void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;
        if (isEmpty()) {
            tail = null;
        }
    }

    /**
     *Removing last elements o(1)
     */
    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
        if (isEmpty()) {
            head = null;
        }
    }

    /**
     * remove a specific a node
     * if node.pre is null it means it head  ->removeFirst o(1)
     * if node.next is null it means its tail -> removeLast o(1)
     * in middle also takes O(1)
     * @param to_remove as node we want to remove
     */
    public void remove(node<T> to_remove) {
        if(to_remove.prev==null){
            removeFirst();
        }
        if(to_remove.next==null){
            removeLast();
        }
        to_remove.prev.next=to_remove.next;
        to_remove.next.prev=to_remove.prev;

        to_remove.data=null;
        to_remove.prev=null;
        to_remove.next=null;
        size--;

    }

    /**
     * removing a special index
     * remove 0 index -> O(1)
     * remove last index ->O(1)
     * remove middle index ->O(n)
     * @param index as index we want to remove
     */
    public void removeAt(int index) {

        if(index<0||index>size){
            throw new IndexOutOfBoundsException("index invalid");
        }
        if(index==0){
            removeFirst();
            return;
        }
        else if(index==size-1){
            removeLast();
            return;
        }
        node<T> temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        temp.next.next.prev=temp;
        temp.next=temp.next.next;
        size--;
    }

    /**
     * as value of element we want to remove
     * cause we dont know what element it is we shoul iterate our list
     * O(n)
     * @param element as value of node we want to remove
     */
    public void remove(T element){
        boolean found=false;
        node<T> temp=head;
        for(int i=0;i<size;i++,temp=temp.next){
            if(temp.data.equals(element)){
                found=true;
               removeAt(i);
            }
        }
        if(!found){
            System.out.println("no such an element");
        }
    }

    /**
     * get index of specific node
     * @param index_node as node we want to have its index
     * @return number of index
     */
    public int indexOf(node<T> index_node) {
        node<T> tmp=head;
        for(int i=0;i<size;i++){
            if(tmp==index_node){
                return i;
            }
            tmp=tmp.next;
        }
        return -1;
    }

    /**
     * check if our list contains a specific element O(n)
     * @param contain_node as node we want to check
     * @return if it contains
     */
    public boolean contains(node<T> contain_node) {
        node<T> tmp=head;
        for(int i=0;i<size;i++){
            if(tmp==contain_node){
                return true;
            }
            tmp=tmp.next;
        }
        return false;
    }

    /**
     * convert our linked list to string
     * @return string of our linkedlist
     */
    @Override
    public String toString() {
      StringBuilder stringBuilder=new StringBuilder();
      stringBuilder.append("linked list : [");
      for(node<T> temp=head;temp!=null;temp=temp.next){
          stringBuilder.append(temp.data).append(" <-> ");
      }
      stringBuilder.append(']');
      return stringBuilder.toString();
    }

    /**
     * write an iterator for our list
     * used in for each
     * @return iterator of our list
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
                T data=temp.data;
                temp=temp.next;
                return data;
            }
        };
    }
}
