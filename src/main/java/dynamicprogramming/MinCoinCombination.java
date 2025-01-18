package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class MinCoinCombination {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 5;
        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("Target Price : " + target);
        System.out.println("Minimum Number of Coins to Match Price (Bottom-up) : " + (new MinCoinCombination()).minCoinCombinationBottumUp(coins, target));

        int[] coins1 = {2,4};
        target = 5;
        System.out.println("\nCoins : " + Arrays.toString(coins1));
        System.out.println("Target Price : " + target);
        System.out.println("Minimum Number of Coins to Match Price (Bottom-up): " + (new MinCoinCombination()).minCoinCombinationBottumUp(coins1, target));

        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("Target Price : " + target);
        System.out.println("Minimum Number of Coins to Match Price (Top-down) : " + (new MinCoinCombination()).minCoinCombinationTopDown(coins, target));

        System.out.println("\nCoins : " + Arrays.toString(coins1));
        System.out.println("Target Price : " + target);
        System.out.println("Minimum Number of Coins to Match Price (Top-down): " + (new MinCoinCombination()).minCoinCombinationTopDown(coins1, target));
    }

    private int minCoinCombinationTopDown(int[] coins, int target){
        int result = topDownDP(coins, target, new HashMap<>());

        return (result == -2147483648 ? -1 : result);
    }

    private int topDownDP(int[] coins, int target, HashMap<Integer, Integer> memo){
        if(target == 0){
            return 0;
        }
        if(memo.containsKey(target)){
            return memo.get(target);
        }

        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= target){
                minCoins = Math.min(minCoins, 1 + topDownDP(coins, target-coin, memo));
            }
        }
        memo.put(target, minCoins);

        return memo.get(target);
    }

    private int minCoinCombinationBottumUp(int[] coins, int target){
        int[] dp = new int[target+1];
        for(int i = 1; i < target + 1; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int t = 1; t < target + 1; t++){
            for(int coin : coins){
                if(coin <= t){
                    dp[t] = Math.min(dp[t], 1 + dp[t - coin]);
                }
            }
        }

        return (dp[target] == -2147483648 ? -1 : dp[target]);
    }
}
