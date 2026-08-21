# 📝 Shortest Path with at most k Nodes (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/shortest-path-with-at-most-k-nodes/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph, Shortest Path, BFS, Queue

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a weighted directed graph of  **n**  vertices represented by a 2D array  **edges[][]** , where each element edges[i] = {u, v, w} denotes a directed edge from vertex **** u to vertex v with cost w, and three integers  **src** ,  **dst** , and  **k** .
Find the minimum cost to travel from src to dst using a path containing at most k nodes. If no such path exists, return -1.

**Note** : The cost from city A to B may be different from the price from city B to A.

**Example:**

```
Input: n = 6, edges[][] = [[0, 1, 10], [1, 2, 20], [1, 3, 10], [2, 5, 30], [3, 4, 10], [4, 5, 10]], src = 0, dst = 5, k = 2
Output: 60
Explanation: There can be a route marked with a red arrow that takes cost =  10+10+10+10 = 40 using three nodes. And route marked with green arrow takes cost = 10+20+30=60 using two nodes. Since there can be at most 2 nodes, the answer will be 60.
             
```

```
Input: n = 3, edges[][] = [[0, 1, 10], [0, 2, 50], [1, 2, 10]], src = 0, dst = 2, k = 1
Output: 20
Explanation: Since k is 1, the the green-colored path can be taken with a minimum cost of 20.
                   

```

**Constraint:** 
1 ≤ n ≤ 100
1 ≤ cost ≤ 104
0 ≤ src, dst, k < n