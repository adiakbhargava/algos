Linked Lists
============
- is a data structure consisting of a sequence of nodes, where each node is linked to teh next.
- consists of two main components: the data it stores (val) and a reference to the next node (next) in the sequence
- very useful in scenarios that require frequent insertions and deletions as these operations can be performed more efficiently than arrays
  -> they don't need to shift elements to perform an insertion or deletion
- properties:
  -> has dynamic sizing capabilities (can grow and shrink)
  -> usually has a head node for the beginning of the list (can also have a tail node for the end of the list if it is a doubly linked list)
  -> need to traverse through list starting at the head node in order to access other nodes in the list
     * inability to perform random access (can't be accessed by indexes such as in an array)

Singly Linked List
------------------
- simplest form of a linked list
- each node points to the next node in the list
- last node points to nothing (indicates end of list)

Doubly Linked List
------------------
- an extended version of a linked list where each node contains two references: one to the next node (next), and one to the previous node (prev).
  -> in most implementations, they have immediate access to both the head and tail node
- allows for bidirectional traversal
- deleting nodes is more straightforwards as there are references for both the next and previous nodes

Intuition
---------
- many of these problems require traversing or restructuring a linked list
- it is helpful to visualize the list with the pointers representing arrows that point from one node to another

Real-World Usage
----------------
- music playlists (enables efficient addition, removal, and reordering of songs)

Example Problems
----------------
- Linked List Reversal (involves keeping track of a previous, current, and next pointer) ~ recursive implementation also exists
- Remove the Kth Last Node From a Linked List (requires two pointers to be k+1 distance from eachother)
- Linked List Intersection (can be done with a HashSet or by visualising lists as one singly linked list)
- LRU Cache (based off a doubly linked list)
- Palindromic Linked List (may require manipulation of input or creation of copy linked list)
- Flatten a Multi-Level Linked List (involves two pointers: one for tracking the end of list and one for traversal)