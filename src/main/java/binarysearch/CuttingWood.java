package binarysearch;

import java.util.Arrays;

public class CuttingWood {
    public static void main(String[] args) {
        int[] heights = {2,6,3,8};
        int k = 7;
        System.out.println("Heights : " + Arrays.toString(heights));
        System.out.println("MAX HEIGHT : " + (new CuttingWood()).cuttingWood(heights, k));
    }

    private int cuttingWood(int[] heights, int k){
        // 1. Init
        int l = 0;
        // set r to the max tree height
        int r = Arrays.stream(heights).max().getAsInt();

        // 2. Logic Impl
        while(l < r){
            // make mid biased to the right so that we can find the upper bound
            int mid = (l + r) / 2 + 1;
            // if midpoint is set to height that allows us to cut k meters, we know upper bound is somewhere to the right of the midpoint
            if(cutsEnoughWood(heights, k, mid)){
                l = mid;
            } else{
                // else if midpoint is set to height that doesn't allow us to cut k meters, we know upper bound is somewhere to the left of the midpoint
                r = mid - 1;
            }
        }

        return l;
    }

    private boolean cutsEnoughWood(int[] heights, int k, int H){
        // 1. Init
        int woodCollected  = 0;
        // 2. Logic Impl
        // if the height is greater than current value of H, add difference to amoun tof wood collected
        for(int height : heights){
            if(height > H){
                woodCollected += (height - H);
            }
        }

        // determine if H cuts at least k meters of wood
        return woodCollected >= k;
    }
}
