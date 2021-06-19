import java.util.Arrays;

public class QuickSort {
    public QuickSort(int[] array) {
        quickSort(array);
    }

    public void quickSort(int[] array) {
        if(array.length==1){
            return;
        }
        int pivot = array.length / 2;
        System.out.println("pivot is : " +pivot);
        int[] right = new int[(array.length / 2) - 1];
        System.out.println("right length is :"+right.length);
        int[] left = new int[(array.length - right.length -1)];
        System.out.println("left length is :"+left.length);
        partition(right,left,array,pivot);
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));
        quickSort(right);
        quickSort(left);
        System.out.println(Arrays.toString(array));

    }

    public void partition(int[] right, int[] left, int[] array, int pivot) {
        int right_place = 0;
        int left_place = 0;
        for (int j : array) {
            if (j < pivot && right_place< right.length) {
                right[right_place++] = j;
                System.out.println(Arrays.toString(right));
            }
            if (j >= pivot && left_place<left.length) {
                left[left_place++] = j;
                System.out.println(Arrays.toString(left));
            }
        }
    }
}
