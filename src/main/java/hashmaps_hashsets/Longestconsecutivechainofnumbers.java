package hashmaps_hashsets;

import java.util.Arrays;
import java.util.HashSet;

public class Longestconsecutivechainofnumbers {
    public static void main(String[] args) {
        int[] nums = {1,6,2,5,18,7,10,3};
        System.out.println("arr :" + Arrays.toString(nums) +
                "\nLongest Consecutive Chain : " + (new Longestconsecutivechainofnumbers()).longestConsecutiveChain(nums));

        int[] nums1 = {1,6,4,87,9};
        System.out.println("arr :" + Arrays.toString(nums1) +
                "\nLongest Consecutive Chain : " + (new Longestconsecutivechainofnumbers()).longestConsecutiveChain(nums1));

        int[] nums2 = {5,4,2,3,1, 0, -1};
        System.out.println("arr :" + Arrays.toString(nums2) +
                "\nLongest Consecutive Chain : " + (new Longestconsecutivechainofnumbers()).longestConsecutiveChain(nums2));

        int[] nums3 = {};
        System.out.println("arr :" + Arrays.toString(nums3) +
                "\nLongest Consecutive Chain : " + (new Longestconsecutivechainofnumbers()).longestConsecutiveChain(nums3));

        int[] nums4 = {1,1,2,2,2,2};
        System.out.println("arr :" + Arrays.toString(nums4) +
                "\nLongest Consecutive Chain : " + (new Longestconsecutivechainofnumbers()).longestConsecutiveChain(nums4));
    }

    private int longestConsecutiveChain(int[] nums){
        int longestChain = 0;
        int chain = 0;
        // populate hash set with nums
        HashSet<Integer> hSet = new HashSet<Integer>(1000);
        for(int num : nums){
            hSet.add(num);
        }
        // run a for loop to iterate through nums
        for(int i = 0; i < nums.length; i++){
            // if hSet contains nums[i] - 1, skip longest chain calculation another chain will capture this element
            if(hSet.contains(nums[i]-1)){
                continue;
            } else{
                int curr = nums[i];
                while(hSet.contains(curr)){
                    curr+=1;
                    chain+=1;
                }
                longestChain = Math.max(chain, longestChain);
                chain = 0;
            }
        }

        return longestChain;
    }
}
