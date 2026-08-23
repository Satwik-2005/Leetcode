# 📝 Minimum Spanning Tree (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Greedy, Graph

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a weighted, undirected, and connected graph with  **V**  vertices and a 2D array **edges[][]** , where each element edges[i] = [u, v, w] represents an edge between vertices **** u and v with weight w, return the sum of the weights of all edges in the graph's Minimum Spanning Tree (MST).

```
Input: V = 3, E = 3, Edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]
 
Output: 4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
```

```
Input: V = 2, E = 1, Edges = [[0 1 5]]

 

Output: 5 
Explanation: Only one Spanning Tree is possible which has a weight of 5.

```

**Constraints:** 2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges.