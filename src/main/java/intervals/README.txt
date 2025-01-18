Intervals
=========
- consists of two values: a start point and an end point
  -> start point indicates where an interval begins
  -> end point indicates where an interval ends
- represents a continuous segment on the number line that includes all values between these two points
- often used to represent a line, time period, or a continuous range of values
- can be closed, open, or half-open (make sure to clarify with the interviewer what kind of interval we are dealing with)
  -> closed : both the start and end points are included in the interval
  -> open : both the start and end points are not included in the interval
  -> half-open : either the start or end point is included, while the other is not

Overlapping intervals
---------------------
- two intervals overlap if they share at least one common value
- it's important to understand how the overlapping of the intervals influences the desired outcome of the problem

Sorting intervals
-----------------
- sorting intervals before solving the problem is quite helpful since it allows them to be processed in a certain order
- intervals are typically sorted by their start point, so they can be traversed in chronological order
  -> if two or more intervals have the same start point, we may also need to consider each interval's end point

Separating start and end points
-------------------------------
- may be beneficial to process the start and end points of intervals separately (create two sorted arrays, one for start points and one for end points)

Real-world usage
----------------
- scheduling systems ~ bookings often use intervals

Example problems
----------------
- Merge Overlapping Intervals (sort intervals)
- Identity All Interval Overlaps (determine which intervals started first and which will end first)
- Largest Overlap of Intervals (separate start and end points)