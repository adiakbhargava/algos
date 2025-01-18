package twopointers;

import java.util.Arrays;

public class Pairsum {
    public static void main(String[] args) {
        System.out.println("Starting pairsum...");

        // case 1 : typical case
        int[] arr1 = {-5, -2, 3, 4, 6};
        int target = 7;
        System.out.println("arr : " + Arrays.toString(arr1) + ", target = " + target);
        int[] indices = (new Pairsum()).pairSumSorted(arr1, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 2 : empty array
        int[] arr2 = {};
        target = 0;
        System.out.println("arr : " + Arrays.toString(arr2) + ", target = " + target);
        indices = (new Pairsum()).pairSumSorted(arr2, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 3 : array with one element
        int[] arr3 = {1};
        target = 1;
        System.out.println("arr : " + Arrays.toString(arr3) + ", target = " + target);
        indices = (new Pairsum()).pairSumSorted(arr3, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 4 : array with two elements that sum to target
        int[] arr4 = {2, 3};
        target = 5;
        System.out.println("arr : " + Arrays.toString(arr4) + ", target = " + target);
        indices = (new Pairsum()).pairSumSorted(arr4, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 5 : array with two elements that don't sum to target
        int[] arr5 = {2, 4};
        target = 5;
        System.out.println("arr : " + Arrays.toString(arr5) + ", target = " + target);
        indices = (new Pairsum()).pairSumSorted(arr5, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 6 : array with duplicate values
        int[] arr6 = {2, 2, 3};
        target = 5;
        System.out.println("arr : " + Arrays.toString(arr6) + ", target = " + target);
        indices = (new Pairsum()).pairSumSorted(arr6, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 7 : array with negative number in target pair
        int[] arr7 = {-1, 2, 3};
        target = 2;
        System.out.println("arr : " + Arrays.toString(arr7) + ", target = " + target);
        indices = (new Pairsum()).pairSumSorted(arr7, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 8 : array with both numbers of the target pair being negative
        int[] arr8 = {-3, -2, -1};
        target = -5;
        System.out.println("arr : " + Arrays.toString(arr8) + ", target = " + target);
        indices = (new Pairsum()).pairSumSorted(arr8, target);
        System.out.println("indices : " + Arrays.toString(indices));

        // case 9 : array with both numbers of the target pair being negative
        int[] arr9 = (new Pairsum()).generateSortedArr(900000000);
        target = -1;
        //-Xmx10000m System.out.println("arr : " + Arrays.toString(arr9) + ", target = " + target);
        long startedAt = System.currentTimeMillis();
        indices = (new Pairsum()).pairSumSorted(arr9, target);
        System.out.println("indices : " + Arrays.toString(indices) + ", TIME TAKEN (ms): " + (System.currentTimeMillis() - startedAt));
    }

    /**
     * perform pair sum operation for a sorted array
     *
     * @param arr
     * @param target
     * @return
     */
    private int[] pairSumSorted(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int[] indices = {-1, -1};
        int loopCount = 0;

        if ((l < r) && ((arr[l] + arr[l + 1] > target) ||
                (arr[r] + arr[r - 1] < target))) {

            return indices;
        }

        while (l < r) {
            loopCount += 1;
            int sum = arr[l] + arr[r];
            if (sum > target) {
                r = r - 1;
            } else if (sum < target) {
                l = l + 1;
            } else {
                indices[0] = l;
                indices[1] = r;
                break;
            }
        }

        System.out.println("# of LOOPS : " + loopCount);

        return indices;
    }

    private int[] generateSortedArr(int count) {
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = i;
        }

        return arr;
    }

}