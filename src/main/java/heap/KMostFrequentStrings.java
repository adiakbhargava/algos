package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KMostFrequentStrings {
    class Pair {
        private String str;
        private int frequency;

        Pair(String str, int frequency) {
            this.str = str;
            this.frequency = frequency;
        }

        public String toString(){
            return "[" + str + "," + frequency + "]";
        }

        static class MaxHeapComparator implements Comparator<Pair> {
            // modify the compare method so that it prioritizes the pairs with the maximum frequency
            public int compare(Pair pairOne, Pair pairTwo) {
                // if two pairs have the same frequency, prioritize the one with the greater lexicographic string
                if (pairOne.frequency == pairTwo.frequency) {
                    return pairTwo.str.compareTo(pairOne.str);
                }

                // otherwise return -1 if the first pair's frequency is greater than the second pair's
                return (pairOne.frequency > pairTwo.frequency ? -1 : 1);
            }
        }

        static class MinHeapComparator implements Comparator<Pair>{
            // modify the compare method so that it prioritizes the pairs with the minimum frequency
            public int compare(Pair pairOne, Pair pairTwo){
                // if two pairs have the same frequency, prioritize the one that is smaller lexicographically
                if (pairOne.frequency == pairTwo.frequency) {
                    return pairOne.str.compareTo(pairTwo.str);
                }

                // otherwise, return 1 if the first pair's frequency is greater than the second pair's
                return (pairOne.frequency > pairTwo.frequency ? 1 : -1);
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = {"go", "coding", "byte", "byte", "go", "interview", "go"};
        int k = 2;
        System.out.println("Arr : " + Arrays.toString(strs));
        System.out.println("Most Frequent Strings (MAX HEAP) : " + Arrays.toString((new KMostFrequentStrings()).kMostFrequentStringsMaxHeap(strs, k)));

        System.out.println("Most Frequent Strings (MIN HEAP) : " + Arrays.toString((new KMostFrequentStrings()).kMostFrequentStringsMinHeap(strs, k)));
    }

    private String[] kMostFrequentStringsMaxHeap(String[] strs, int k) {
        // 1. Init
        String[] res = new String[k];
        PriorityQueue<Pair> pairQueue = new PriorityQueue<Pair>(new Pair.MaxHeapComparator());
        // create a hashmap that stores each string along with their frequencies in the list
        HashMap<String, Integer> counter = new HashMap<>();
        // store strings
        for (String str : strs) {
            counter.put(str, counter.getOrDefault(str, 0) + 1); // O(n)
        }

        // 2. Logic Impl
        for (String key : counter.keySet()) {
            // add each key-value pair into the priority queue as a Pair object
            pairQueue.add(new Pair(key, counter.get(key))); // O(nlog(n))
            System.out.println(Arrays.toString(pairQueue.toArray()));
        }
        // set each element in result to the current head of the priority queue
        for (int i = 0; i < k; i++) {
            // pop and return the head, and get the string attribute
            res[i] = pairQueue.poll().str; // O(klog(n))
        }

        return res;
    }

    private String[] kMostFrequentStringsMinHeap(String[] strs, int k) {
        // 1. Init
        PriorityQueue<Pair> pairQueue = new PriorityQueue<Pair>(new Pair.MinHeapComparator());
        String[] res = new String[k];
        // create a hashmap that stores each string along with their frequencies in the list
        HashMap<String, Integer> counter = new HashMap<>();
        for (String str : strs) {
            counter.put(str, counter.getOrDefault(str, 0) + 1); // O(n)
        }

        // 2. Logic Impl
        for(String key : counter.keySet()){
            // add each key-value pair into the priority queue as a Pair objet
            pairQueue.add(new Pair(key, counter.get(key))); // O(nlogn)
            System.out.println(Arrays.toString(pairQueue.toArray()));
            // if the priority queue size is ever greater than k, remove the current head
            if(pairQueue.size() > k){
                pairQueue.remove(); // O((n - k)log(n)), reduces space complexity to O(k)
                System.out.println(Arrays.toString(pairQueue.toArray()));
            }
        }

        // fill the result array with the current head of the priority queue, we are going backwards as this was a minHeap
        for(int i = k-1; i >= 0; i--){
            res[i] = pairQueue.poll().str; // O(klogn)
        }

        return res;
    }

}
