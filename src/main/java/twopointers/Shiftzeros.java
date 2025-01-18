package twopointers;

import java.util.Arrays;

public class Shiftzeros {
    public static void main(String[] args) {
        // case 1 : typical case
        int[] nums1 = {0,1,0,3,2};
        System.out.println("original arr : " + Arrays.toString(nums1));
        (new Shiftzeros()).shiftZerosToEnd(nums1);
        System.out.println("modified arr : " + Arrays.toString(nums1));

        // case 2 : empty array
        int[] nums2 = {};
        System.out.println("original arr : " + Arrays.toString(nums2));
        (new Shiftzeros()).shiftZerosToEnd(nums2);
        System.out.println("modified arr : " + Arrays.toString(nums2));

        // case 3 : array with one zero
        int[] nums3 = {0};
        System.out.println("original arr : " + Arrays.toString(nums3));
        (new Shiftzeros()).shiftZerosToEnd(nums3);
        System.out.println("modified arr : " + Arrays.toString(nums3));

        // case 4 : array with one non-zero element
        int[] nums4 = {1};
        System.out.println("original arr : " + Arrays.toString(nums4));
        (new Shiftzeros()).shiftZerosToEnd(nums4);
        System.out.println("modified arr : " + Arrays.toString(nums4));

        // case 3 : array with all zeros
        int[] nums5 = {0,0,0};
        System.out.println("original arr : " + Arrays.toString(nums5));
        (new Shiftzeros()).shiftZerosToEnd(nums5);
        System.out.println("modified arr : " + Arrays.toString(nums5));

        // case 6 : array with all non-zero elements
        int[] nums6 = {1,2,3};
        System.out.println("original arr : " + Arrays.toString(nums6));
        (new Shiftzeros()).shiftZerosToEnd(nums6);
        System.out.println("modified arr : " + Arrays.toString(nums6));

        // case 7 : array with zeros already at the end
        int[] nums7 = {1,1,1,0,0};
        System.out.println("original arr : " + Arrays.toString(nums7));
        (new Shiftzeros()).shiftZerosToEnd(nums7);
        System.out.println("modified arr : " + Arrays.toString(nums7));

        // case 8 : array with all zeros at the start
        int[] nums8 = {0,0,1,1,1};
        System.out.println("original arr : " + Arrays.toString(nums8));
        (new Shiftzeros()).shiftZerosToEnd(nums8);
        System.out.println("modified arr : " + Arrays.toString(nums8));
    }

    private void shiftZerosToEnd(int[] nums){
        int l = 0;

        for(int r = 0; r < nums.length; r++){
            if(nums[r] != 0){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
        }
    }
}
