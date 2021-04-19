public class Main {

    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("r");
        array.add("o");
        array.add("j");
        array.add("i");
        array.print();


        array.remove("o");
        System.out.println(array.indexOf("r"));
		System.out.println(array.indexOf("o"));
		System.out.println(array.containOf("j"));
		System.out.println(array.containOf("o"));
		System.out.println(array.getIndex(2));
        array.print();
    }
}
