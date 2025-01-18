package twopointers;

public class Largestcontainer {
    public static void main(String[] args) {
        // case 1 : typical case
        int[] heights1 = {2,7,8,3,7,6};
        System.out.println((new Largestcontainer()).getLargestContainer(heights1));

        // case 2 : empty array
        int[] heights2 = {};
        System.out.println((new Largestcontainer()).getLargestContainer(heights2));

        // case 3 : single-element array
        int[] heights3 = {1};
        System.out.println((new Largestcontainer()).getLargestContainer(heights3));

        // case 4 : array with no containers that can contain water
        int[] heights4 = {0,1,0};
        System.out.println((new Largestcontainer()).getLargestContainer(heights4));

        // case 5 : array where all the heights are the same
        int[] heights5 = {3,3,3,3};
        System.out.println((new Largestcontainer()).getLargestContainer(heights5));

        // case 6 : array with strictly increasing heights
        int[] heights6 = {1,2,3};
        System.out.println((new Largestcontainer()).getLargestContainer(heights6));

        // case 3 : array with strictly decreasing heights
        int[] heights7 = {3,2,1};
        System.out.println((new Largestcontainer()).getLargestContainer(heights7));
    }

    private int getLargestContainer(int[] heights){
        int l = 0;
        int r = heights.length-1;
        int maxWater = 0;

        while(l < r){
            int water = Math.min(heights[l], heights[r])*(r-l);
            maxWater = Math.max(water, maxWater);

            if(heights[l] < heights[r]){
                l++;
            } else if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
                r--;
            }
        }

        return maxWater;
    }
}
