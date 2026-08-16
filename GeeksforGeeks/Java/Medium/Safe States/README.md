# 📝 Safe States (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/eventual-safe-states/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
DFS, Graph, BFS

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a directed graph with  **V**  vertices numbered from 0 to V-1 and  **E**  directed edges, represented as a 2D array  **edges[][]** , where edges[i] = [u, v] represents a directed edge from vertex u to vertex v.

A vertex with no outgoing edges is called a terminal node. A vertex is considered safe if every possible path starting from that vertex eventually reaches a terminal node.

Return all the safe nodes of the graph.

**Examples:**

```
Input: V = 5, E = 6, edges[][] = [[1, 0], [1, 2], [1, 3], [1, 4], [2, 3], [3, 4]]

Output: [0, 1, 2, 3, 4]
Explanation: Nodes 0 and 4 have no outgoing edges, so they are terminal nodes. All paths starting from nodes 1, 2, and 3 eventually reach terminal node 4. Therefore, all nodes are safe.
```

```
Input: V = 4, E = 3, edges[][] = [[1, 2], [2, 3], [3, 2]]

Output: [0]
Explanation: Node 0 is a terminal node. Nodes 2 and 3 form a cycle, so they are not safe. Node 1 leads to the cycle, making it unsafe. Hence, only node 0 is a safe node.
```

**Constraints:** 1 ≤ V ≤ 105
0 ≤ E ≤ 105
0 ≤ edges[i][0], edges[i][1] < V