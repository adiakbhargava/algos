package dynamicprogramming;

public class MaximumSubarraySum {
    public static void main(String[] args) {

    }

    private int maximumSubarraySum(int[] nums){
        if(nums == null){
            return 0;
        }

        int maxSum = -1*Integer.MAX_VALUE;
        int currentSum = -1*Integer.MAX_VALUE;
        for(int num : nums){
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private int maximumSubarraySumDP(int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
