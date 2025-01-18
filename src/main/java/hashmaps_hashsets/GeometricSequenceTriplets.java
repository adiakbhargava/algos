package hashmaps_hashsets;

import java.util.Arrays;
import java.util.HashMap;

public class GeometricSequenceTriplets {
    public static void main(String[] args) {
        int[] nums = {2,1,2,4,8,8};
        System.out.println("arr : " + Arrays.toString(nums) +
                "\nGeometric Triplet Frequency : " + (new GeometricSequenceTriplets()).getGeometricSequenceTripletFrequency(nums, 2));
    }

    private int getGeometricSequenceTripletFrequency(int [] nums, int r){
        HashMap<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> rightMap = new HashMap<Integer, Integer>();
        int count = 0;

        for(int n : nums){
            rightMap.put(n, rightMap.getOrDefault(n, 0)+1);
        }

        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            rightMap.put(x, rightMap.get(x)-1);
            if(x % r == 0){
                count += leftMap.getOrDefault(x / r, 0) * rightMap.getOrDefault(x * r, 0);
            }

            leftMap.put(x, leftMap.getOrDefault(x, 0)+1);
        }

        return count;
    }
}
