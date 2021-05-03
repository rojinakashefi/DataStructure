import java.util.Arrays;

/**
 * Shell sort
 * in this sort we use insertion sort
 * we don't use insertion sort from right and increase the sub array
 * we choose a sub array based on our increment and sorting them
 * and slowly increase of increment
 * @author rojina
 * @since April 2021
 */
public class ShellSort {

    int [] array;
    int increment;

    public ShellSort(int []array,int increment){
        this.increment=increment;
        this.array=array;
        shellSort();
    }

    /**
     * creating our sub arrays based on our increment
     * and calling insertion sort on our sub array
     */
    public void shellSort(){
        while(increment>=1) {
            //first it loops by increment
            //when finished we reduce our increment
            //in increment=1 is insertion sort
            for (int i = 0; i < increment; i++) {
                insertionSort(i);
            }
            increment=increment/2;
        }
    }

    /**
     * sorting based on increment
     * @param start of sub array we are going to sort
     */
    public void insertionSort(int start){
        for(int i=start;i<array.length;i=i+increment){
            if(i+increment<array.length) {
                for (int j = i + increment; j > 0; j = j - increment) {
                    if(j-increment>=0) {
                        if (array[j] < array[j - increment]) {
                            System.out.println(array[j]);
                            System.out.println(array[j-increment]);
                            swap(j, j - increment);
                        } else {
                            break;
                        }
                    }
                }
            }
            else {
                break;
            }
        }
    }

    /**
     * swapping elements
     * @param i as the first index of array we are going to swap
     * @param j as the second index of array we are going to swap
     */
    public void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
