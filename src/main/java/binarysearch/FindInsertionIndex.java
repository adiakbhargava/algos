package binarysearch;

import java.util.Arrays;
import java.util.List;

public class FindInsertionIndex {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,4,5,7,8,9);
        System.out.println(nums);
        System.out.println("Index : " + (new FindInsertionIndex()).getInsertionIndex(nums, 6));
    }

    private int getInsertionIndex(List<Integer> nums, int target){
        // 1. Init
        int left = 0;
        int right = nums.size();

        // 2. Logic Impl
        while(left < right){
            // get mid
            int mid = (left + right) / 2;
            // if mid is greater than or equal to our target, we move the right bound to be equal to mid
            if(nums.get(mid) >= target){
                right = mid;
            } else {
                // else, we move the left bound to be one greater than our mid index
                left = mid + 1;
            }
        }

        return left;
    }
}
