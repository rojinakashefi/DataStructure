import java.util.Arrays;

public class BubbleSort {
    int [] array;
    public BubbleSort(int[]array){
        this.array=array;
        bubbleSort();
    }
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
            //if all elements are sorted
            if(!swap){
                break;
            }
        }
    }
    public void swap(int i,int j){
        int temp=0;
        temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }
}