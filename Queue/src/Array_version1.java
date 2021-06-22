import java.util.Iterator;

/**
 * Implemented queue using array
 * Enqueue = adding element at last -> if size is smaller than array length -> O(1)
 * if size of elements if queue is getting bigger we should increase size of array -> O(n)
 * deQueue -> removing element and move all element one forward -> O(n)
 * peek -> return array[0] -> O(1)
 * getSize -> O(1)
 * isEmpty -> O(n)
 * print -> O(N)
 *
 * @param <T>
 */
public class Array_version1<T> implements Iterable<T> {
    T[] array;
    int size = 0;

    public Array_version1() {
        //fist initialization of array
        array = (T[]) new Object[4];
        size = 0;
    }

    public Array_version1(T value) {

        array[size] = value;
        size++;
    }

    /**
     * adding element at last
     *
     * @param value as value we want to add
     */
    public void Enqueue(T value) {
        //if there is no place for adding we should increase it
        if (size >= array.length) {
            T[] new_array = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                new_array[i] = array[i];
            }
            array = new_array;
        }
        array[size++] = value;
        print();
    }

    /**
     * removing first element
     *
     * @return returning the value of element we are removing
     */
    public T deQueue() {
        T temp = array[0];
        T[] new_array;
        size--;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("size is zero");
        }
        //reduce size if only 1/4 of array is full
        if (size < array.length / 4) {
            new_array = (T[]) new Object[array.length / 2];
        } else {
            new_array = (T[]) new Object[array.length];
        }
        //moving all elements in one position lower
        for (int i = 1, j = 0; i < new_array.length; i++, j++) {
            new_array[j] = array[i];
        }
        array = new_array;
        print();
        return temp;
    }

    /**
     * @return fist element of array
     */

    public T peek() {
        return array[0];
    }

    /**
     * get size of array
     * @return size of array
     */
    public int getSize() {
        return size;
    }

    /**
     * check if it is empty or not
     * @return true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * printing elements
     */
    public void print() {
        for (T element : array) {
            System.out.println(element);
        }
        System.out.println("======================");
    }

    /**
     * @return an iterator
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
}
