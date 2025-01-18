package binarysearch;

import java.util.Arrays;

public class LocalMaxima {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,3};
        System.out.println("arr : " + Arrays.toString(arr));
        System.out.println((new LocalMaxima()).findLocalMaxima(arr));
    }

    private int findLocalMaxima(int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            } else{
                r = mid;
            }
        }

        return l;
    }
}
