import java.util.Arrays;
import java.util.LinkedList;

/**
 * each object we are adding to hash table has key and value and a hash code
 * hash code is built by hash functions (its kinda like a struct with three values"
 * @param <K> as key value of a node
 * @param <V> as value of a node
 */
class node<K,V> {
    K key;
    V value;
    int hashCode;
    public node (K key,V value) {
        this.key = key;
        this.value = value;
        //built in hash code function of java
        this.hashCode = key.hashCode();
    }
    //check it two nodes are equal or not
    private boolean equal(node<K,V> other){
        // if h(x) != h(Y) they are certainly not equal
        if (hashCode != other.hashCode){
            return false;
        }
        return key.equals(other.key);
    }
    @Override
    public String toString() {
        return  key + "=>" + value;
    }
}

/**
 * In these class we implement a table which is an array of linked lists
 * the linked list is made of objects of node
 * and using hash functions we index them in that table
 * @param <K> as type of keys in our linked list
 * @param <V> as type of value in our linked list
 */
public class SeparateChaining<K,V> implements Iterable<K> {
    //out table has a default capacity
    private static final int DEFAULT_capacity = 3;
    // if our table gets full we need to create a new one
    //we created a load factor to say how many data we can load in table
    private static final double DEFAULT_LOAD_VALUE = 0.75;
    //we can change the load factor in our constructor
    private double maxLoadFactor;
    //threshold makes a define size using load factor and capacity to check is full or not
    private int capacity, threshold, size = 0;
    private LinkedList<node<K,V>> []table;

    /**
     * constructors
     * they all call constructor with two arguments
     */
    public SeparateChaining(){
        this(DEFAULT_capacity,DEFAULT_LOAD_VALUE);
    }

    /**
     * constructor which created threshold
     * @param capacity as capacity of our table
     * @param maxLoadFactor as load factor of our table
     * if one of the arguments are empty their value will be the default value
     */
    public SeparateChaining(int capacity,double maxLoadFactor){
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity");
        if (maxLoadFactor <= 0) {
            throw new IllegalArgumentException("Illegal maxLoadFactor");
        }
       this.maxLoadFactor = maxLoadFactor;
        //set the capacity the bigger one
       this.capacity = Math.max(capacity,DEFAULT_capacity);
       this.threshold = (int)(maxLoadFactor*capacity);
       table = new LinkedList[this.capacity];
    }
    public SeparateChaining(int capacity){
        this(capacity,DEFAULT_LOAD_VALUE);
    }
    public SeparateChaining(double DEFAULT_LOAD_VALUE){
        this(DEFAULT_capacity,DEFAULT_LOAD_VALUE);
    }

    /**
     *
     * @return size of hash table
     */
    public int size(){
        return size;
    }

    /**
     * check if it is empty or not
     * @return true if empty
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * get capacity of table (check if resize has been done or not)
     * @return capacity
     */
    public int getCapacity(){
        return  capacity;
    }

    /**
     * hash codes can be negative to
     * plus we use hash codes to index the key in our table
     * so we have to put it in capacity
     * @param key as key we want to get in index in table
     * @return index of key
     */
    private int normalize(K key){
        if (key.hashCode() < 0){
           return  Math.abs(key.hashCode()) % capacity;
        }
        return key.hashCode() % capacity;
    }

    /**
     * search if a key exists or not
     * return value and hashcode
     * @param key as the key we are looking for
     * @return as node with the key we are looking
     */
    private node<K,V> lookup(K key){
        if (key == null){
            return null;
        }
        //get the index of key
        int index = normalize(key);
        //get linked list of the index
        //it there is no node with that index return null
        LinkedList<node<K,V>> list = table[index];
        if (list == null) {
            return null;
        }
        //recurse on linked list element
        //if their hash are the same
        for (node<K,V> element : list){
            if (element.key.equals(key)){
                return element;
            }
        }
        return null;
    }

    /**
     * see if the key exists or not
     * @param key as key looking for
     * @return true if exists
     */
    public boolean has_key(K key){
        return lookup(key)!=null;
    }

    /**
     * get value of a key
     * @param key as key we want its value
     * @return it value
     */
    public V get_value(K key){
        node <K,V> element = lookup(key);
        if (element!=null){
            return element.value;
        }
        else{
            throw new NullPointerException("No value with given key");
        }
    }

    /**
     * adding an element to table
     * get the key hashcode and see its index
     * 1) the index location is empty -> create a linkedlist -> add new
     * 2) the index location isn't empty -> no key with same value -> add to end of list
     * 3) the index location isn't empty -> found key with same value -> update the value
     * @param key as key we want to add
     * @param value as value we want to add
     */
    public void add(K key,V value){
        //create a new element
        node<K,V>element = new node<>(key,value);
        //get the new element index
        int index = normalize(key);
        //get its list
        LinkedList<node<K,V>> list = table [index];
        //if the list is null is first scenario
        if (list==null){
            table[index] = new LinkedList<>();
        }
        //see if the key is available or not
        node<K,V> found = lookup(key);
        //if the key is not available
        if (found==null){
            //add to to list which is null
            table[index].add(element);
            //resize the table if needed
            if(++size>threshold) {
                resize();
            }

        }
        // change the value
        else{
            found.value = value;
        }
    }

    /**
     * change the table and transfer data to new table with new capacity
     */
    private void resize(){
        capacity*=2;
        threshold = (int)(capacity*maxLoadFactor);
        LinkedList<node<K,V>>[] newTable = new LinkedList[capacity];
        for(int i=0;i<table.length;i++){
            if (table[i] != null ){
                for(node<K,V> tmp : table[i]){
                    //the indexes will change cause capacity has changed
                    int index = normalize(tmp.key);
                    LinkedList<node<K,V>> list = newTable[index];
                    if (list == null){
                        newTable[index]=new LinkedList<>();
                    }
                    newTable[index].add(tmp);
                }
                //clear the table
                table[i].clear();
                table[i]=null;
            }
        }
        table = newTable;
    }

    /**
     * remove a key from table
     * @param key as key we want to remove
     */
    public void remove (K key){
        // get the index
        int index = normalize(key);
        LinkedList<node<K,V>> list = table[index];
        //look for key
        node<K,V> result = lookup(key);
        // there is no node with key to remove
        if (result == null){
            throw new NullPointerException("there is no key with this value");
        }
        //remove it from the list
        list.remove(result);
        size--;

    }

    /**
     * clear all of the table
     */
    public void clear(){
        Arrays.fill(table,null);
        size = 0;
    }

    /**
     * make a iterator -> implement iterable
     * @return iterator
     */
    @Override
    public java.util.Iterator<K> iterator() {
        return new java.util.Iterator<K>(){
            java.util.Iterator<node<K,V>> nodeIterator = (table[0]==null)?null : table[0].iterator();
            int index = 0;
            @Override
            public boolean hasNext() {
                if (nodeIterator==null || !nodeIterator.hasNext()){
                    while(++index<capacity){
                        if(table[index]!=null) {
                            java.util.Iterator<node<K, V>> new_nodeIterator = table[index].iterator();
                            if (new_nodeIterator.hasNext()){
                                nodeIterator=new_nodeIterator;
                                break;
                            }
                        }
                    }


                }
                return index < capacity;
            }

            @Override
            public K next() {
                return nodeIterator.next().key;
            }
        };
    }

    /**
     * @return show table as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) continue;
            for (node<K, V> entry : table[i]) sb.append(entry + ", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
