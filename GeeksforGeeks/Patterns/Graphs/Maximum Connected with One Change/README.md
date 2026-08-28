# 📝 Maximum Connected with One Change (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/maximum-connected-group/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
BFS, Graph, DFS

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

You are given a square binary grid. A grid is considered binary if every value in the grid is either  **1 or 0.** You can change at most one cell in the grid from  **0 to 1** . You need to find the largest group of connected   **1's** . Two cells are said to be connected if both are adjacent(top, bottom, left, right) to each other and both have the same value.

**Examples :**

```
Input: grid[][] = [[1, 1], [0, 1]]

Output: 4
Explanation: By changing the only 0 to 1, all the 1s become connected, resulting in a connected group of size 4.
 
```

```
Input: grid[][] = [[1, 0, 1], [1, 0, 1], [1, 0, 1]]

Output: 7
Explanation: By changing any 0 in the middle column to 1, the two connected groups merge into a single connected group of size 7.

```

**Constraints:** 
1 ≤ grid.size() ≤ 500
0 ≤ grid[i][j] ≤ 1