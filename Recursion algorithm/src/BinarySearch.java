/**
 * Binary search
 * This method is used for searching an element in a list of array
 * We choose a pivot index and compare it each time with the element we are searching for
 * We put away each time half of array,so the length of array will be half each time
 * Its a recursion algorithm -->T(n) = T(n/2) + c
 * It took O(logN)
 * @link #binarySearch(int[], int,int)
 * <b>Remember the array must be sorted in binary search</b>
 */
public class BinarySearch {
    int[] array ;
    int element;
    /**
     * Binary search constructor
     * @param array as the array we are searching in
     * @param element as the element we are looking for it index
     */
    public BinarySearch(int[] array,int element){
        this.array=array;
        this.element=element;
        binarySearch(array,0,array.length-1);
    }

    /**
     * Implementation of binary search
     * @param array as the array we are searching in
     * @param start the start of array
     * @param end the end of array
     */
    public void binarySearch(int []array,int start,int end){
        if(end>=1) {
            int pivot_index = start+((end - start) / 2);
            if (element == array[pivot_index]) {
                System.out.println(pivot_index);
                return;
            }
            if (element < array[pivot_index]) {
                 binarySearch(array, start, pivot_index-1);
                 return;
            }
                 binarySearch(array, pivot_index + 1, end);
        }
        else {
            System.out.println("Not found such an element");
        }
    }
}
