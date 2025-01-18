package intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    static class Interval{
        private int start;
        private int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "[" + start + "," + end + "]";
        }
    }
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(3,4));
        intervals.add(new Interval(7,8));
        intervals.add(new Interval(2,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(1,4));

        System.out.println("Original List :");
        for(Interval interval : intervals){
            System.out.print(interval.toString() + " ");
        }
        System.out.println();

        List<Interval> merged = (new MergeOverlappingIntervals()).mergeOverlappingIntervals(intervals);
        System.out.println("Merged List :");
        for(Interval interval : merged){
            System.out.print(interval.toString() + " ");
        }
        System.out.println();
    }

    private List<Interval> mergeOverlappingIntervals(List<Interval> intervals){
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        List<Interval> merged = new ArrayList<>();
        merged.add(intervals.get(0));

        int mergedTracker = 0;
        for(int i = 1; i < intervals.size(); i++){
            Interval a = merged.get(mergedTracker);
            Interval b = intervals.get(i);

            if(a.end < b.start){
                merged.add(b);
                mergedTracker += 1;
            } else{
                merged.set(mergedTracker, new Interval(a.start, Math.max(a.end, b.end)));
            }
        }

        return merged;
    }
}
