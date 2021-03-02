import java.util.Arrays;

public class InsertionSort {
    int [] array;
    public InsertionSort(int [] array){
        this.array=array;
        insertionSort();
    }
    public void insertionSort(){
        for(int i=0;i<array.length-1;i++){
           for(int j=i+1;j>0;j--){
               if(array[j]<array[j-1]){
                   swap(j,j-1);
               }
               else {
                   //for check the last element
                   // if it is smaller than new element we want to add to sublist
                   //we dont make a change and break for not checking the whole sublist
                   //cause we know sublist are always sorted
                   break;
               }
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
