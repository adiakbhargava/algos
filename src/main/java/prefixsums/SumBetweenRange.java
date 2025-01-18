package prefixsums;

import java.util.Arrays;

public class SumBetweenRange {
    private int[] prefixSum;

    public SumBetweenRange(int[] nums){
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,-7,6,0,-2,5};
        int start = 0;
        int end = 3;
        SumBetweenRange obj = new SumBetweenRange(nums);
        System.out.println("Arr : " + Arrays.toString(nums));
        System.out.println("Prefix Sums : " + Arrays.toString(obj.prefixSum));
        System.out.println("Sum in Range " + start + "-" + end + " : " + obj.sumRange(start, end));

        int[] nums1 = {3,-7,6,0,-2,5};
        start = 2;
        end = 4;
        obj = new SumBetweenRange(nums1);
        System.out.println("Arr : " + Arrays.toString(nums1));
        System.out.println("Prefix Sums : " + Arrays.toString(obj.prefixSum));
        System.out.println("Sum in Range (" + start + "-" + end + ") : " + obj.sumRange(start, end));

        int[] nums2 = {3,-7,6,0,-2,5};
        start = 2;
        end = 2;
        obj = new SumBetweenRange(nums2);
        System.out.println("Arr : " + Arrays.toString(nums2));
        System.out.println("Prefix Sums : " + Arrays.toString(obj.prefixSum));
        System.out.println("Sum in Range (" + start + "-" + end + ") : " + obj.sumRange(start, end));
    }

    private int sumRange(int start, int end){
        if(start == 0){
            return prefixSum[end];
        }

        return prefixSum[end] - prefixSum[start-1];
    }
}
