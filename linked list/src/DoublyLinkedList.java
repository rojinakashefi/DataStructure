import org.w3c.dom.Node;

import java.util.Iterator;
public class DoublyLinkedList<T> implements Iterable<T> {
    int size;
    node<T> head;
    node<T> tail;
    private static class node<T> {
        T data;
        node<T> prev, next;
        public node(T data, node<T> prev, node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public DoublyLinkedList() {
        size = 0;
        head = tail = null;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T data) {
        if (isEmpty()) {
            tail = head = new node<>(data, null, null);
        } else {
            tail.next = new node<>(data, tail, null);
            tail = tail.next;
        }
        size++;
    }
    private void addLast(node<T> element){
        if(tail==null){
            head=tail=element;
        }
        tail.next=element;
        tail=tail.next;
    }
    public void addFirst(T data) {
        if (isEmpty()) {
            tail = head = new node<>(data, null, null);
        } else {
            head.prev = new node<>(data, null, head);
            head = head.prev;
        }
        size++;
    }
    private void addFirst(node<T> element){
        if(isEmpty()){
            tail=head=element;
        }
        else{
            element.next=head;
            head=element;
        }
    }
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
    public T peekFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException("List is empty");
        return head.data;
    }
    public T peekLast() {
        if (isEmpty()) throw new IndexOutOfBoundsException("List is empty");
        return tail.data;
    }
    public void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;
        if (isEmpty()) {
            tail = null;
        }
    }
    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
        if (isEmpty()) {
            head = null;
        }
    }
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
