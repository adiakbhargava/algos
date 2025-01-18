package binarysearch;

import java.util.Arrays;

public class FindTargetInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {8,9,1,2,3,4,5,6,7};
        int target = 1;
        System.out.println("Array : " + Arrays.toString(nums));
        System.out.println("Index : " + (new FindTargetInRotatedSortedArray()).findTarget(nums, target));
    }

    private int findTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            } else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
        }

        return (nums[left] == target ? left : -1);
    }
}
