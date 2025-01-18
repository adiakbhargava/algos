package prefixsums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KSumSubArrays {
    public static void main(String[] args) {
        int[] nums = {1,2,-1,1,2};
        int k = 3;
        System.out.println("Arr : " + Arrays.toString(nums));
        System.out.println("Count : " + (new KSumSubArrays()).kSumSubArrays(nums, k));
    }

    private int kSumSubArrays(int[] nums, int k){
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;

        prefixSumMap.put(0,1);
        int currPrefixSum = 0;
        for(int num : nums){
            currPrefixSum += num;

            if(prefixSumMap.containsKey(currPrefixSum-k)){
                count += prefixSumMap.get(currPrefixSum-k);
            }

            prefixSumMap.put(currPrefixSum, prefixSumMap.getOrDefault(currPrefixSum, 0) + 1);
        }

        return count;
    }
}
