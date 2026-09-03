# 📝 Unique Paths in a Grid (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/unique-paths-in-a-grid--170647/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Matrix

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a grid  **grid[][]**  of size  **n**  ×  **m**  containing values 0 and 1 having the following meanings:

- 0 represents an open cell through which movement is allowed.

- 1 represents a blocked cell that cannot be traversed.

Starting from the top-left cell (0, 0), find the total number of distinct paths to reach the bottom-right cell (n - 1, m - 1). From any cell, movement is allowed only in the right and down directions, and a path is valid only if it passes through open cells.

**Note:**  It is guaranteed that the answer fits within a 32-bit integer.

**Examples:**

```
Input: grid[][] = {{0, 0, 0},{0, 1, 0},{0, 0, 0}}
Output: 2
Explanation: There are two distinct paths from (0, 0) to (2, 2) while avoiding the blocked cell.
 
```

```
Input: grid[][] = {{1, 0, 1}}
Output: 0
Explanation: There is no possible path to reach the end.

```

**Constraints:** 
1 ≤ n*m ≤ 106