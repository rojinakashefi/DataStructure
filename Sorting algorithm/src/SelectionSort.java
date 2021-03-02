public class SelectionSort {
    int [] array;
    public SelectionSort(int [] array){
        this.array=array;
        selectionSort();
    }
    public void selectionSort(){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                   swap(i,j);
                }
            }
        }
    }
    public void swap(int i,int j){
        int temp;
        temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }

}
