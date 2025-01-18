Greedy
======
- class of algorithms that make a series of decisions, where each decision is the best immediate choice given the options available

How does a greedy algorithm work?
---------------------------------
- follows the greedy choice property where the best overall solution to a problem (global optimum) can be arrived at by making the best possible decision at each step (local optimum)
- each decision is based only on the current context, and ignores its impact on future steps (continues until algorithm reaches a final solution)

Intuition
---------
- generally used for optimization problems, similar to Dynamic Programming (DP)
  -> main difference between the two approaches is that greedy only takes into account the best possible decision at each step while DP considers all possible solutions to find the global optimum
  -> generally, all greedy problems can be solved using DP, but not all DP problems can be solved using a greedy approach
- Reaching a Destination
- Resource Allocation

Real-world Usage
----------------
- Huffman coding in data compression ~ algorithm that assigns variable-length codes to input characters based on their frequencies, with most frequent characters getting the shortest codes

Example Problems
----------------
- Jump to the End (start at end and see if destination is reachable)
- Gas Stations (get net gas cost and stop at a deficit)
- Candies (left-pass & right-pass)