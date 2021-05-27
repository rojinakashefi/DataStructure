import java.util.Arrays;

/**
 * we want to find k'th smallest element in list in O(n)
 * we know we can sort list by merge sort or quick sort and get the k'th element in O(nlogn)
 * if k==1 and k==n then we will have output in O(n) -->(one for)
 * if we partition our code around middle index we will have T(n) = T(n/2)+c
 * but for this we need a middle index which it means select (n,n/2)
 * so we cant find the middle index
 * but we can find middle of middle index and that is close to middle index
 * get pivot --> T(n/5)
 *
 */
public class KthSmallestElement {

    int[] first_array;
    int k_of_whole;

    /**
     * constructor
     * @param first_array as array we are finding the K'th smallest element
     * @param k_of_whole as k'th element we are looking for
     */
    public KthSmallestElement(int[] first_array, int k_of_whole) {
        this.k_of_whole = k_of_whole;
        this.first_array = first_array;
        System.out.println("K'th smallest element of arrays is : "+kElement(first_array, k_of_whole));
    }

    /**
     * @param array as array we are searching in
     * @param k as k'th element
     * @return the k'th element we are looking for
     */
    public int kElement(int[] array, int k) {
        //O(n) for k==1 and k==length of array
        //smallest element in array
        if (k == 1) {
            int result = array[0];
            for (int j = 0; j < array.length; j++) {
                if (array[j] < result) {
                    result = array[j];
                }
            }
            return result;
        }
        //biggest element in array
        else if (k == array.length) {
            int result = array[0];
            for (int j=0;j<array.length;j++){
                if(array[j]>result){
                    result=array[j];
                }
            }
            return result;
        }
        //if our array has only one element
        else if (array.length == 1) {
            if (k > 1) {
                System.out.println("k is bigger than size of array");
                return -1;
            }
            return array[0];
        }
        else {
            return findKth(array, k);
        }
    }

    /**
     * first we should get the best pivot ->T(n/5)
     * then we should partition around pivot and make left and right arrays
     * 3n/10-6<len(left_Array)<7n/10+5 -> worst case T(7n/10)
     * 3n/10-6<len(right_Array)<7n/10+5 -> worst case T(7n/10)
     * T(n) <= T(n/5) + T(7n/10) + O(n)
     * @param array as array we are trying to find k'th element
     * @param k as k'th element we are looking for
     * @return the element we are looking for
     */
    public int findKth(int[] array, int k) {
        int pivot = getPivot(array);
        int[] left_array = arrayLeft(array, pivot);
        int[] right_array = arrayRight(array, pivot);
        if (left_array.length - 1 == k - 1) {
            return pivot;
        } else if (left_array.length - 1 > k - 1) {
            return findKth(left_array, k);
        } else {
            return findKth(right_array, k - left_array.length - 2);
        }

    }

    /**
     * getting medians of medians
     * @param array
     * @return pivot we are looking for
     */
    public int getPivot(int[] array) {
        int length;
        //if the array is 5 find the third smallest one
        if (array.length == 5) {
            return foundThirdSmallest(array);
        }
        else if(array.length<5){
            // our list contains only positive ints
            if(array.length==2){
                System.out.println(Arrays.toString(array));
                if(array[0]==0){
                    return array[1];
                }
                else if(array[1]==0){
                    return array[0];
                }
                else if(array[1]>array[0] && k_of_whole==2){
                    return array[1];
                }
                else if(array[1]<array[0] && k_of_whole==1){
                    return array[1];
                }
                else if(array[0]>array[1] && k_of_whole==2){
                    return array[0];
                }
                else if(array[0]<array[1] && k_of_whole==1){
                    return array[0];
                }
                else if(k_of_whole>2){
                    System.out.println("k unavailable");
                    return -1;
                }
            }
            if(array.length==1){
                return kElement(array,k_of_whole);
            }
          return foundThirdSmallest(array);
        }
        else if (array.length % 5 != 0) {
            length = (array.length / 5) + 1;
        } else {
            length = array.length / 5;
        }
        int[] medians = new int[length];
        for (int i = 0, temp = 0; i < array.length && temp < length; i += 5, temp++) {
            int[] array1 = new int[5];
            for (int j = i, p = 0; j < i + 5 && j < array.length; j++, p++) {
                array1[p] = array[j];
            }
            medians[temp] = foundThirdSmallest(array1);
        }
        return getPivot(medians);
    }

    /**
     * third smallest founder
     * @param array as we are finding third smallest element
     * @return the third smallest
     */
    public int foundThirdSmallest(int[] array) {
        int minSoFar = Integer.max(-100000, 100000);
        int secondMin = Integer.max(-100000, 100000);
        int thirdMin = Integer.max(-100000, 100000);
        for (int j : array) {
            if (j <= minSoFar) {
                thirdMin = secondMin;
                secondMin = minSoFar;
                minSoFar = j;
            }
            else if (j > minSoFar && j < secondMin) {
                thirdMin = secondMin;
                secondMin = j;
            }
            else if (j > minSoFar && j > secondMin && j < thirdMin) {
                thirdMin = j;
            }
        }
        return thirdMin;
    }

    /**
     * we use this method for partitioning around pivot
     * @param array as array we are partitioning it
     * @param pivot as pivot we are partitioning around it
     * @return right array of pivot
     */
    public int[] arrayRight(int[] array, int pivot) {
        System.out.println(pivot);
        if(array.length-2-k_of_whole>0) {
            int[] right = new int[array.length - 2 - k_of_whole];
            int j = 0;
            for (int k : array) {
                if (k > pivot && j < array.length - 2 - k_of_whole) {
                    right[j] = k;
                    j++;
                }
            }
            return right;
        }
        return null;
    }

    /**
     * we use this method for partitioning around pivot
     * @param array as array we are partitioning it
     * @param pivot as pivot we are partitioning around it
     * @return left array of pivot
     */
    public int[] arrayLeft(int[] array, int pivot) {
        int[] left = new int[k_of_whole];
        int j = 0;
        for (int k : array) {
            if (k < pivot && j <k_of_whole) {
                left[j] = k;
                j++;
            }
        }
        return left;
    }

    /**
     * set array we are doing operations in
     * @param array as array we are looking in
     */
    public void setFirst_array(int [] array){
        this.first_array=array;
        System.out.println("K'th smallest element of arrays is : "+kElement(array,k_of_whole));
    }

    /**
     * set what element we want
     * @param k as k'th element we are looking for
     */
    public void setK_of_whole(int k){
        this.k_of_whole=k;
        System.out.println("K'th smallest element of arrays is : "+kElement(first_array,k));
    }

    /**
     * set both array and k
     * @param array as array we are looking in
     * @param k as k'th element we are looking for
     */
    public void set(int []array,int k){
        this.first_array=array;
        this.k_of_whole=k;
        System.out.println("K'th smallest element of arrays is : "+kElement(array,k));
    }
}
