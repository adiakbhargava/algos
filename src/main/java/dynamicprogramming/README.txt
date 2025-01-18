Dynamic Programming
===================
- some problems can be broken down into subproblems, where each subproblem is a smaller version of the main problem
  -> these subproblems can be broken down into more subproblems as well
  -> this concept is similar to the idea of recursion except recursion entails generating and solving the same subproblem multiple times making it unnecessarily expensive
- a technique that stores solutions to each subproblem, so they can be reused when they're needed again
  -> ensures each subproblem is solved at most one time

Key DP terms
------------
- Optimal substructure ~ the optimal solution to a problem can be constructed from the optimal solutions to its subproblems
- Overlapping subproblems ~ if the same problem is solved multiple times during the problem-solving process
- Recurrence relation ~ a formula that expresses the solution to the problem in terms of the solutions to its subproblems
- Base cases ~ the simplest instances of the problem where the solution is already known, without needing to be decomposed into more subproblems

- the first two terms are essential attributes that a problem must have to be solvable using DP
- the last two terms are essential components in every DP solution

Real-world Usage
----------------
- Word segmentation ~ search engines use DP in a process called 'word segmentation'

Example Problems
----------------
- Climbing Stairs ()