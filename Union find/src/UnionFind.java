public class UnionFind {
    int size_all_elements;
    int[] roots;
    int[] size_each_component;
    int number_component;

    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size cant be zero");
        }
        this.size_all_elements = size;
        roots = new int[size];
        size_each_component = new int[size];
        for (int i = 0; i < size; i++) {
            roots[i] = i;
            size_each_component[i] = 1;
        }
    }

    public int find(int element) {
        if (roots[element] == element) {
            return -1;
        }
        int root = element;

        while (roots[root] != root) {
            root = roots[element];
        }
        while (roots[element] != root) {
            int next = roots[element];
            roots[element] = root;
            element = next;

        }
        return root;
    }

    public boolean connected(int elm_1,int elm_2){
        return find(elm_1)==find(elm_2);
    }
    public int getSize_each_component(int element){
        return size_each_component[find(element)];
    }
    public int getSize_all_elements(){
        return size_all_elements;
    }
    public int getNumber_component(){
        return number_component;
    }
    public void union(int element_1, int element_2) {
        if (connected(element_1,element_2)){
            return;
        }
        int root_1 =  find(element_1);
        int root_2 =  find(element_2);
        if(size_each_component[root_1]<=size_each_component[root_2]){
            size_each_component[root_2]+=size_each_component[root_1];
            roots[root_1]=root_2;
            size_each_component[root_1]=0;

        }
        else{
            size_each_component[root_1]+=size_each_component[root_2];
            roots[root_2]=root_1;
            size_each_component[root_2]=0;
        }
        number_component-=1;
    }
}
