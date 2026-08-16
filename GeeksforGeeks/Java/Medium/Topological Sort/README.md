# 📝 Topological Sort (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/topological-sort/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph, topological-sort

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a Directed Acyclic Graph (DAG) with  **V** vertices numbered from 0 to V - 1 and  **E** directed edges represented by a 2D array  **edges[][]** , where edges[i] = [u, v] denotes a directed edge from vertex u to vertex v, return a topological ordering of all the vertices.

A topological ordering is a linear ordering of the vertices such that for every directed edge u -> v, vertex u appears before vertex v in the ordering.

**Note:** As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

**Examples:**

```
Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
```

```
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
```

**Constraints:** 
2  ≤  V  ≤  5 x 103
1  ≤  E = edges.size()  ≤  min[105, (V * (V - 1)) / 2]
0 ≤ edges[i][0], edges[i][1] < V