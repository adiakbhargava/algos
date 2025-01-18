stacks
======
- similar to a stack of plates, you can only add a new plate to the top of the stack, and when you need a plate, you take the one from the top
- Last In, First Out (LIFO)
  -> key applications :
     1. handling nested structures (i.e. nested parentheses in a string)
     2. reverse order
     3. substitute for recursion (recursion already involves a recursive call stack)
     4. monotonic stacks (maintain elements in a consistent, increasing or decreasing sorted order)
- adding a plate from the top of the stack, physically demonstrates the two main stack operations:
  -> push (adds an element to the top of the stack)
  -> pop (removes and returns the element at the top of the stack)
- push, pop, peek, and isEmpty operations have a worst case time complexity of O(1)

Intuition
---------
- Useful for operations concerning nested structures or processing duplicates

Real-World Usage
----------------
- function call management ~ function states (including parameters, local variables, and the return address) are pushed onto a call stack when called

Example Problems
----------------
- Valid Paranthesis Expression (use stack for open brackets)
- Evaluate Expression (evaluate digits and use stack for expressions within parentheses)
- Maximums of Sliding Window (TO DO)
- Next Largest Number to the Right (start at rightmost element, and use stack for potential candidates)
- Repeated Removal of Adjacent Duplicates (stack to add unique elements, remove if top of stack matches with currently traversed element)
- Implement a Queue Using stacks (TO DO)