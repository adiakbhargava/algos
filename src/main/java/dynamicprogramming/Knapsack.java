package dynamicprogramming;

public class Knapsack {
    public static void main(String[] args) {

    }

    private int knapsack(int cap, int[] weights, int[] values){
        int n = values.length;
        int[][] dp = new int[cap + 1][n + 1];
        for(int i = n - 1; i > 0; i--){
            for(int c = 1; c < cap+1; c++){
                if(weights[i] <= c){
                    dp[i][c] = Math.max(values[i] + dp[i+1][c-weights[i]], dp[i+1][c]);
                } else{
                    dp[i][c] = dp[i+1][c];
                }
            }
        }

        return dp[0][cap];
    }

    private int knapsackOptimized(int cap, int[] weights, int[] values){
        int n = values.length;
        int[] prevRow = new int[cap+1];
        for(int i = n-1; i > 0; i--){
            int[] currRow = new int[cap+1];
            for(int c = 1; c < cap + 1; c++){
                if(weights[i] <= c){
                    currRow[c] = Math.max(values[i] + prevRow[c-weights[i]], prevRow[c]);
                } else{
                    currRow[c] = prevRow[c];
                }
            }
            prevRow = currRow;
        }

        return prevRow[cap];
    }
}
