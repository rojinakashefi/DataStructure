import java.util.Arrays;

/**
 * Bubble Sort
 * it sorts each element by their neighbours value
 * In first round the biggest element of array is sorted in last element of array
 * and others same
 * If their all sorted and there is no swaps it means list is sorted and we can break iteration
 * @author rojina
 * @since April 2021
 */
public class BubbleSort {
    int [] array;
    public BubbleSort(int[]array){
        this.array=array;
        bubbleSort();
    }

    /**
     * Sorted an array
     */
    public void bubbleSort(){
        for(int i=0;i<array.length;i++){
            boolean swap=false;
            //array.lenght-(k+1)to dont check last elements
            //they are in correct place after the first round is finished
            for (int j = 0; j < array.length -(i+1); j++) {
                if (array[j+1] < array[j]) {
                    swap=true;
                    swap(j, j+1);
                }
            }
            // if there is no swaps it means the list is in sorted form
            // if all elements are sorted
            if(!swap){
                break;
            }
        }
    }

    /**
     * swaps two elements
     * @param i as first value
     * @param j as second value
     */
    public void swap(int i,int j){
        int temp=0;
        temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }
}