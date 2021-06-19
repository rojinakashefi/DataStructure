import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        LStack<Integer>lStack =new LStack<Integer>(5);
        System.out.println(ANSI_RED+"Stack using Single linked list"+ANSI_RESET);
        lStack.push(4);
        lStack.push(3);
        System.out.println("peeking first element : " +lStack.peek());
        lStack.push(2);
        lStack.push(1);
        System.out.println("print whole stack :");
        lStack.print();
        System.out.println("element which is popped is : " +lStack.pop());
        System.out.println("element which is popped is : "+lStack.pop());
        System.out.println("print after popping :");
        lStack.print();
        System.out.println(ANSI_RED+"===================================="+ANSI_RESET);
        System.out.println(ANSI_RED+"Stack using Array"+ANSI_RESET);
        AStack<Integer> aStack =new AStack<>();
        System.out.println("pushing elements :");
        aStack.push(5);
        System.out.println(Arrays.toString(aStack.getArray()));
        aStack.push(4);
        System.out.println(Arrays.toString(aStack.getArray()));
        aStack.push(3);
        System.out.println(Arrays.toString(aStack.getArray()));
        aStack.push(2);
        System.out.println(Arrays.toString(aStack.getArray()));
        aStack.push(1);
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("===============================");
        System.out.println("Popping element :" + aStack.pop());
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("popping element : "+ aStack.pop());
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("popping element : "+ aStack.pop());
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("popping element : "+ aStack.pop());
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("popping element : "+ aStack.pop());
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("==============================");
        System.out.println("pushing element : 1");
        aStack.push(1);
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("==============================");
        System.out.println("peeking element : "+ aStack.peek());
        System.out.println(Arrays.toString(aStack.getArray()));
        System.out.println("==============================");
        System.out.println("stack is :");
        aStack.print();
        System.out.println(ANSI_RED+"===================================="+ANSI_RESET);
        System.out.println(ANSI_RED+"Stack using doubly linked list"+ANSI_RESET);
        DLStack<Integer>dlStack =new DLStack<Integer>();
        System.out.println("pushing element :");
        dlStack.push(5);
        dlStack.print();
        System.out.println("========================");
        dlStack.push(4);
        dlStack.print();
        System.out.println("========================");
        dlStack.push(3);
        dlStack.print();
        System.out.println("========================");
        dlStack.push(2);
        dlStack.print();
        System.out.println("========================");
        dlStack.push(1);
        dlStack.print();
        System.out.println("=========================");
        System.out.println("popping element : " +dlStack.pop());
        dlStack.print();
        System.out.println("popping element : " +dlStack.pop());
        dlStack.print();
        System.out.println("=========================");
        System.out.println("peeking element :" + dlStack.peek());
        System.out.println("size is : " + dlStack.getSize());
        System.out.println(ANSI_RED+"===================================="+ANSI_RESET);
        System.out.println(ANSI_RED+"Compiler bracket checking"+ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        String input=" ";
        while(true){
            input =scanner.next();
            if(input.equals("-1")){
                break;
            }
            words.add(input);

        }
        Brackets brackets = new Brackets(words);
        if (!brackets.operation()){
            System.out.println("invalid");
        }
        else{
            System.out.println("valid");
        }



    }
}
