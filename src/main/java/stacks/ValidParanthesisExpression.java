package stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesisExpression {
    public static void main(String[] args) {
        String str = "(())";
        System.out.println("Expression : " + str);
        System.out.println("Is Valid : " + (new ValidParanthesisExpression()).checkExpression(str));

        str = "([]{})";
        System.out.println("\nExpression : " + str);
        System.out.println("Is Valid : " + (new ValidParanthesisExpression()).checkExpression(str));

        str = "([]{}}";
        System.out.println("\nExpression : " + str);
        System.out.println("Is Valid : " + (new ValidParanthesisExpression()).checkExpression(str));
    }

    private boolean checkExpression(String str){
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> paranthesisMap = new HashMap<>();
        paranthesisMap.put('(', ')');
        paranthesisMap.put('{','}');
        paranthesisMap.put('[',']');

        for(char c : str.toCharArray()){
            if(paranthesisMap.containsKey(c)){
                stack.add(c);
            } else{
                if(!stack.isEmpty() && paranthesisMap.get(stack.peek()) == c){
                    stack.pop();
                } else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
