package intervals;

import java.util.ArrayList;
import java.util.List;

public class IdentifyIntervalOverlaps {
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
        List<Interval> intervals1 = new ArrayList<>();
        List<Interval> intervals2 = new ArrayList<>();

        intervals1.add(new Interval(1,4));
        intervals1.add(new Interval(5,6));
        intervals1.add(new Interval(9,10));

        intervals2.add(new Interval(2,7));
        intervals2.add(new Interval(8,9));

        System.out.println("Interval List 1 :");
        for(Interval interval : intervals1){
            System.out.print(interval.toString() + " ");
        }
        System.out.println();

        System.out.println("Interval List 2 :");
        for(Interval interval : intervals2){
            System.out.print(interval.toString() + " ");
        }
        System.out.println();

        System.out.println("Overlapping List :");
        for(Interval interval : (new IdentifyIntervalOverlaps()).identifyAllIntervalOverlaps(intervals1, intervals2)){
            System.out.print(interval.toString() + " ");
        }
        System.out.println();
    }

    private List<Interval> identifyAllIntervalOverlaps(List<Interval> intervals1, List<Interval> intervals2){
        List<Interval> overlaps = new ArrayList<>();
        int i = 0;
        int j = 0;
        Interval a;
        Interval b;
        while(i < intervals1.size() && j < intervals2.size()){
            if(intervals1.get(i).start <= intervals2.get(j).start){
                a = intervals1.get(i);
                b = intervals2.get(j);
            } else{
                a = intervals2.get(j);
                b = intervals1.get(i);
            }

            if(a.end >= b.start){
                overlaps.add(new Interval(b.start, Math.min(a.end,b.end)));
            }

            if(intervals1.get(i).end < intervals2.get(j).end){
                i += 1;
            } else{
                j += 1;
            }
        }

        return overlaps;
    }
}
