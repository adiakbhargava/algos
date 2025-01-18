package heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,1,9,4,7,10};
        int k = 2;
        System.out.println("Arr : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString((new SortKSortedArray()).sortKSortedArray(nums, k)));
    }

    private int[] sortKSortedArray(int[] nums, int k){
        // 1. Init
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // fill heap with elements up to k + 1 index
        for(int i = 0; i < k + 1; i ++){
            minHeap.add(nums[i]);
        }

        // create insertion index
        int insertIndex = 0;

        // 2. Logic Impl
        // iterate through nums starting at k + 1
        for(int j = k + 1; j < nums.length; j++){
            // insert min value in heap in insertion index position
            nums[insertIndex] = minHeap.poll();
            // increment insertion index to next element in nums
            insertIndex += 1;
            // add current element to heap
            minHeap.add(nums[j]);
        }

        // empty out remaining elements in heap
        while(!minHeap.isEmpty()){
            nums[insertIndex] = minHeap.poll();
            insertIndex += 1;
        }

        return nums;
    }
}
