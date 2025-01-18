package binarysearch;

import java.util.Random;

public class WeightedRandomSelection {
    private int[] prefixSums;

    private static final Random rand = new Random(System.currentTimeMillis());

    public WeightedRandomSelection(int[] weights){
        prefixSums = new int[weights.length];
        prefixSums[0] = weights[0];

        for(int i = 1; i < prefixSums.length; i++){
            prefixSums[i] = weights[i] + prefixSums[i-1];
        }
    }

    public static void main(String[] args) {
        WeightedRandomSelection wrs = new WeightedRandomSelection(new int[]{1,1,1,7});
        //long seed = System.currentTimeMillis();
        for (int i=0;i<10;i++) System.out.println(wrs.select());
    }

    private int select(){

        int target = rand.nextInt(prefixSums[prefixSums.length-1]) + 1;
        System.out.println("t-" + target);
        int l = 0;
        int r = prefixSums.length-1;

        while(l < r){
            int mid = (l + r) / 2;
            if(prefixSums[mid] < target){
                l = mid + 1;
            } else{
                r = mid;
            }
        }

        return l;
    }
}
