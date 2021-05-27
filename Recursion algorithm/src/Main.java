import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int []array={10,9,3,2,4,5,1};
//        KthSmallestElement kthSmallestElement=new KthSmallestElement(array,1);
//        System.out.println(kthSmallestElement.kElement());
//        HanoiTower hanoiTower=new HanoiTower(3);
//        int []array={1,2,3,5,6,7,8};
//        BinarySearch binarySearch=new BinarySearch(array,2);
        int[] array = {1, 14, 4, 18, 25, 6, 17, 9, 3, 5, 10, 16, 12, 23, 19, 13, 20, 8, 15, 24, 7, 21, 22, 2, 11};
        System.out.println(Arrays.toString(array));
        System.out.println("K is equal to size of array: (the biggest element): ");
        KthSmallestElement smallestElement = new KthSmallestElement(array, 25);
        System.out.println("============================================");
        System.out.println("K is equal to one (the smallest element) :");
        smallestElement.setK_of_whole(1);
        System.out.println("============================================");
        System.out.println("K equals to n/2 :");
        smallestElement.setK_of_whole(12);
        System.out.println("============================================");
        System.out.println("When array size cant be divided to 5:(still bigger than 5) ");
        int [] array2={9,3,10,4,6,7};
        System.out.println(Arrays.toString(array2));
        System.out.println("K is equal to size of array: (the biggest element): ");
        smallestElement.set(array2,6);
        System.out.println("============================================");
        System.out.println("K is equal to one (the smallest element) :");
        smallestElement.setK_of_whole(1);
        System.out.println("============================================");
        System.out.println("K equals to n/2 :");
        smallestElement.set(array2,3);
        System.out.println("============================================");
        System.out.println("When array size cant be divided to 5:(smaller than 5) ");
        int [] array3={4,6,8};
        System.out.println(Arrays.toString(array3));
        System.out.println("K is equal to size of array: (the biggest element): ");
        smallestElement.set(array3,3);
        System.out.println("============================================");
        System.out.println("K is equal to one (the smallest element) :");
        smallestElement.setK_of_whole(1);
        System.out.println("============================================");
        System.out.println("K equals to n/2 :");
        smallestElement.set(array3,2);
        System.out.println("============================================");

    }
}