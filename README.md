# CrackingAlgorithms
Solutions for my LeetCode challenging and Java practice. Sorted in different topics and add comments for easy understanding.

# Problems and Solutions

| # | Title | Topic | Solution | Basic idea|
|---| ----- | ----- | -------- | --------------------- |
| 21 | [merge-two-sorted-lists](https://leetcode.com/problems/merge-two-sorted-lists) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/merge-two-sorted-lists.java)| Maintain dummy head and tail to iteratively add smalled node to the end |
| 50 | [powx-n](https://leetcode.com/problems/powx-n) | Binary Search | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/powx-n.java)| Recursive `x^t = x^(t/2) * x^(t/2)` and be careful with `Interger.MIN_VALUE` |
| 74 | [search-a-2d-matrix](https://leetcode.com/problems/search-a-2d-matrix) | Binary Search | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/search-a-2d-matrix.java)| 2D array to 1D array, Binary Search |
| 86 | [partition-list](https://leetcode.com/problems/partition-list) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/partition-list.java)| Maintain two Dummy head and tail for small and large list, then concatenate |
| 100 | [same-tree](https://leetcode.com/problems/same-tree) | Tree | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/same-tree.java)| Recursive compare `left.left` & `right.left`, `left.right` & `right.right` to determine whether is same tree for each pair |
| 101 | [symmetric-tree](https://leetcode.com/problems/symmetric-tree) | Tree | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/symmetric-tree.java)| Recursive compare `left.left` & `right.right`, `left.right` & `right.left` to determine whether symmetric for each pair |
| 102 | [binary-tree-level-order-traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | BFS | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/BFS/binary-tree-level-order-traversal.java)| BFS, use list to store value on each level |
| 104 | [maximum-depth-of-binary-tree](https://leetcode.com/problems/maximum-depth-of-binary-tree) | Tree | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/maximum-depth-of-binary-tree.java)| Recursion to get max height from left and right child then increase by 1|
| 110 | [balanced-binary-tree](https://leetcode.com/problems/balanced-binary-tree) | Tree | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/balanced-binary-tree.java)| Pre-order traverse and compare left & right using `getHeight()` helper function |
| 141 | [linked-list-cycle](https://leetcode.com/problems/linked-list-cycle) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/linked-list-cycle.java)| Fast and slow pointer, cycle exists when two pointers meet |
| 143 | [reorder-list](https://leetcode.com/problems/reorder-list) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/reorder-list.java)| Find mid nodes -> Reverse second part -> Merge two parts |
| 155 | [min-stack](https://leetcode.com/problems/min-stack) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/min-stack.java)| Auxiliary sync stack to store min, push min when num <= min |
| 203 | [](https://leetcode.com/problems/remove-linked-list-elements) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Strucure/remove-linked-list-elements.java)| Dummy node, iteratively remove all target |
| 206 | [reverse-linked-list](https://leetcode.com/problems/reverse-linked-list) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/reverse-linked-list.java)| Iterative and Recursion |
| 509 | [fibonacci-number](https://leetcode.com/problems/fibonacci-number) | DP |[Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Dynamic_Programming/fibonacci-number.java)| 2-value Memoization `fibo(N) = fibo(N-2) + fibo(N-1)` |
| 700 | [search-in-a-binary-search-tree](https://leetcode.com/problems/search-in-a-binary-search-tree) | Tree | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/search-in-a-binary-search-tree.java)| Iterative and Recursive |
| 704 | [binary-search](https://leetcode.com/problems/binary-search) | Binary Search | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/binary-search.java)| Classical Binary Search |
| 785 | [](https://leetcode.com/problems/is-graph-bipartite) | BFS | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/BFS/is-graph-bipartite.java)|  |
| 876 | [middle-of-the-linked-list](https://leetcode.com/problems/middle-of-the-linked-list/) | Data Structure | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/middle-of-the-linked-list.java)| Fast & Slow two pointers |
| 958 | [check-completeness-of-a-binary-tree](https://leetcode.com/problems/check-completeness-of-a-binary-tree) | BFS | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/check-completeness-of-a-binary-tree.java)| BFS level order traversal, add one bool to indicate whether null found in the leftside |
| L11 | [search-range-in-binary-search-tree](https://www.lintcode.com/problem/search-range-in-binary-search-tree) | Tree | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/search-range-in-binary-search-tree.java)| inOrder traverse and check bound condition before recurse left or right |
| L14 | [first-position-of-target](https://lintcode.com/problem/first-position-of-target) | Binary Search | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/first-position-of-target.java)| Classical binary search + `right = mid` when found target to search left-side + post-processing |
| L458 | [last-position-of-target](https://lintcode.com/problem/last-position-of-target) | Binary Search | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/last-position-of-target.java)| Classical binary search + `left = mid` when found target to search right-side + post-processing |
| L459 | [closest-number-in-sorted-array](https://www.lintcode.com/problem/closest-number-in-sorted-array) | Binary Search | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Binary_Search/closest-number-in-sorted-array.java)| Classical binary search + post-processing to compare distance from left/right to target |
| L470 | [tweaked-identical-binary-tree](https://www.lintcode.com/problem/tweaked-identical-binary-tree) | Tree | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/tweaked-identical-binary-tree.java)| Recursion check whether is symmetric or same tree |