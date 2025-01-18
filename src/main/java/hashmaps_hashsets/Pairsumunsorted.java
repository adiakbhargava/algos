package hashmaps_hashsets;
import java.util.Arrays;
import java.util.HashMap;
public class Pairsumunsorted {
    public static void main(String[] args) {
        int[] nums1 = {-1,3,4,2};
        int target = 3;
        System.out.println("arr : " + Arrays.toString(nums1)+ " target : " + target +
                "\nindices : " + Arrays.toString((new Pairsumunsorted()).pairSumUnsortd(nums1, target)));

        int[] nums2 = {-1,2,3,4};
        target = 3;
        System.out.println("arr : " + Arrays.toString(nums2)+ " target : " + target +
                "\nindices : " + Arrays.toString((new Pairsumunsorted()).pairSumUnsortd(nums2, target)));
    }

    private int[] pairSumUnsortd(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }

}
