import java.util.*;
/**
 * Implementing Min priority queue using heap
 * priority queue is a data structure which can be implemented with array or linkedlist
 * but for time complexity we use heaps
 * @param <T> as elements which must be comparable
 */
public class PriorityQueue<T extends Comparable<T>> {
    //how many elements are in heap
    private int heapSize = 0;
    //how many elements can be in heap
    private int heapCapacity = 0;
    //heap is an array which has a specific order for it kids
    private List<T> heap = null;
    //you can use hashset or tree set
    //tree set order them in sorted form ,add and removal and contains would take O(logn)
    //but in hashset they arent in sorted form, add and removal and contains would take O(1)
    private Map<T, HashSet<Integer>> map = new HashMap<>();

    //creating a heap with size of 1
    public PriorityQueue() {
        this(1);
    }

    public PriorityQueue(int cap) {
        heap = new ArrayList<>(cap);
        heapSize = heapCapacity = cap;
    }

    //you change the input array to heap using heapify
    public PriorityQueue(T[] elements) {
        heapSize = heapCapacity = elements.length;
        heap = new ArrayList<>(heapCapacity);
        for (int i = 0; i < heapSize; i++) {
            heap.add(elements[i]);
            MapAdd(elements[i], i);
        }
        //heapify method makes us to make our heap invariant
        heapify();
    }

    // you initialize your heap empty
    //adding element to it using bubbling up
    //it took O(n*log(n))
    public PriorityQueue(Collection<T> elements) {
        this(elements.size());
        for (T temp : elements) {
            add(temp);
        }
    }

    // Perform bottom up node swim, O(log(n))
    public void add(T element) {
        //adding our element first in our list
        //them swim it up
        if (element == null) {
            throw new NullPointerException();
        }
        heap.add(element);
        MapAdd(element, size() - 1);
        swim(size() - 1);
    }
    //for swimming we should check its parent
    //if the index we are looking is smaller than its parent
    //as we are implementing min heap
    //we should swap them
    //keep checking till we reach root
    public void swim(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && less(heap.get(index), heap.get(parent))) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;

        }
    }
    //each element we add we must update our map
    public void MapAdd(T value, int index) {
        if (map.get(value) == null) {
            HashSet<Integer> set = new HashSet<>();
            set.add(index);
            map.put(value, set);
        } else {
            map.get(value).add(index);
        }
    }
    //heap sort
    //it takes o(n)
    public void heapify() {
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            //in sink method we bubble down
            sink(i);
        }

    }
    //getSize of heap
    public int size() {
        return heap.size();
    }

    //it takes o(log(n)) (height of our heap)
    //bubbling down
    public void sink(int k) {
        heapSize = size();
        while (true) {
            int right = 2 * k + 2;
            int left = 2 * k + 1;
            int smallest = left; // Assume left is the smallest node of the two children
            // Find which is smaller left or right
            // If right is smaller set smallest to be right
            if (right < heapSize && less(heap.get(right), heap.get(left))) {
                smallest = right;
            }
            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= heapSize || less(heap.get(k), heap.get(smallest))) {
                break;
            }
            swap(smallest, k);
            k = smallest;

        }
    }
    //for swapping we need to swap both in our heap(list)  and in our map
    public void swap(int first, int second) {
        T first_node = heap.get(first);
        T second_node = heap.get(second);
        heap.set(first, second_node);
        heap.set(second, first_node);
        //swapping in map
        mapSwap(first_node, second_node, first, second);
    }
    //for map swap we should remove their indexes from the set and then add the indexes to another value indexes O(1)
    public void mapSwap(T first_node, T second_node, int first, int second) {
        map.get(first_node).remove(first);
        map.get(second_node).remove(second);
        map.get(first_node).add(second);
        map.get(second_node).add(first);
    }
    //compare which one is smaller O(1)
    public boolean less(T first, T second) {
        return first.compareTo(second) <= 0;
    }
    //check if it is empty or not O(1)
    public boolean isEmpty() {
        return size() == 0;
    }
    //clear both heap and map O(n)
    public void clear() {
        heap.clear();
        map.clear();
    }
    //get root element
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return heap.get(0);
    }
    //removing and getting first element
    public T poll() {
        return removeAt(0);
    }
    //remove an element from a special position
    public T removeAt(int index) {
        T removed;
        if (isEmpty()) {
            return null;
        }
        //save the item we want to remove
        removed = heap.get(index);
        //if it wasn't the last item
        //we need to swap it with the last item
        //and check the new element in that index needs to bubble up or buuble down
        //after that remove the last item
        if ((index != size() - 1)) {
            swap(size() - 1, index);
            T elem = heap.get(index);
            //o(log(n))
            sink(index);
            if (heap.get(index).equals(elem)) {
                //o(log(n))
                swim(index);
            }
        }
        mapRemove(removed, size() - 1);
        heap.remove(size() - 1);
        return removed;

    }
    //remove a value from our list O(logn)
    public void remove(T element) {
        //search our element in our map
        //remove it from our map
        //o(1)
        HashSet<Integer> set = map.get(element);

        // Linear removal via search, O(n)
        //  for (int i = 0; i < heapSize; i++) {
        //   if (element.equals(heap.get(i))) {
        //     removeAt(i);
        //     return true;
        //   }
        // }

        if (set != null) {
            int index = map.get(element).stream().findFirst().get();
            removeAt(index);
        } else
            throw new NullPointerException("Set is null");

    }
    //remove an element from map
    public void mapRemove(T element, int index) {
        map.get(element).remove(index);
        if (map.get(element).size() == 0) {
            map.remove(element);
        }
    }

    // Test if an element is in heap, O(1)
    public boolean contains(T elem) {

        // Map lookup to check containment, O(1)
        if (elem == null) return false;
        return map.containsKey(elem);

        // Linear scan to check containment, O(n)
        // for(int i = 0; i < heapSize; i++)
        //   if (heap.get(i).equals(elem))
        //     return true;
        // return false;

    }
    //check if our heap is minheap or max heap
    //give k=0 to bubble down from root
    public boolean isMinHeap(int k) {
        int heapSize = size();
        //if we have reached last of our heap before finishing our heap
        if (k >= heapSize) return true;
        int left = 2 * k + 1;
        int right = 2 * k + 2;
        //each time check if we haven't reached out of bounds
        //both of conditions must be true to return false
        //if parent isn't smaller than left child then it isn't min heap
        if (left < heapSize && !less(heap.get(k), heap.get(left))) return false;
        if (right < heapSize && !less(heap.get(k), heap.get(right))) return false;
        // Recurse on both children to make sure they're also valid heaps
        return isMinHeap(left) && isMinHeap(right);
    }
    //if it isn't min heap is max heap
    public boolean isMaxHeap() {
        return !isMinHeap(0);
    }

    public void print() {
        if(size()==0){
            System.out.println("heap is empty");
            return;
        }
        System.out.println(heap);
        System.out.println(map);
        System.out.println("===============================");
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
