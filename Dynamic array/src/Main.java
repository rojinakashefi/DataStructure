import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<>();
        System.out.println("adding r to list");
        array.add("r");
        System.out.println("adding o to list");
        array.add("o");
        System.out.println("adding j to list");
        array.add("j");
        System.out.println("adding i to list");
        array.add("i");
        System.out.println("===============");
        System.out.println("list is : ");
        array.print();
        System.out.println("===============");
        System.out.println("removing o element");
        array.remove("o");
        System.out.print("array is : ");
        array.print();
        System.out.println("index number of r is : "+array.indexOf("r"));
		System.out.println("index number of o is : "+array.indexOf("o"));
		System.out.println("if array contain j: "+array.containOf("j"));
		System.out.println("if array contain o: "+array.containOf("o"));
		System.out.println("returning index number 2 : "+array.getIndex(2));
		//we can say array.toString but compiler it self understand it should convert array to string
        //so it uses toString method which we over rides it
        System.out.println("converting array in string: "+ array);
        System.out.println("===============");
        System.out.println("iterate array using direct iterator: ");
        Iterator<String> iterator= array.iterator();
        while(iterator.hasNext()) {
            Object element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println("\niterate array using for each : ");
        for (Object element : array) {
            System.out.print(element + " ");
        }

    }
}
