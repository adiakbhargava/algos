package greedy;

import java.util.Arrays;

public class GasStations {
    public static void main(String[] args) {
        int[] gas = {2,5,1,3};
        int[] cost = {3,2,1,4};
        System.out.println("Amount of gas at each station : " + Arrays.toString(gas));
        System.out.println("Amount of gas cost at each station : " + Arrays.toString(cost));
        System.out.println("Station to start : " + (new GasStations()).getStation(gas, cost));
    }

    private int getStation(int[] gas, int[] cost){
        // 1. Init
        int sumGas = 0;
        int sumCost = 0;

        for(int n : gas){
            sumGas += n;
        }

        for(int n : cost){
            sumCost += n;
        }

        // if the total amount of gas is less than the total cost from each station, then it would be impossible to do a complete traversal of the circular route
        if(sumGas < sumCost){
            return -1;
        }

        // establish starting index along with the gas amount of the current tank
        int start = 0;
        int currTank = 0;
        // 2. Logic Impl
        for(int i = 0; i < gas.length; i++){
            // add the difference between the gas and cost of going to the station
            currTank += gas[i] - cost[i];
            // if the current tank is negative, we know we can't continue our journey, so we move on to the next station as our starting point and reset our tank
            if(currTank < 0){
                start = i + 1;
                currTank = 0;
            }
        }

        return start;
    }
}
