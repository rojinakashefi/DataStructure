import java.util.Arrays;

public class ShellSort {

    int [] array;
    int increment;
    InsertionSort insertionSort;

    public ShellSort(int []array,int increment){
        this.increment=increment;
        this.array=array;
        shellSort();
    }
    public void shellSort(){
        for(int i=0;i<increment;i++){
            insertionSort(i);
        }
        //after the sublisted has been sorted
        //we have a nearly sorted list
        //we sort it as an normal insertionsort
        insertionSort=new InsertionSort(array);
    }
    public void insertionSort(int start){
        for(int i=start;i<array.length;i=i+increment){
            if(i+increment<array.length) {
                for (int j = i + increment; j > 0; j = j - increment) {
                    if(j-increment>=0) {
                        if (array[j] < array[j - increment]) {
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
    public void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
