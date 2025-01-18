package heap;

import java.util.PriorityQueue;

public class MedianOfIntegerStream {
    // min-heap
    private PriorityQueue<Integer> leftHalfHeap;
    // max-heap (numbers will be intrisically negative in the heap and will be negated again when in use so that the values don't change)
    private PriorityQueue<Integer> rightHalfHeap;
    public MedianOfIntegerStream(){
        leftHalfHeap = new PriorityQueue<>();
        rightHalfHeap = new PriorityQueue<>();
    }

    private void add(int num){
        // we add an element to the left half heap if it is empty or the number is less than the largest value (which would be in the head)
        if(leftHalfHeap.isEmpty() || num <= -1*leftHalfHeap.peek()){
            leftHalfHeap.add(-1*num);
            // if the size of the left half of the heap is greater than the right half of the heap by more than 1, we transfer the head of the left half to the right half
            if(leftHalfHeap.size() > rightHalfHeap.size() + 1){
                rightHalfHeap.add(-1*leftHalfHeap.poll());
            }
        } else {
            // if the number is greater than the head of the left half of the heap, we add it to the right half of the heap
            rightHalfHeap.add(num);
            // if the right half of the heap is greater than the left half, we move the head of the right half of the heap to the left half
            if(leftHalfHeap.size() < rightHalfHeap.size()){
                leftHalfHeap.add(-1*rightHalfHeap.poll());
            }
        }
    }

    private double getMedian(){
        if(leftHalfHeap.size() == rightHalfHeap.size()){
            return (-1*leftHalfHeap.peek() + rightHalfHeap.peek()) / 2.0;
        }

        return -1*leftHalfHeap.peek();
    }
    public static void main(String[] args) {
        MedianOfIntegerStream obj = new MedianOfIntegerStream();
        obj.add(3);
        obj.add(6);
        System.out.println("Median : " + obj.getMedian());
        obj.add(1);
        System.out.println("Median : " + obj.getMedian());
    }


}
