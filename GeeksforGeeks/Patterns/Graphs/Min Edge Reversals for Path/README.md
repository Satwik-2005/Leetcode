# 📝 Min Edge Reversals for Path (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/minimum-edges/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph, Deque

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a directed graph with  ****n****  vertices numbered from 1 to n. The graph is represented using a 2D array  ****edges[][]**** of size m, where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v. You are also given a source vertex  **src**  and a destination vertex  **dst** .

Find the minimum number of edges that need to be reversed so that there exists at least one path from src to dst.

If it is not possible to create a path from src to dst, return -1.

**Examples:**

```
Input: n = 3, edges[][] = [[1, 2], [3, 2]], src = 1, dst = 3
 
Output: 1
Explanation: Reverse the edge 3 -> 2.
```

```
Input: n = 4, edges[][] = [[1, 2], [2, 3], [3, 4]], src = 1, dst = 4
 
Output: 0
Explanation: One path already exists between 1 to 4 i.e. 1 -> 2 -> 3 -> 4.
```

**Constraints:** 
1 ≤ n, m ≤ 105
1 ≤ edges[i][0], edges[i][1] ≤ n
1 ≤ src, dst ≤ n