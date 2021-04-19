import java.util.Arrays;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {
    private T[] array;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(2);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("you cant declare capacity 0");
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void add(T element) {
        if (capacity == 0) {
            capacity = 1;
        } else if (len >= capacity) {
            capacity *= 2;
            T[] new_array = (T[]) new Object[capacity];
            if (len >= 0) System.arraycopy(array, 0, new_array, 0, len);
            array = new_array;
        }
        array[len++] = element;
    }

    public void remove(T element) {
        T[] new_array = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (array[i] == element) {
                j--;
            } else {
                new_array[j] = array[i];
            }
        }
        array = new_array;
        capacity = --len;

    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T getIndex(int index) {
        if (index >= len || index <= 0) {
            throw new IndexOutOfBoundsException("illegal index");
        }
        return array[index];
    }

    public void setIndex(int index, T element) {
        array[index] = element;
    }

    public void clear() {
        Arrays.fill(array, null);
        len = 0;
    }

    public int indexOf(T element) {
        for (int i = 0; i < len; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean containOf(T element) {
        return indexOf(element) != -1;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
