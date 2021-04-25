import java.util.Arrays;
import java.util.Iterator;

/**
 * Dynamic array implementations
 * usage:
 * 1)storing and accessing data
 * 2)used as buffer
 * 3)look up table and inverse lookup values
 * 4)can be used to return multiply values from a funtion
 * 5)used in dynamic programming
 * @param <T>
 * @author Rojina Kashefi
 * @since 2021.2.1
 */
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
    private T[] array;
    private int len = 0;
    private int capacity = 0;

    /**
     * a constructor for making dynamic array if the user didn't give its capacity
     */
    public DynamicArray() {
        this(2);
    }

    /**
     * a constructor for making dynamic array if the user give size
     */
    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("you cant declare capacity 0");
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    /**
     * adding element in last to our array
     * its complexity is o(1)
     * we cant append an element to static arrays
     * @param element as the element we want to add
     */
    public void add(T element) {
        if (capacity == 0) {
            capacity = 1;
        } else if (len >= capacity) {//if the len of array has been equal means we need to make capacity for next add
            capacity *= 2;
            T[] new_array = (T[]) new Object[capacity];//making new array:(a lot of space)
            if (len >= 0) System.arraycopy(array, 0, new_array, 0, len);
            array = new_array;
        }
        array[len++] = element;
    }

    /**
     * insertion of element in a specific index in array
     * its order of time is o(n)
     * we cant do insertion in static array
     * @param element     we want to add
     * @param index_toPut the index we want to add element
     */
    public void insertions(T element, int index_toPut) {
        if (len >= capacity) {
            capacity *= 2;

        }
        T[] new_array = (T[]) new Object[capacity];
        if (index_toPut - 1 + 1 >= 0) System.arraycopy(array, 0, new_array, 0, index_toPut - 1 + 1);
        new_array[index_toPut] = element;
        if (array.length - (index_toPut + 1) >= 0)
            System.arraycopy(array, index_toPut + 1, new_array, index_toPut + 1, array.length - (index_toPut + 1));
        array = new_array;
    }

    /**
     * removing element copying the previous array to another array with size og len-1
     * its complexity is o(n)
     * we cant delete an element in static arrays
     * @param element as the element we want to remove
     */
    public void remove(T element) {
        T[] new_array;
        if (len - 1 == capacity / 4) {
            capacity /= 2;
            new_array = (T[]) new Object[capacity];
        } else {
            new_array = (T[]) new Object[len - 1];
        }
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

    /**
     * getting size of array
     * its order is o(1)
     * @return int as size of the array we know
     */
    public int size() {
        return len;
    }

    /**
     * check if out array is empty or not
     * its order is o(1)
     * @return boolean as the result of if array is empty or not
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * getting a element with the index
     * the order of accessing an element is o(1)
     * in static array accessing an element is o(1)
     * @param index as element with  index number we want to have
     * @return element with the same index
     */
    public T getIndex(int index) {
        if (index >= len || index <= 0) {
            throw new IndexOutOfBoundsException("illegal index");
        }
        return array[index];
    }

    /**
     * as we know we can change arrays value by knowing their index number
     * its order is o(1)
     */

    public void setIndex(int index, T element) {
        array[index] = element;
    }

    /**
     * clearing all array
     * its order is o(n)
     * we should make all elemnts null which it requires a for loop
     */

    public void clear() {
        Arrays.fill(array, null);
        len = 0;
    }

    /**
     * returning the index number of specific element
     * its order is o(1)
     */
    public int indexOf(T element) {
        for (int i = 0; i < len; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * check if an array contains of a specific element
     * its order is o(n)
     * @param element is the element we are looking for
     * @return is we have that element or not
     */
    public boolean containOf(T element) {
        return indexOf(element) != -1;
    }

    /**
     * printing an array
     * its order is o(n)
     */
    public void print() {
        System.out.println(Arrays.toString(array));
    }

    /**
     * making iterator for our array
     * we change the by default iterator by overriding its methods
     * it is used in for each
     * we can iterate our array in our way
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    /**
     * converting out array to string
     * its order is o(n)
     * @return string of our array
     */
    @Override
    public String toString() {
        if (len == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < len - 1; i++) {
            stringBuilder.append(array[i]).append(",");
        }
        stringBuilder.append(array[len - 1]).append("]");
        return stringBuilder.toString();
    }
}
