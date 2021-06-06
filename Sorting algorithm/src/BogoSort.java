import java.util.Arrays;

/**
 * Bogo Sort
 * since there in n! possible orderings of A and only one of them is sorted
 * The probability of a being sorted is 1/n!
 * Number of iterations is : n!
 * Time per iteration is O(n)
 * The runtime complexity is :O(n * n!)
 * But if in each shuffle there wont be a sorted form the runtime would be infinity
 */
public class BogoSort {
    int[] a;

    /**
     * Constructor
     * @param a as array we are trying to sort
     */
    public BogoSort(int[] a) {
        this.a = a;
        System.out.println(Arrays.toString(bogoSort()));
    }

    /**
     * we will continue the loop till it is sorted
     * We will shuffle the a by random algorithm
     * @return sorted array
     */
    public int[] bogoSort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            a=shuffle(a);
            System.out.println(Arrays.toString(a));
            for (int i = 0; i < a.length; i++) {
                if (i + 1 < a.length && a[i] > a[i + 1]) {
                    sorted = false;
                    break;
                }
            }
        }
        return a;
    }

    /**
     * This method is the uniqueness of this algorithm over other algorithms
     * @param a as array we are making changes in
     * @return new array after we shuffled its elements
     */
    public int[] shuffle(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //Math.random gives of a number between 0 to 1
            //by multiplying it to a number it gives us a number between 0 to i-1
            swap(i, (int) (Math.random() * i));
        }
        return a;
    }

    /**
     * swapping elements
     * @param i as i'th element we are swapping
     * @param j as j'th element we are swapping
     */
    public void swap(int i, int j) {
        System.out.println(j);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
