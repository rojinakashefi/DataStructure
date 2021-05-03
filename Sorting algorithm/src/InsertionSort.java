/**
 * InsertionSort
 * it sorts elements by comparisons with sorted sublist
 * At first we know our sorted sublist one element
 * and we know one element is always sorted
 * we will continue till the sorted sublist size is equal to the array we are sorting
 * @author rojina kashefi
 * @since April 2021
 */
public class InsertionSort{
    int [] array;
    public InsertionSort(int []array){
        this.array=array;
        insertionSort();
        // insertion_sort();
    }

    /**
     * this insertion sort is implemented by two for
     * finally when we find the new correct place of element we swap it
     */
    public void insertionSort(){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(array[j]<array[j-1]){
                    swap(j,j-1);
                }
                else
                    break;
            }
        }
    }

    /**
     * another implementations of insertion sort
     */
    public void insertion_sort(){
        for(int i=1;i<array.length;i++) {
            int cur_value = array[i];
            int j = i - 1;
            while( j >= 0 && array[ j] >cur_value) {
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j+1]=cur_value;
        }
    }
    public void swap(int first,int second){
        int temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}