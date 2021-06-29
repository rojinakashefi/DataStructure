public class Main {

    public static void main(String[] args) {
        Integer[] element = {10, 2,3,3, 4, 5, 6,0,1};
        PriorityQueue<Integer> pq = new PriorityQueue<>(element);
        pq.print();
        System.out.println("adding 0 :");
        pq.add(0);
        pq.print();
        System.out.println("remove last element :");
        pq.removeAt(element.length);
        pq.print();
        System.out.println("remove element with index 1 :");
        pq.removeAt(1);
        pq.print();
        System.out.println("remove element with value 3 :");
        pq.remove(3);
        pq.print();
        System.out.println("check if our heap contain 10 : " + pq.contains(10));
        System.out.println("==============================");
        System.out.println("poll element :");
        pq.poll();
        pq.print();
        System.out.println("peeking : " + pq.peek());
        System.out.println("==============================");
        System.out.println("check if it is min heap : " + pq.isMinHeap(0));
        System.out.println("==============================");
        System.out.println("check if it is max heap : " + pq.isMaxHeap());
    }
}
