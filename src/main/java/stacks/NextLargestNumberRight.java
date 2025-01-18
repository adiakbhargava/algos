package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestNumberRight {
    public static void main(String[] args) {
        int[] nums = {5,2,4,6,1};
        System.out.println("Orignal Arr : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString((new NextLargestNumberRight()).getNextLargestNumberToTheRight(nums)));
    }

    private int[] getNextLargestNumberToTheRight(int[] nums){
        // 1. Init
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // 2. Logic Impl
        for(int i = nums.length-1; i >= 0; i--){
            // check that elements in the stack are strictly greater than current num
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                // if top of stack is less than current num, remove from stack
                stack.pop();
            }

            // set result to top of stack unless stack is empty
            result[i] = (stack.isEmpty() ? -1 : stack.peek());
            // add number to stack
            stack.add(nums[i]);
        }

        return result;
    }
}
