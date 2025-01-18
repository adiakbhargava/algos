Binary Search
=============
- is an algorithm that searches for a value in a sorted data set
- is centered around two main components: the left and right boundary variable
- often there is a lot of questions that rise on how to implement the algorithm, especially with the boundary variables:
  -> how should the boundary variables left and right be initalized?
  -> should we use left < rigth or left <= right as the exit condition in our while-loop?
  -> how should the boundary variables be updated? should we choose left = mid, left = mid + 1, right = mid, or right = mid - 1?
- any binary search implementation does the following:
  -> define the search space
  -> define the behavior inside the loop for narrowing the search space
  -> choose an exit condition for the while-loop
  -> return the correct value

1. Defining the search space
----------------------------
- encompasses all possible values that may include the value we're searching for

2. Narrowing the search space
-----------------------------
- involves progressively moving the left and right pointer inward until the search space is reduced to one element or none
  -> narrow search space toward teh left (by moving the right pointer inward)
  -> narrow the search space toward the right (by moving the left pointer inward)
- we decide whether to move the left or right based on the value in the middle of the search space, indicated by the midpoint variable (mid)
- the main question to ask at each iteration of binary search is: is the value being searched for to the left or the right of the midpoint?
- to narrow the search space toward the right, there are two options:
  -> left = mid + 1 (if the midpoint value is definitively not the value we're looking for and should be excluded from the search space)
  -> left = mid (if the midpoint value could potentially be the value we're looking for and should still be included in the search space)
  -> this idea applies for narrowing the search space to the left with the right boundary variable (mid - 1 vs. mid)
  -> mid = left + right / 2 (applies for python and java, may be different for different languages)
     'mid = left + (right -  left) / 2' (to lower the risk of integer overflow)

3. Choosing an exit condition
-----------------------------
- when choosing an exit condition, we will primarily choose between 'left < right' OR 'left <= right'
  -> for 'left < right', the while-loop will break when the left boundary and right boundary meet
     * we identify this exit condition as breaking the loop once the left and right boundaries converge to a single value
  -> for 'left <= right', the while-loop will break when the left boundary has surpassed the right boundary

4. Returning the correct value
------------------------------
- once the loop has broken, the final value is usually the answer we are looking for, assuming a valid answer exists

Time Complexity
---------------
- O(log(n)), where n is the number of values in the search space
- the time complexity is logarithmic as each iteration divides the search space in half until a single value is located, or no value is found

Intuition
---------
- binary search is typically applied for a sorted data set; however, there are instances for which we can derive a sorted dataset from a given, unsorted one (i.e. 'Cutting Wood' problem)

Real-World Usage
----------------
- transaction search in financial systems ~ data is typically stored in order, gets rid of need to search through entire database

Example Problems
----------------
- Find the Insertion Index (basic binary search problem)
- First and Last Occurrences of a Number (involves finding a lower and upper-bound for a number in a sorted data structure)
- Cutting Wood (based off of finding the upper-bound and reorganizing the data to act as an ordered set)
- Find the Target in a Rotated Sorted Array (uses binary search to identify ordered and unordered sections in a rotated input-array)
- Find the Median of Two Sorted Arrays (TO DO)
- Matrix Search (treat a 2D array as if it were a single array)
- Local Maxima in Array (identify slopes of points)
- Weighted Random Selection (requires prefix sum array)