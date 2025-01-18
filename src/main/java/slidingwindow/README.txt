Sliding Window
==============
- is a subset of the two-pointer pattern
  -> uses two pointers (left and right) to define the bounds of a 'window' in iterable data structures such as arrays
  -> the window defines the subcomponent of the data structure (i.e. a subarray or substring)
- slides across the data structure unidirectionally (one direction) as it searches for a subcomponent that meets a certain requirement
- particularly useful in scenarios where algorithms might otherwise rely on using two nested loops to search through all possible subcomponents to find an answer (resulting in O(n^2) or worse)
- typically operates in O(n) time
- has three main functions:
  -> expand -- advance the right pointer
  -> shrink -- advance the left pointer
  -> slide -- advance both the left and right pointers (expanding and shrinking window at the same time)

Fixed Sliding Window
--------------------
- maintains a specific length as it slides across a data structure
- used when the problem asks us to find a subcomponent of a certain length

Dynamic Sliding Window
----------------------
- can expand and shrink in length as they traverse a data structure
- can be applied to problems that ask us to find the longest or shortest subcomponent that satisfies a condition
  -> when finding the longest subcomponent, the dynamics of expanding and shrinking are typically as follows:
     1. If a window satisfies the condition, expand it to see if we can find a longer window that also meets the condition
     2. If the condition is violated, shirnk the window until the condition is met again

Intuition
---------
- we can apply sliding windows for finding subcomponents in a larger data structure
- a fixed sliding window can be applied when we are specified the length of the subcomponent
- a dynamic sliding window can be applied when we are looking for the longest or shortest subcomponent within a data structure

Real-World Usage
----------------
- buffering in video streaming ~ manage buffering and ensure smooth playback
  -> when streaming a video, the player downloads chunks of the video data and stores them in a buffer
  -> a sliding window controls which part of the video is buffered, with teh window 'sliding' forward as the video plays
  -> ensures the video player can adapt to varying network conditions by dynamically adjusting the buffer size and position, leading to a smoother streaming experience

Example Problems
----------------
- Substring Anagrams (use a fixed sliding window and compare frequencies of characters in window to that of the anagram)
- Longest Substring With Unique Characters (use a dynamic sliding window with a hashmap that keeps tracks of previous indexes of elements in the window)
- Longest Uniform Substring After Replacements (use a dynamic sliding window along with hashmaps that keeps tracks of frequency of characters in the window)