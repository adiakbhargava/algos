Two Pointers
============
- refers to an algorithm that uses variables representing an index or position within a data structure
  -> typically used for arrays or linked lists
- can be used for making comparison between two elements in the data structure
- usually is used to replace scenarios where nested for-loops are used
  -> generally reduces time complexity to O(n)
- Take advantage of predictable dynamics that might exist within a data structure (i.e. a sorted array)
  -> nested loops typically don't utilize the unique properties of a data structure

Inward Traversal
----------------
- have pointers start at opposite ends o the data structure and move inward toward each other
- adjust their positions based on comparisons until a certain condition is met, or they cross each other
- ideal for problems that require comparing elements from different ends of a data structure

Unidirectional Traversal
------------------------
- both pointers start at the same end (usually the beginning of the data structure) and move in the same direction
- generally used when we want one pointer to find information (usually the right pointer)  and anothe rto keep track of information (usually the left pointer)

Staged Traversal
----------------
- traverse with one pointer until it lands onan element that meets a certain condition, then traverse with the second pointer
- first pointer is used as search and second pointer finds additional information concerning the value of the first pointer

Intuition
---------
- A two pointer algorithm usually requires a linear data structure (i.e. array or linked list)
- a good indication to use a two pointer algorithm is when the input follows a predictable dynamic (i.e. sorted array or palindromic string)
- if the problem asks for a pair of values or a result that can be generated from two values

Real-World Example
------------------
- garbage collection algorithms ~ scan pointer traverses heap to identify live objects, free pointer keeps track of next available space

Example Problems
----------------
- Pair Sum Ordered
- Triplet Sum (break it down into pair sum)
- Is Palindrome Valid
- Largest Container (start widest and narrow in)
- Shift Zeros
- Lexicographic Orders