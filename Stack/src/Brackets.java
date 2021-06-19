import java.util.*;

/**
 * A program which it will be used in compilers to check if the brackets are closed or not
 *
 */
public class Brackets {
    LStack<String> stack;
    HashMap<String, String> dictionary;
    ArrayList<String> wordList;

    /**
     * constructor
     * @param input as string input we are checking if its is valid or invalid
     */
    public Brackets(ArrayList<String>input) {
        stack = new LStack<>();
        wordList = input;
        dictionary = new HashMap<String, String>();
        dictionary.put("[", "]");
        dictionary.put("{", "}");
        dictionary.put("(", ")");
    }

    /**
     * checking if its valid or not
     * @return its valid or not
     */
    public boolean operation() {
        for (String add : wordList) {
            //check if it is a key(left brackets are key)
            if (dictionary.containsKey(add)) {
                //if it is we should add it
                stack.push(add);
            } else {
                if (stack.isEmpty()){
                    //if list is empty and a string isn't left bracket so the first item wil be right bracket which is wrong
                    return false;
                }
                else if (add.equals(dictionary.get(stack.peek()))) {
                    //if the right bracket is equal to inverse of top element is stack
                    //pop the top element
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        //if after popping element stack isn't empty means the stack contains only left brackets which is not valid
        return stack.isEmpty();
    }
}
