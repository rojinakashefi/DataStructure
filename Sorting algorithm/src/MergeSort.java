import java.util.Arrays;

/**
 * Merge sort
 * in this sort we use divide and conquer method
 * first we split the first half array till it reaches 1 length
 * then we split the second half array till it reaches 1 length
 * and then using merge method we start sorting them and put them in correct place at the array
 * @author rojina
 * @since April 2021
 *
 */
public  class MergeSort {
    int []array;
    public MergeSort(int []array){
        this.array=array;
        mergeSort(array);
    }

    /**
     * recursion call of merger sort
     * @param array we are dividing
     */
    public void mergeSort(int []array){
        if(array.length==1){
            return;
        }
        //each time the length of array we call is different
        System.out.println("list of array: "+Arrays.toString(array));
        //the way to calculate mid index
        int midindex=array.length/2+array.length%2;
        int []first=new int[midindex];
        int []second=new int[array.length-midindex];
        //we make 2 arrays which are stored in memory
        //we write their elements using split method
        split(array,first,second);
        //then we call merge sort for first array and then split it
        //we will go to second array until k first one its length is 1
        mergeSort(first);
        mergeSort(second);
        //merging them means to put them in write position in their array length
        merge(array,first,second);

    }

    /**
     * when we divide an array we should put the values of array in new arrays
     * @param array we are dividing
     * @param first as first part of array we have divided
     * @param second as second part of array we have divided
     */
    //assigning arrays value two both new arrays
    public void split(int []array,int []first,int []second){
        for(int i=0;i<array.length;i++){
            if(i<first.length){
                first[i]=array[i];
            }
            else {
                second[i- first.length]=array[i];
            }
        }
    }

    /**
     * after dividing and splitting we should merge two first and second array and put them in sorted form
     * @param array as the array which has been divided
     * @param first as first part of divided array
     * @param second as the second part of divided array
     */
    public void merge(int []array,int []first,int[]second){
        //we need 2 pointers one for first half and one for second half
        //because they move differently
        int pointer1=0;
        int pointer2=0;
        //pointer for array
        int pointerA=0;
        while (pointer1<first.length && pointer2<second.length){
            //we check which one is smaller
            //whoever is smaller goes and sit in the array
            //its pointer move further
            if(first[pointer1]<second[pointer2]){
                array[pointerA]=first[pointer1];
                pointer1++;
            }
            else{
                array[pointerA]=second[pointer2];
                pointer2++;
            }
            pointerA++;
        }
        //if one pointer reached end of it list but the another one pointer hasn't
        //it means the elements which are left are bigger than others so we add them to list
        //append them in the end
        if(pointer1<first.length){
           while (pointer1<first.length){
               array[pointerA++]=first[pointer1++];
           }
        }
        else if(pointer2<second.length){
            while (pointer2<second.length){
                array[pointerA++]=second[pointer2++];
            }
        }
    }
}