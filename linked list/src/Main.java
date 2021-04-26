/**
 * Linked list
 * Three types of list:
 * 1)Singular linked list
 * 2)Doubly linked list
 * 3)Circular linked list
 * @author rojina kashefi
 * @since April 2021
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        DoublyLinkedList<String> doublyLinkedList=new DoublyLinkedList<>();
        System.out.println(ANSI_RED+"Doubly linked list \n"+ANSI_RESET);
        System.out.println("adding r at first:");
        doublyLinkedList.addFirst("r");
        System.out.println(doublyLinkedList.toString());
        System.out.println("adding o at first:");
        doublyLinkedList.addFirst("o");
        System.out.println(doublyLinkedList.toString());
        System.out.println("adding j at last:");
        doublyLinkedList.addLast("j");
        System.out.println(doublyLinkedList.toString());
        System.out.println("adding i at last:");
        doublyLinkedList.addLast("i");
        System.out.println(doublyLinkedList.toString());
        System.out.print("index of o is : ");
        System.out.println(doublyLinkedList.indexOf("o"));
        System.out.println("peek first result is :");
        System.out.println(doublyLinkedList.peekFirst());
        System.out.println("peek last result is :");
        System.out.println(doublyLinkedList.peekLast());
        System.out.println("printing linked list using iterator");
        for(Object obj : doublyLinkedList){
            System.out.print(obj+" ");
        }
        System.out.println("\nremoving first element:");
        doublyLinkedList.removeFirst();
        System.out.println(doublyLinkedList.toString());
        System.out.println("removing a specific element(o):");
        doublyLinkedList.remove("o");
        System.out.println(doublyLinkedList.toString());
        System.out.println("removing index 2 of linked list: ");
        doublyLinkedList.removeAt(0);
        System.out.println(doublyLinkedList.toString());
        System.out.println("\n\n========================================\n"+ANSI_RED+"Single linkedlist\n"+ANSI_RESET);
        SingularLinkedlist<Integer> singularLinkedlist=new SingularLinkedlist<>();
        singularLinkedlist.addFirst(4);
        singularLinkedlist.addFirst(3);
        singularLinkedlist.addFirst(2);
        singularLinkedlist.addFirst(1);
        System.out.println("size of linked list is: "+singularLinkedlist.size());
        singularLinkedlist.addLast(5);
        System.out.println(singularLinkedlist.toString());
        System.out.println("index of 3 is :"+singularLinkedlist.indexOf(3));
        System.out.println("inserting a special element in first of list:");
        singularLinkedlist.insert(10,0);
        System.out.println(singularLinkedlist);
        System.out.println("inserting a special element in last of list:");
        singularLinkedlist.insert(11,6);
        System.out.println(singularLinkedlist);
        System.out.println("inserting a special character in middel of list :");
        singularLinkedlist.insert(16,4);
        System.out.println(singularLinkedlist.toString());
        System.out.println("removing a special character in linked list: ");
        singularLinkedlist.remove(16);
        System.out.println(singularLinkedlist);
        System.out.println("removing a special index in linked list:");
        singularLinkedlist.removeAt(3);
        System.out.println(singularLinkedlist);
        System.out.println("removing first element");
        singularLinkedlist.removeFirst();
        System.out.println(singularLinkedlist);
        System.out.println("removing last element:");
        singularLinkedlist.removeLast();
        System.out.println(singularLinkedlist);
        System.out.println("peek first is : "+singularLinkedlist.peekFirst());
        System.out.println("peek last is : "+singularLinkedlist.peekLast());
        System.out.println("iterating throw linked list :");
        for (Object element:singularLinkedlist){
            System.out.print(element+" ");
        }

        System.out.println("\n\n========================================\n"+ANSI_RED+"circular linkedlist\n"+ANSI_RESET);
        CircularLinkedList<Integer>circularLinkedList=new CircularLinkedList<>();
        circularLinkedList.addLast(1);
        circularLinkedList.addLast(2);
        circularLinkedList.addLast(3);
        circularLinkedList.addLast(4);
        circularLinkedList.addFirst(0);
        System.out.println(circularLinkedList);
        System.out.println("Inserting number 5 in last of list : ");
        circularLinkedList.insert(5,5);
        System.out.println(circularLinkedList);
        System.out.println("Inserting number 5 in first of list : ");
        circularLinkedList.insert(0,5);
        System.out.println(circularLinkedList);
        System.out.println("Inserting number 5 in middle of list : ");
        circularLinkedList.insert(2,5);
        System.out.println(circularLinkedList);
        System.out.println("index of number 3 is : "+circularLinkedList.indexOf(3));
        System.out.println("contain number 4 :"+circularLinkedList.contains(4));
        System.out.println("contain number 10 :"+circularLinkedList.contains(10));
        System.out.println("removing number 3");
        circularLinkedList.remove(3);
        System.out.println(circularLinkedList);
        System.out.println("removing last element of linked list");
        circularLinkedList.removeLast();
        System.out.println(circularLinkedList);
        System.out.println("removing first element of linked list");
        circularLinkedList.removeFirst();
        System.out.println(circularLinkedList);
        System.out.println("peek first element: "+circularLinkedList.peekFirst());
        System.out.println("peek last element: "+circularLinkedList.peekLast());
        System.out.println("iterating all linked list");
        for(Object element:circularLinkedList){
            System.out.print(element+",");
        }

    }
}
