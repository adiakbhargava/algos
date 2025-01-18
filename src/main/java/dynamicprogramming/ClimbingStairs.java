package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;

public class ClimbingStairs {
    private static long numberOfRecursiveCalls = 0;
    private static HashMap<Integer, Integer> globalMemo = new HashMap<>();
    public static void main(String[] args) {
        int numberOfStairs = 10;
        System.out.println("Number of Stairs : " + numberOfStairs);
        System.out.println("Number of Distinct Ways to Climb the Staircase (Top Down) : " + (new ClimbingStairs()).climbingStairsTopDown(numberOfStairs, new HashMap<>()));
        System.out.println("Size of Global Memo : " + globalMemo.size());
        System.out.println("Number of Recursive Calls : " + numberOfRecursiveCalls);
        numberOfRecursiveCalls = 0;
        System.out.println("Number of Distinct Ways to Climb the Staircase (Top Down-Without Memoization) : " + (new ClimbingStairs()).climbingStairsTopDownWithoutMemoization(numberOfStairs));
        System.out.println("Number of Recursive Calls : " + numberOfRecursiveCalls);
        System.out.println("Number of Distinct Ways to Climb the Staircase (Bottom Up) : " + (new ClimbingStairs()).climbingStairsBottomUp(numberOfStairs));
        System.out.println("Number of Distinct Ways to Climb the Staircase (Bottom Up-Optimized) : " + (new ClimbingStairs()).climbingStairsBottomUpOptimized(numberOfStairs));
    }

    // Without memorization : Time complexity O(2^n)
    // With memorization : Time complexity O(n)
    // Space complexity O(n)
    private int climbingStairsTopDown(int n, HashMap<Integer, Integer> memo){
        if(n <= 2){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        numberOfRecursiveCalls += 2;
        int result = (climbingStairsTopDown(n-1, memo) + climbingStairsTopDown(n-2, memo));
        memo.put(n, result);
        globalMemo.put(n, result);

        return memo.get(n);
    }

    private int climbingStairsTopDownWithoutMemoization(int n){
        if(n <= 2){
            return n;
        }
        numberOfRecursiveCalls += 2;
        int result = (climbingStairsTopDownWithoutMemoization(n-1) + climbingStairsTopDownWithoutMemoization(n-2));

        return result;
    }

    // Time complexity : O(n)
    // Space complexity : O(n)
    private int climbingStairsBottomUp(int n){
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n + 1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Time complexity : O(n)
    // Space complexity : O(1)
    private int climbingStairsBottomUpOptimized(int n){
        if(n <= 2){
            return n;
        }
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        for(int i = 3; i < n + 1; i++){
            int current  = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = current;
        }

        return oneStepBefore;
    }
}
