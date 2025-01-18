package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tripletsum {
    public static void main(String[] args) {
        // case 1 : typical case
        int[] nums1 = {0, -1, 2, -3, 1};
        System.out.println("arr : " + Arrays.toString(nums1));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums1));

        // case 2 : another typical case
        int[] nums2 = {-1, 2, -2, 1, -1, 2};
        System.out.println("arr : " + Arrays.toString(nums2));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums2));

        // case 3 : array with duplicates
        int[] nums3 = {-4, -4, -2, 0, 0, 1, 2, 3};
        System.out.println("arr : " + Arrays.toString(nums3));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums3));

        // case 4: empty array
        int[] nums4 = {};
        System.out.println("arr : " + Arrays.toString(nums4));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums4));

        // case 5: single-element array
        int[] nums5 = {0};
        System.out.println("arr : " + Arrays.toString(nums5));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums5));

        // case 6: two-element array
        int[] nums6 = {1, -1};
        System.out.println("arr : " + Arrays.toString(nums6));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums6));

        // case 7: array where all three values are same
        int[] nums7 = {0, 0, 0};
        System.out.println("arr : " + Arrays.toString(nums7));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums7));

        // case 8: array with no triplets that sum to 0
        int[] nums8 = {1, 0, 1};
        System.out.println("arr : " + Arrays.toString(nums8));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums8));

        // case 9: array with duplicate triplets
        int[] nums9 = {0, 0, 1, -1, 1, -1};
        System.out.println("arr : " + Arrays.toString(nums9));
        System.out.println("result : " + (new Tripletsum()).tripletSum(nums9));
    }

    public ArrayList<List<Integer>> tripletSum(int[] nums) {
        ArrayList<List<Integer>> triplets = new ArrayList<List<Integer>>();
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                pairs = pairSumSortedAllPairs(nums, i + 1, -1 * nums[i]);
                List<Integer> combined = new ArrayList<Integer>();
                if (!pairs.isEmpty()) {
                    combined.add(nums[i]);
                    combined.add(pairs.get(0));
                    combined.add(pairs.get(1));
                    triplets.add(combined);
                }
            }
        }

        return triplets;
    }

    public ArrayList<Integer> pairSumSortedAllPairs(int[] nums, int start, int target) {
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        int l = start;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                pairs.add(nums[l]);
                pairs.add(nums[r]);
                l = l + 1;

                while (l < r && nums[l] == nums[l - 1]) {
                    l = l + 1;
                }
            } else if (sum < target) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }

        return pairs;
    }
}
