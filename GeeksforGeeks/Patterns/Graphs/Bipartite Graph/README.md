# 📝 Bipartite Graph (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/bipartite-graph/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
DFS, Graph, BFS

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a Graph with  **V**  vertices (Numbered from  **0**  to  **V-1** ) and  **E**  edges. Check whether the graph is  **bipartite**  or not.

A **[bipartite graph](https://www.geeksforgeeks.org/what-is-bipartite-graph/)** can be colored with two colors such that  **no two**   **adjacent**   **vertices**  share the  **same color** . This means we can divide the graph’s vertices into two distinct sets where:

- All edges connect vertices from one set to vertices in the other set.

- No edges exist between vertices within the same set.

**Examples:**

```
Input: V = 3, edges[][] = [[0, 1], [1,2]]

Output: true
Explanation: The given graph can be colored in two colors so, it is a bipartite graph.

```

```
Input: V = 4, edges[][] = [[0, 3], [1, 2], [3, 2], [0, 2]]

Output: false 
Explanation: The given graph cannot be colored in two colors such that color of adjacent vertices differs. 
```

**Constraints:** 1 ≤ V ≤ 2 * 105
1 ≤ edges.size() ≤ 105
1 ≤ edges[i][j] ≤ 105