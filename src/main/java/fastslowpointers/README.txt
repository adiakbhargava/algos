Fast and Slow Pointers
======================
- a specialized variant of the two-pointer pattern
- characterized by the differing speeds at which two pointers traverse a data structure
- designates a fast and slow pointer
  -> fast pointer usually moves two steps in each iteration
  -> slow pointer usually moves one step in each iteration
  -> based off this, fast pointer moves at twice the speed of the slow pointer
     * both pointers can move at varying speeds as long as fast pointer has a greater step size than the slow pointer

Intuition
---------
- particularly beneficial for data structures such as linked lists where index based access isn't available
- helpful for detecting cycles in a data structure, fractional point identification, or sequence analysis (happy numbers)

Real-World Usage
----------------
- detecting cycles in symlinks ~ shortcuts that point to files or directories in a file system

Example Problems
----------------
- Linked List Loop (iterate through list until fast pointer crosses slow pointer or reaches end of list)
- Linked List Midpoint (utilize the fact the fast pointer moves twice the speed of the slow pointer)
- Happy Number (similar logic to linked list loop applied to numbers)