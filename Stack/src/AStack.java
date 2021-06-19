import java.util.Arrays;

/**
 *Implementing stack using  Array
 * Push -> push an element on top if stack has place -> O(1) -> if not we should increase array size -> O(n)
 * Pop  -> popping top element and remove it from stack -> O(1) -> if there is a lot of unused space in stack ,we should reduce it size-> O(n)
 * Peek -> getting top element -> O(1)
 * getSize -> getting size of stack -> O(1)
 * IsEmpty -> check is stack is empty or not -> O(1)
 * @param <T> as type of values we want to store in stack
 */
public class AStack <T>{
    private T[] array ;
    int size;

    /**
     * Intialize stack
     */
    public AStack(){
        array = (T[]) new Object[4];
        size=0;
    }

    /**
     * Push elements at top of stack
     * @param value as value of element we want to push
     */
    public void push(T value){
        if(size>=array.length){
            T[] new_array=(T[]) new Object[size*2];
            for(int i=0;i<size;i++){
                new_array[i]=array[i];
            }
            array=new_array;
        }
        array[size]=value;
        size++;
    }

    /**
     * popping element from top of stack and remove it from stack
     * @return value of top element
     */
    public T pop(){
        T temp=array[size-1];
        if(size<array.length/4){
            int capacity=array.length/2;
            T[] new_array = (T[]) new Object[capacity];
            for(int i=0;i<capacity;i++){
                new_array[i]=array[i];
            }
            array=new_array;
        }
        array[size-1]=null;
        size--;
        return temp;
    }

    /**
     * getting top element value
     * @return value of top element
     */
    public T peek(){
        if(size>0) {
            return array[size - 1];
        }
        throw new IndexOutOfBoundsException("Array size is 0");
    }

    /**
     * get size of stack
     * @return size of stack
     */
    public int getSize(){
        return size;
    }

    /**
     * check if stack is empty or not
     * @return boolean
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * printing stack -> O(n)
     */
    public void print(){
        for(int i=0;i<size;i++){
            System.out.println(array[i]);
        }
    }

    /**
     * @return stack
     */
    public T[] getArray(){
        return array;
    }

}
