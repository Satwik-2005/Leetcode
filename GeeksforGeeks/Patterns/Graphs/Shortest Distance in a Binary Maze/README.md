# 📝 Shortest Distance in a Binary Maze (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Matrix, Graph, BFS

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a binary matrix  **mat[][]**  of size  **n × m**  containing values 0 and 1, and a source cell  **src[]**  and destination cell  **dest[]** , find the minimum number of steps required to reach the destination cell from the source cell. From any cell, you can move to its adjacent cells in the up, down, left, and right directions.

- 1 represents a traversable cell.

- 0 represents a blocked cell that cannot be visited.

If the destination cannot be reached from the source, return -1.

**Examples:**

```
Input: mat[][] = {{1, 1, 1, 1},{1, 1, 0, 1},{1, 1, 1, 1},{1, 1, 0, 0},{1, 0, 0, 1}}, src[] = {0, 1}, dest[] = {2, 2}
Output: 3
Explanation:From (0,1), the minimum number of steps to reach (2,2) is 3.
  
```

```
Input: mat[][] = {{1, 1, 1, 1, 1},{1, 1, 1, 1, 1},{1, 1, 1, 1, 0},{1, 0, 1, 0, 1}}, src[] = {0, 0}, dest[] = {3, 4}
Output:-1
Explanation:From (0,0), the destination (3,4) cannot be reached because all possible paths are blocked by 0 cells, so no valid route exists.
 
```

**Constraints:**

- 1 ≤ n, m ≤ 500

- grid[i][j] == 0 or grid[i][j] == 1

- The source and destination cells are always inside the given matrix.