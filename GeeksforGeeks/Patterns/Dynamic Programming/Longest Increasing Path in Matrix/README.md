# 📝 Longest Increasing Path in Matrix (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/longest-increasing-path-in-a-matrix/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a matrix with  **n**  rows and  **m** columns. Your task is to find the length of the longest path in with the following constraints

- The values in path strictly increasing.  For example if a path of length k has values a1, a2, a3, .... ak  , then for every i from [2, k] this condition must hold ai > ai-1.

- No cell should be revisited in the path.

- From each cell,  you can move in any of of the four directions: left, right, up, or down.

- You are not allowed to move diagonally or move outside the boundary.

**Examples**  **:**

```
Input: n = 3, m = 3, matrix[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: 5
Explanation: One such path is 1 -> 2 -> 3 -> 6 -> 9, where each number is strictly greater than the previous.

```

```
Input: n = 3, m = 3, matrix[][] = [[3, 4, 5], [6, 2, 6], [2, 2, 1]]
Output: 4
Explanation: One of the longest increasing paths is 3 -> 4 -> 5 -> 6.

```