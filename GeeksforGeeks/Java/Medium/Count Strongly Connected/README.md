# 📝 Count Strongly Connected (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a Directed Graph with  **V**  vertices (Numbered from 0 to V-1) and  **E**  edges. The graph is represented as a 2D vector  **edges[][]** , where each entry edges[i] = [u, v] denotes a direct edge from vertex u to v. Find the number of strongly connected components in the graph.

**Examples:**

```
Input: V = 5, E = 5, edges[][] = [[0, 2], [0, 3], [1, 0], [2, 1], [3, 4]]

Output: 3
Explanation: We can clearly see that there are 3 Strongly Connected Components in the Graph.
 
```

```
Input: V = 3, E = 3, edges[][] = [[0, 1], [1, 2], [2, 0]]

Output: 1
Explanation: All of the nodes are connected to each other. So, there's only one SCC.

```

```
Input: V = 2, E = 1, edges[][] = [[0, 1]]
Output: 2
```

**Constraints:** 1 ≤ V ≤ 106
0 ≤ E ≤ 106
0 ≤ edges[i][0], edges[i][1] < V