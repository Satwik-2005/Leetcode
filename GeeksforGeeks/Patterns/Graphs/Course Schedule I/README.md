# 📝 Course Schedule I (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/course-schedule-i/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph, DFS, topological-sort, BFS

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given  **n**  courses numbered from 0 to n - 1 and a 2D array  **pre[][]** , where pre[i] = [u, v] indicates that course v must be completed before course u. Check whether it is possible to complete all the courses. Return true if possible; otherwise, return false.

**Examples:**

```
Input n = 4, pre[] = [[2, 0], [2, 1], [3, 2]]
Output: true
Explanation: 
To take course 2, you must first finish courses 0 and 1.
To take course 3, you must first finish course 2.
All courses can be completed, for example in the order [0, 1, 2, 3] or [1, 0, 2, 3].
```

```
Input: n = 3, pre[] = [[0, 1], [1, 2], [2, 0]]
Output: false
Explanation: 
To take course 0, you must first finish course 1. 
To take course 1, you must first finish course 2. 
To take course 2, you must first finish course 0.
Since each course depends on the other, it is impossible to complete all courses.
```

 **Constraints:** 
1 ≤ n ≤ 104
0 ≤ pre.size() ≤ 105
0 ≤ pre[i][0], pre[i][1] < n