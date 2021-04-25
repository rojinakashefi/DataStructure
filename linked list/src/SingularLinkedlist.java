import java.util.Iterator;

public class SingularLinkedlist<T> implements Iterable<T> {

    int size;
    node<T> head, tail;

    private static class node<T> {
        T data;
        node<T> next;

        public node(T data, node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public SingularLinkedlist() {
        size = 0;
        tail = head = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T data) {
        addLast(new node<>(data, null));
        size++;
    }

    private void addLast(node<T> last) {
        if (size == 0) {
            head = tail = last;
        } else {
            tail.next = last;
            tail = tail.next;
        }
    }

    public void addFirst(T data) {
        addFirst(new node<>(data, head));
        size++;
    }

    private void addFirst(node<T> first) {
        if (size == 0) {
            head = tail = first;
        } else {
            head = first;
        }
    }

    public int indexOf(T element) {
        node<T> tmp = head;
        for (int i = 0; i < size; i++, tmp = tmp.next) {
            if (tmp.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }

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

    public boolean contain(T element) {
        for (node<T> tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.data.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void remove(T element) {
        node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(element)) {
                removeAt(i);
            }
            temp = temp.next;
        }

    }

    public void removeAt(int index) {
        if (index == 0) {
            //removeFirst();
        } else if (index == size - 1) {
            //removeLast
        } else {
            node<T> tmp = head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            size--;
        }

    }

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

    public T peekFirst() {
        if (size != 0) {
            return head.data;
        }
        return null;
    }

    public T peekLast() {
        if (size != 0) {
            return tail.data;
        }
        return null;
    }

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
