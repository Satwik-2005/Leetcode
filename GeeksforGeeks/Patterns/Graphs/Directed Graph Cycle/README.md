# 📝 Directed Graph Cycle (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a directed graph with  **V**  vertices numbered from 0 to V - 1 and E directed edges. The graph is represented using a 2D array  **edges[][]**  of size E, where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v.

Check whether the graph contains any cycle. Return true if there exists at least one cycle in the graph; otherwise, return false.

**Examples:**

```
Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]

Output: true
Explanation: The diagram clearly shows a cycle 0 -> 1 -> 2 -> 0
```

```
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]

Output: false
Explanation: no cycle in the graph
```

**Constraints:** 
1 ≤ V ≤ 105
0 ≤ E ≤ 105
0 ≤ edges[i][0], edges[i][1] < V