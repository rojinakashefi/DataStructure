/**
 * Implementing union find
 */
public class UnionFind {
    //how many elements we have
    int size_all_elements;
    //how many roots available
    int[] roots;
    //size of each component
    int[] size_each_component;
    //how many groups we have
    int number_component;

    /**
     * @param size as elements we have
     */
    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size cant be zero");
        }
        this.size_all_elements = size;
        //the components and roots we have are same at first
        roots = new int[size];
        size_each_component = new int[size];
        for (int i = 0; i < size; i++) {
            roots[i] = i;
            // only themselves
            size_each_component[i] = 1;
        }
    }

    /**
     * finding an element is in a component or not
     * @param element the element we are looking for
     * @return root number of the element
     */
    public int find(int element) {

        int root = element;
        //if the element isn't the root keep going up
        while (roots[root] != root) {
            root = roots[element];
        }
        //path compression
        // and is what gives us amortized time complexity.
        while (roots[element] != root) {
            int next = roots[element];
            roots[element] = root;
            element = next;

        }
        return root;
    }
    /**
     * check if two elements are in the same group or not
     * by seeing their roots
     */
    public boolean connected(int elm_1,int elm_2){
        return find(elm_1)==find(elm_2);
    }

    /**
     * size of group
     * @param element as element in a group we are seeing its size
     * @return size
     */
    public int getSize_each_component(int element){
        return size_each_component[find(element)];
    }

    /**
     * how many elements we have
     * @return size of elements
     */

    public int getSize_all_elements(){
        return size_all_elements;
    }

    /**
     * how many groups we have
     * @return number of components
     */
    public int getNumber_component(){
        return number_component;
    }

    /**
     * merges two elements components if possible
     * @param element_1 as element of group1
     * @param element_2 as element of group2
     */
    public void union(int element_1, int element_2) {
        //if they have same roots means they are in same group
        if (connected(element_1,element_2)){
            return;
        }
        int root_1 =  find(element_1);
        int root_2 =  find(element_2);
        //adds the group smaller to group bigger
        if(size_each_component[root_1]<=size_each_component[root_2]){
            size_each_component[root_2]+=size_each_component[root_1];
            //make their root the same
            roots[root_1]=root_2;
            size_each_component[root_1]=0;

        }
        else{
            size_each_component[root_1]+=size_each_component[root_2];
            roots[root_2]=root_1;
            size_each_component[root_2]=0;
        }
        // we have merged two groups to one groups(size of groups reduced)
        number_component-=1;
    }
}
