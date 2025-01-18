package intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestOverlapIntervals {
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

    static class Pair{
        private int val;
        private char symbol;
        Pair(int val, char symbol){
            this.val = val;
            this.symbol = symbol;
        }

        int getVal(){
            return val;
        }

        char getSymbol(){
            return symbol;
        }
    }
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(4,8));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(5,7));
        System.out.println("Interval List : "  + intervals);
        System.out.println("Max Number of Overlapping Intervals : " + (new LargestOverlapIntervals()).getLargestOverlap(intervals));
    }

    private int getLargestOverlap(List<Interval> intervals){
        List<Pair> points = new ArrayList<>();
        for(Interval interval : intervals){
            points.add(new Pair(interval.start, 'S'));
            points.add(new Pair(interval.end, 'E'));
        }

        Collections.sort(points, Comparator.comparing(Pair::getVal)
                .thenComparing(Pair::getSymbol));
        int numActiveIntervals = 0;
        int maxOverlaps = 0;
        for(int i = 0; i < points.size(); i++){
            if(points.get(i).symbol == 'S'){
                numActiveIntervals += 1;
            } else{
                numActiveIntervals -= 1;
            }
            maxOverlaps = Math.max(maxOverlaps, numActiveIntervals);
        }

        return maxOverlaps;
    }
}
