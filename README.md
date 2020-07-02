# CrackingAlgorithms
Solutions for my LeetCode challenging and Java practice. Summarized to different topics

## Data Structure

| # | Title | Solution | Basic idea|
|---| ----- | -------- | --------------------- |
| 21 | [merge-two-sorted-lists](https://leetcode.com/problems/merge-two-sorted-lists) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/merge-two-sorted-lists.java)| Maintain dummy head and tail to iteratively add smalled node to the end |
| 86 | [partition-list](https://leetcode.com/problems/partition-list) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/partition-list.java)| Maintain two Dummy head and tail for small and large list, then concatenate |
| 141 | [linked-list-cycle](https://leetcode.com/problems/linked-list-cycle) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/linked-list-cycle.java)| Fast and slow pointer, cycle exists when two pointers meet |
| 155 | [min-stack](https://leetcode.com/problems/min-stack) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/min-stack.java)| Auxiliary sync stack to store min, push min when num <= min |
| 206 | [reverse-linked-list](https://leetcode.com/problems/reverse-linked-list) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/reverse-linked-list.java)| Iterative |
| 876 | [middle-of-the-linked-list](https://leetcode.com/problems/middle-of-the-linked-list/) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/middle-of-the-linked-list.java)| Fast & Slow two pointers |
| 958 | [check-completeness-of-a-binary-tree](https://leetcode.com/problems/check-completeness-of-a-binary-tree) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/check-completeness-of-a-binary-tree.java)| BFS level order traversal, add one bool to indicate whether null found in the leftside |

## Binary Search

| # | Title | Solution | Basic idea|
|---| ----- | -------- | --------------------- |
| 74 | [search-a-2d-matrix](https://leetcode.com/problems/search-a-2d-matrix) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/search-a-2d-matrix.java)| 2D array to 1D array, Binary Search |
| 704 | [binary-search](https://leetcode.com/problems/binary-search) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/binary-search.java)| Classical Binary Search |

## Tree

| # | Title | Solution | Basic idea|
|---| ----- | -------- | --------------------- |
| 104 | [maximum-depth-of-binary-tree](https://leetcode.com/problems/maximum-depth-of-binary-tree) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/maximum-depth-of-binary-tree.java)| Recursion |
| 110 | [balanced-binary-tree](https://leetcode.com/problems/balanced-binary-tree) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/balanced-binary-tree.java)| Pre-order traverse and compare left & right using `getHeight()` helper function |

## BFS

| # | Title | Solution | Basic idea|
|---| ----- | -------- | --------------------- |
| 102 | [binary-tree-level-order-traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/BFS/binary-tree-level-order-traversal.java)| BFS, use list to store value on each level |