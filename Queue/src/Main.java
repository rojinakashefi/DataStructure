public class Main {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED+"Implementing dequeue using doubly linked list"+ANSI_RESET);
		DLQueue<Integer> dlQueue = new DLQueue<>();
		dlQueue.EnQueue(1);
		dlQueue.EnQueue(2);
		dlQueue.EnQueue(3);
		dlQueue.EnQueue(4);
		System.out.println("value which has been removed is :" +dlQueue.DeQueue());
		System.out.println("value which has been peeked is :" +dlQueue.peek());
        System.out.println(ANSI_RED+"=========================================="+ANSI_RESET);
        System.out.println(ANSI_RED+"Implementing dequeue using single linked list"+ANSI_RESET);
        SLQueue<Integer> slQueue = new SLQueue<>();
        slQueue.Enqueue(1);
        slQueue.Enqueue(2);
        slQueue.Enqueue(3);
        slQueue.Enqueue(4);
        System.out.println("value which has been dequeued is :" + slQueue.deQueue());
        System.out.println("value which has been peeked : " + slQueue.peek());
        System.out.println(ANSI_RED+"=========================================="+ANSI_RESET);
        System.out.println(ANSI_RED+"Implementing dequeue using array version 1 "+ANSI_RESET);
        Array_version1<Integer> array_1 = new Array_version1();
        array_1.Enqueue(1);
        array_1.Enqueue(2);
        array_1.Enqueue(3);
        array_1.Enqueue(4);
        array_1.Enqueue(5);
        System.out.println("element which has been remove is :"+ array_1.deQueue());
        System.out.println("element which has been remove is :"+ array_1.deQueue());
        System.out.println("element which has been remove is :"+ array_1.deQueue());
        System.out.println("element which has been remove is :"+ array_1.deQueue());
        System.out.println("element which we peeked is :" +array_1.peek());
    }

}
