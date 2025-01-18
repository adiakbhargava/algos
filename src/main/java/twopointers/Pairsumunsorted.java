package twopointers;

public class Pairsumunsorted {
    public static void main(String[] args) {

    }

    /**
     * Unsorted solution if you don't want to mess up the indices
     *
     * O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] pairsumunsorted(int[] nums, int target) {
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[j]+nums[j-i] == target){
                    return new int[]{j, j-i};
                }
            }
        }

        return null;
    }
}
