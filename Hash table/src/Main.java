public class Main {

    public static void main(String[] args) {
	SeparateChaining<String,Integer> sp = new SeparateChaining<>();
	System.out.println("size default : " +sp.size());
	System.out.println("capacity is : " + sp.getCapacity());
	System.out.println("============================");
	sp.add("one",1);
	sp.add("two",2);
	sp.add("three",3);
	System.out.println(sp.toString());
	System.out.println("size after adding : : " +sp.size());
	System.out.println("=======================");
    sp.add("one",3);
    System.out.println("adding a key which is used " + sp.toString());
	System.out.println("size after adding used value: " +sp.size());
	System.out.println("======================");
    sp.remove("three");
	System.out.println(sp.toString());
	System.out.println("size after remove :" + sp.size());
	System.out.println("================");
	System.out.println("get value of one (lookup method used) : " +sp.get_value("one"));
	System.out.println("====================");
	sp.add("four",4);
	System.out.println("added four now check the key is available : " + sp.has_key("four"));
	System.out.println("====================");
	System.out.println("capacity is (Resize method worked) : " +sp.getCapacity());

    }
}
