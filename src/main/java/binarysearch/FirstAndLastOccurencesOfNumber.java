package binarysearch;

import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccurencesOfNumber {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,4,4,5,6,7,8,9,10,11);
        System.out.println(nums);
        int[] indices = (new FirstAndLastOccurencesOfNumber()).getFirstAndLastOccurences(nums, 4);
        System.out.println("Indices : " + Arrays.toString(indices));
    }

    private int[] getFirstAndLastOccurences(List<Integer> nums, int target){
        // 1. Init
        // get lower and upper bound indices of target from nums
        int lowerBoundIndex = getLowerBound(nums, target);
        int upperBoundIndex = getUpperBound(nums, target);
        // print out lower and upperbound indices
        System.out.println("Lower Bound Index : " + lowerBoundIndex);
        System.out.println("Upper Bound Index : " + upperBoundIndex);

        return new int[]{lowerBoundIndex, upperBoundIndex};
    }

    private int getLowerBound(List<Integer> nums, int target){
        // 1. Init
        int left = 0;
        int right = nums.size() - 1;

        // 2. Logic Impl
        while(left < right){
            int mid = (left + right) / 2;
            // if mid is greater than target, set right bound immediately to the left of it
            if(nums.get(mid) > target){
                right = mid - 1;
            } else if(nums.get(mid) < target){
                // if mid is less than target, set left bound immediately to the right of it
                left = mid + 1;
            } else{
                // if mid is equal to target, set right bound to mid
                right = mid;
            }
        }

        // if target was present in list, return index, else, return -1
        return (nums.get(left) == target ? left : -1);
    }

    private int getUpperBound(List<Integer> nums, int target){
        // 1. Init
        int left = 0;
        int right = nums.size() - 1;

        // 2. Logic Impl
        while(left < right){
            // set mid to be biased toward the right bound (prevents infinite loop with left bound being equal to mid when there's only two elements in subcomponent)
            int mid = (left + right) / 2 + 1;
            // if mid is greater than target, set right bound immediately to the left of it
            if(nums.get(mid) > target){
                right = mid - 1;
            } else if(nums.get(mid) < target){
                // if mid is less than target, set left bound immediately to the right of it
                left = mid + 1;
            } else{
                // if mid is equal to target, set left bound to bound
                left = mid;
            }
        }

        // if target was present in list, return index, else, return -1
        return (nums.get(left) == target ? left : -1);
    }

}
