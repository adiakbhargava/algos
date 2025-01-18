package dynamicprogramming;

import java.util.Arrays;

public class NeighborhoodBurglary {
    public static void main(String[] args) {
        int[] houses = {200,300,200,50};
        System.out.println("Houses : " + Arrays.toString(houses));
        System.out.println("Max Profit (Unoptimized) : " + (new NeighborhoodBurglary()).neighborhoodBurglary(houses));

        int[] houses1 = {200,500};
        System.out.println("Houses : " + Arrays.toString(houses1));
        System.out.println("Max Profit (Unoptimized) : " + (new NeighborhoodBurglary()).neighborhoodBurglary(houses1));

        int[] houses2 = {200};
        System.out.println("Houses : " + Arrays.toString(houses2));
        System.out.println("Max Profit (Unoptimized) : " + (new NeighborhoodBurglary()).neighborhoodBurglary(houses2));

        int[] houses3 = {200,300,200,50};
        System.out.println("Houses : " + Arrays.toString(houses3));
        System.out.println("Max Profit (Optimized) : " + (new NeighborhoodBurglary()).neighborHoodBurglarlyOptimized(houses3));

        int[] houses4 = {200,500};
        System.out.println("Houses : " + Arrays.toString(houses4));
        System.out.println("Max Profit (Optimized) : " + (new NeighborhoodBurglary()).neighborHoodBurglarlyOptimized(houses4));

        int[] houses5 = {200};
        System.out.println("Houses : " + Arrays.toString(houses5));
        System.out.println("Max Profit (Optimized) : " + (new NeighborhoodBurglary()).neighborHoodBurglarlyOptimized(houses5));


    }

    private int neighborhoodBurglary(int[] houses){
        if(houses == null){
            return 0;
        }

        if(houses.length == 1){
            return houses[0];
        }

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for(int i = 2; i < houses.length; i++){
            dp[i] = Math.max(dp[i-1], houses[i] + dp[i-2]);
        }

        return dp[houses.length-1];
    }

    private int neighborHoodBurglarlyOptimized(int[] houses){
        if(houses == null){
            return 0;
        }

        if(houses.length == 1){
            return houses[0];
        }

        int prevMaxProfit = Math.max(houses[0], houses[1]);
        int prevPrevMaxProfit = houses[0];
        for(int i = 2; i < houses.length; i++){
            int currMaxProfit = Math.max(prevMaxProfit, houses[i] + prevPrevMaxProfit);
            prevPrevMaxProfit = prevMaxProfit;
            prevMaxProfit = currMaxProfit;
        }

        return prevMaxProfit;
    }
}
