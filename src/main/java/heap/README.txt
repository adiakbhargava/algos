Heap
====
- organizes elements based on priority, ensuring the highest-priority element is always at the top of the heap
- efficient prioritization is possible due to how heaps are structured: a heap is essentially a binary tree

Min-heap
--------
- prioritizes the smallest element by keeping it at the top of the heap
- each node's value is less than or equal to that of its children (root of tree or top of heap is always the smallest element)

Max-heap
--------
- prioritizes the largest element by keeping it at the top of the heap
- each node's value is greater than or equal to that of its children (root of tree or rop of heap is always largest element)

Common heap operations
----------------------
- insert ~ adds an element to the heap, ensuring the binary tree remains correctly ordered : O(log(n))
- deletion ~ removes the element at the top of the heap, then restructures the heap to replace the top element : O(log(n))
- peek ~ retrieves the top element of the heap without removing it : O(1)
- heapify ~ transforms an unsorted list of values into a heap : O(n)

Priority Queue
--------------
- a special type of heap that follows the structure of min-heaps or max-heaps but allows customization in how elements are prioritizes (i.e prioritizing strings with a higher number of vowels)

Real-world Usage
----------------
- managing tasks in operating systems ~ manage the execution of tasks (processes may be assigned a priority level)

Example Problems
----------------
- K Most Frequent Strings (use a max-heap for the distinct elements, can be optimized with a min-heap)
- Combine Sorted Linked Lists (create a dummy node and current node for traversal)
- Sort a K-Sorted Array (use min-heap)
- Median of an Integer Stream (use max-heap for left half of integer stream, use a min-heap for right half)