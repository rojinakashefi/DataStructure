import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
    private T[] array;
    private int len = 0;
    private int capacity = 0;
    //a constructor for making dynamic array if the user dont give size
    public DynamicArray() {
        this(2);
    }
    //a constructor for making dynamic array if the user give size
    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("you cant declare capacity 0");
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }
    //adding element to out array
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
    //removing element copying the previous array to another array with size og len-1
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
    //return size of array
    public int size() {
        return len;
    }
    //check if out array is empty or not
    public boolean isEmpty() {
        return size() == 0;
    }
    //getting a specific index
    public T getIndex(int index) {
        if (index >= len || index <= 0) {
            throw new IndexOutOfBoundsException("illegal index");
        }
        return array[index];
    }
    //as we know we can change arrays value by knowing their index number
    public void setIndex(int index, T element) {
        array[index] = element;
    }
    //clearing all array
    public void clear() {
        Arrays.fill(array, null);
        len = 0;
    }
    //returning the index number of specific element
    public int indexOf(T element) {
        for (int i = 0; i < len; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    //check if an array contains of a specific element
    public boolean containOf(T element) {
        return indexOf(element) != -1;
    }
    //print array
    public void print() {
        System.out.println(Arrays.toString(array));
    }
    //making iterator for our array
    //we change the by default iterator by overriding its methods
    //it is used in for each
    //we can iterate our array in our way
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index=0;
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
    //to convert an array to string
    @Override
    public String toString() {
       if(len==0){
           return "[]";
       }
       StringBuilder stringBuilder= new StringBuilder();
       stringBuilder.append('[');
       for(int i=0;i<len-1;i++){
           stringBuilder.append(array[i]).append(",");
       }
       stringBuilder.append(array[len - 1]).append("]");
       return stringBuilder.toString();
    }
}
