import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
      //int []array={2,3,0};
        int [] array={10,9,8,7,6,5,4,3,2,1,0};
        //int [] array={0,1,2,3,4,5,6,7,8,9,10};
        /*SelectionSort selectionSort=new SelectionSort(array);
        System.out.println("Selection Sort: ");
        System.out.println(Arrays.toString(array));

        BubbleSort bubbleSort=new BubbleSort(array);
        System.out.println(Arrays.toString(array));

        InsertionSort insertionSort=new InsertionSort(array);
        System.out.println(Arrays.toString(array));
        MergeSort mergeSort=new MergeSort(array);
        BogoSort bogoSort=new BogoSort(array);
         */
        QuickSort quickSort=new QuickSort(array);

    }
}
