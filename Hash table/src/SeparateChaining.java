import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class node<K,V> {
    K key;
    V value;
    int hashCode;
    public node (K key,V value) {
        this.key = key;
        this.value = value;
        this.hashCode = key.hashCode();
    }
    private boolean equal(node<K,V> other){
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
public class SeparateChaining<K,V> implements Iterator {
    private static final int DEFAULT_capacity = 4;
    private static final double DEFAULT_LOAD_VALUE = 0.75;
    private double maxLoadFactor;
    private int capacity, threshold, size = 0;
    private LinkedList<node<K,V>> []table;

    public SeparateChaining(){
        this(DEFAULT_capacity,DEFAULT_LOAD_VALUE);
    }
    public SeparateChaining(int capacity,double maxLoadFactor){
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity");
        if (maxLoadFactor <= 0) {
            throw new IllegalArgumentException("Illegal maxLoadFactor");
        }
       this.maxLoadFactor = maxLoadFactor;
       this.capacity = Math.max(capacity,DEFAULT_capacity);
       this.threshold = (int)maxLoadFactor*capacity;
       table = new LinkedList[this.capacity];

    }
    public SeparateChaining(int capacity){
        this(capacity,DEFAULT_LOAD_VALUE);
    }
    public SeparateChaining(double DEFAULT_LOAD_VALUE){
        this(DEFAULT_capacity,DEFAULT_LOAD_VALUE);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private int normalize(K key){
        if (key.hashCode() < 0){
           return  Math.abs(key.hashCode()) % capacity;
        }
        return key.hashCode() % capacity;
    }
    public node<K,V> lookup(K key){
        if (key == null){
            return null;
        }
        int index = normalize(key);
        if (table[index] == null){
            return null;
        }
        LinkedList<node<K,V>> list = table[index];
        if (list == null) {
            return null;
        }
        for (node<K,V> element : list){
            if (element.key.equals(key)){
                return element;
            }
        }
        return null;
    }
    public boolean has_key(K key){
        return lookup(key)!=null;
    }
    public V get_value(K key){
        V value = lookup(key).value;
        if (value!=null){
            return value;
        }
        else{
            throw new NullPointerException("No value with given key");
        }
    }

    public void add(K key,V value){
        node<K,V>element = new node<>(key,value);
        int index = normalize(key);
        LinkedList<node<K,V>> list = table [index];
        if (list==null){
            table[index] = new LinkedList<>();
        }
        node<K,V> found = lookup(key);
        if (found==null){
            table[index].add(element);
            if(++size>threshold)  resize();
        }
        else{
            found.value = value;
        }
    }

    public void resize(){
        capacity*=2;
        threshold = (int)(capacity*maxLoadFactor);
        LinkedList<node<K,V>>[] newTable = new LinkedList[capacity];

        for(int i=0;i<table.length;i++){
            if (table[i] != null ){
                for(node<K,V> tmp : table[i]){
                    int index = normalize(tmp.key);
                    LinkedList<node<K,V>> list = newTable[index];
                    if (list == null){
                        newTable[index]=new LinkedList<>();
                    }
                    newTable[i].add(tmp);
                }
                table[i].clear();
                table[i]=null;
            }
        }
        table = newTable;
    }
    public void remove (K key){
        int index = normalize(key);
        LinkedList<node<K,V>> list = table[index];
        node<K,V> result = lookup(key);
        if (result == null){
            throw new NullPointerException("there is no key with this value");
        }
        list.remove(result);
        size--;

    }
    public void clear(){
        Arrays.fill(table,null);
        size = 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
