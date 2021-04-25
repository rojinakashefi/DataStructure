import java.util.Iterator;

public class CircularLinkedList<T> implements Iterable {
    node<T> head, tail;
    int size;

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

    public CircularLinkedList() {
        size = 0;
        head = tail = null;
    }

    public CircularLinkedList(T element) {
        this.size = 1;
        head = tail = new node<>(element, null, null);
        head.prev = tail;
        tail.next = head;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T element) {
        addLast(new node<>(element, head, tail));
        size++;
    }

    private void addLast(node<T> element) {
        if (size == 0) {
            head = tail = element;
        } else {
            head.prev = element;
            tail.next = element;
            tail = element;
        }
    }

    public void addFirst(T element) {
        addFirst(new node<>(element, head, tail));
        size++;
    }

    private void addFirst(node<T> element) {
        if (size == 0) {
            head = tail = element;
        } else {
            tail.next = element;
            head.prev = element;
            head = element;
        }
    }

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

    public void remove(T element) {
        removeAt(indexOf(element));
    }

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

    public void removeFirst() {
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
    }

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

    public T peekFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("no elements to peek");
        }
        return head.data;
    }

    public T peekLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("no elements to peek");
        }
        return tail.data;
    }

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
