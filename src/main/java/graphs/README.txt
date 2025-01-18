Graphs
======
- a data structure composed of nodes (vertices) connected by edges
- used to model relationships (edges define relationships)

Terminology
-----------
Adjacent node/neighbor ~ two nodes are adjacent if there's an edge connecting them
Degree ~ the number of edges connected to a node
Path ~ a sequence of nodes connected by edges

Attributes
----------
Directed vs. undirected ~ in a directed graph, edges have a direction associated with them
Weighted vs. unweighted ~ in a weighted graph, edges have a weight associated with them (i.e. distance or cost)
Cyclic vs. acyclic ~ a cyclic graph contains at least one cycle, which is a path that starts and ends at the same node

Representations
---------------
- you may not be given the graph directly
  -> for these situations, it's usually necessary to create your own representation of the graph
  -> these representations are commonly an adjacency list or an adjacency matrix
- adjacency lists have the neighbors of each node stored as a list
  -> can be implemented using a hashmap where the key represents the node, and its corresponding value represents the list of that node's neighbors
  -> most preferred choice of implementation
  -> commonly used when representing sparse graphs and when we need to iterate over all th neighbors of a node efficiently
- adjacency matrices have graph represented as a 2D matrix where matrix[i][j] indicates an edge between nodes i and j
  -> generally used when representing dense graphs
  -> frequent checks are needed for the existence of specific edges

Traversals
----------
- primary graph traversal techniques are DFS and BFS
  -> DFS is typically implemented recursively
  -> BFS is typically implemented iteratively
  -> both have a time complexity of O(n + e), where n denotes the number of nodes and e denotes the number of edges
  -> both have a space complexity of O(n), for dfs, space is taken up by the recursive call stack, and for BFS, space is taken up by the queue
- may be necessary to keep track of visited nodes when traversing a graph (can use a hash set to ensure each node is only visited once)

Real-world Usage
----------------
- Social networks ~ users of social media sites are typically represented as nodes, and connections or friendships between users are represented as edges
  -> allows platforms to analyze relationships, suggest new connections, and identify groups or communities within their networks

Example Problems
----------------
- Prerequisite Courses (Topological sort - Kahn's Algorithm)
- Count Islands (perform dfs for each bit of land on the island)
- Graph Deep Copy (dfs)
- Matrix Infection (similar to count islands but bfs)
- Bipartite Graph Validation (apply dfs)
- Longest Increasing Path (dfs)
- Shortest Transformation Sequence (TO DO)
- Shortest Path (TO DO)
- Merging communities (TO DO)
- Connect the Dots (TO DO)
