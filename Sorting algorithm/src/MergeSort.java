import java.util.Arrays;

public  class MergeSort {
    int []array;
    public MergeSort(int []array){
        this.array=array;
        mergeSort(array);
    }
    public void mergeSort(int []array){
        if(array.length==1){
            return;
        }
        //each time the lenght of array we call is diffrent
        System.out.println("list of array: "+Arrays.toString(array));
        //the way to calculate mid index
        int midindex=array.length/2+array.length%2;
        int []first=new int[midindex];
        int []second=new int[array.length-midindex];
        //we make 2 arrays which are stored in memory
        //we write their elemnts using split method
        split(array,first,second);
        System.out.println("first: "+Arrays.toString(first));
        System.out.println("second: "+Arrays.toString(second));
        //then we call merge sort for first array and then split it
        //we will go to second array until k first one its length is 1
        mergeSort(first);
        mergeSort(second);
        //merging them means to put them in write position in their array length
        merge(array,first,second);
        System.out.println("merged array: "+Arrays.toString(array));

    }
    //meghdar haye arrayaro vaghti darim khord mikonim hefz mikone
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
    public void merge(int []array,int []first,int[]second){
        //we need 2 pointers one for first half and one for second half
        //because they move differently
        int pointer1=0;
        int pointer2=0;
        int pointerA=0;
        while (pointer1<first.length && pointer2<second.length){
            //we check which one is smaller
            //harkudum kuchik tar bod va gozashtimesh sare jash pointersh mire jolo chon jaye onsore kochikesh moskhas shode
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
        //age yeki az pointera tamum shod vali pointer on yeki hanooz tamum nashode
        //yani inke baghiye anasori k mondan akhar michasban va bozorgtar az hame anasor dovomina
        //michasbonimeshon be tah
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