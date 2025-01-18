package hashmaps_hashsets;
import java.util.Arrays;
import java.util.HashMap;

public class Tripletsum {
    public static void main(String[] args) {
        int[] nums1 = {-1,3,4,2};
        int target = 5;
        System.out.println("arr : " + Arrays.toString(nums1)+ " target : " + target +
                "\nindices : " + Arrays.toString((new Tripletsum()).pairSumUnsortd(nums1, target)));

        int[] nums2 = {-1,2,3,4};
        target = 9;
        System.out.println("arr : " + Arrays.toString(nums2)+ " target : " + target +
                "\nindices : " + Arrays.toString((new Tripletsum()).pairSumUnsortd(nums2, target)));

        int[] nums3 = {-1,2,3,4};
        target = 20;
        System.out.println("arr : " + Arrays.toString(nums3)+ " target : " + target +
                "\nindices : " + Arrays.toString((new Tripletsum()).pairSumUnsortd(nums3, target)));
    }

    private int[] pairSumUnsortd(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x = 0; x < nums.length; x++){
            for(int y = x+1; y <nums.length; y++){
                int complement = target - nums[x] - nums[y];
                if(map.containsKey(complement)){
                    return new int[]{map.get(complement), y, x};
                }
                map.put(nums[y], y);
            }
        }

        return new int[]{-1,-1, -1};
    }

}
