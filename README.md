# CrackingAlgorithms
Solutions for my LeetCode challenging and Java practice.

# Problems & Solutions

| # | Title | Solution | Basic idea|
|---| ----- | -------- | --------------------- |
| 102 | [binary-tree-level-order-traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/BFS/binary-tree-level-order-traversal.java)| BFS, use list to store value to each value|
| 104 | [maximum-depth-of-binary-tree](https://leetcode.com/problems/maximum-depth-of-binary-tree) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/maximum-depth-of-binary-tree.java)| Recursion |
| 110 | [balanced-binary-tree](https://leetcode.com/problems/balanced-binary-tree) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/balanced-binary-tree.java)| Pre-order traverse and compare left & right using `getHeight()` helper function |
| 155 | [min-stack](https://leetcode.com/problems/min-stack) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/min-stack.java)| Auxiliary sync stack to store min, push min when num <= min |
| 876 | [middle-of-the-linked-list](https://leetcode.com/problems/middle-of-the-linked-list/) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Data_Structure/middle-of-the-linked-list.java)| Fast & Slow two pointers |
| 958 | [check-completeness-of-a-binary-tree](https://leetcode.com/problems/check-completeness-of-a-binary-tree) | [Java](https://github.com/zdong1995/CrackingAlgorithms/blob/master/Tree/check-completeness-of-a-binary-tree.java)| BFS level order traversal, add one bool to indicate whether null found in the leftside |