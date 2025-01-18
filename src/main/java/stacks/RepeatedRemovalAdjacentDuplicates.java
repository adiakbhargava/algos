package stacks;

import java.util.Stack;

public class RepeatedRemovalAdjacentDuplicates {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println("Orignial String : " + str);
        System.out.println("Output : " + (new RepeatedRemovalAdjacentDuplicates()).repeatedRemovalOfAdjacentDuplicates(str));
    }

    private String repeatedRemovalOfAdjacentDuplicates(String str){
        Stack<Character> stack =  new Stack<>();

        for(char c : str.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else{
                stack.add(c);
            }
        }

        return stack.toString();
    }
}
