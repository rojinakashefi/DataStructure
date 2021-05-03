/**
 * Selection Sort
 * @author rojina
 * @since April 2021
 */
public class SelectionSort {
    int [] array;
    public SelectionSort(int [] array){
        this.array=array;
        selectionSort();
    }

    /**
     * starts sorting element
     * each time chooses element i of array and compare it to all elements
     * if its value isn't in a sorted form we swap the element
     * and start to compare new element in i place to others
     * till we reached last of list and go to i+1 element of array
     */
    public void selectionSort(){
        for(int i=0;i<array.length;i++){
            // j starts from i+1 cause each time i th element are sorted and in their position
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    swap(i,j);
                }
            }
        }
    }

    /**
     * swaps two elements value
     * @param i as first element
     * @param j as second element
     */
    public void swap(int i,int j){
        int temp;
        temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }

}
