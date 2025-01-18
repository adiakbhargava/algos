package greedy;

import java.util.Arrays;

public class JumpToEnd {
    public static void main(String[] args) {
        int[] nums = {3,2,0,2,5};
        System.out.println(Arrays.toString(nums));
        System.out.println((new JumpToEnd()).jumpToEnd(nums));

        int[] nums1 = {3,2,0,0,5};
        System.out.println(Arrays.toString(nums1));
        System.out.println((new JumpToEnd()).jumpToEnd(nums1));
    }

    private boolean jumpToEnd(int[] nums){
        // 1. Init
        // set destination to last element in nums
        int destination = nums.length-1;
        // 2. Logic Impl
        for(int i = nums.length-1; i >= 0; i--){
            // if sum of current index and its value is greater than current destination, then we know we can reach the destination
            if(i + nums[i] >= destination){
                destination = i;
                System.out.println("Current Destination : " + destination);
            }
        }

        // if we can reach destination, the end value for it should be 0
        return destination == 0;
    }
}
