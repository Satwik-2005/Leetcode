# 📝 Maximum path sum in matrix (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/path-in-matrix3805/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Matrix

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

You are given a matrix  `**mat[][]**`  of size  `**n** x  **m**`  where each element is a positive integer. Starting from any cell in the first row, you are allowed to move to the next row, but with specific movement constraints. From any cell  `(r, c)`  in the current row, you can move to any of the three possible positions :

1. `(r+1, c-1)`  — move diagonally to the left.

2. `(r+1, c)`  — move directly down.

3. `(r+1, c+1)`  — move diagonally to the right.

Find the maximum sum of any path starting from any column in the first row and ending at any column in the last row, following the above movement constraints.

**Examples :**

```
Input: mat[][] = [[3, 6, 1], [2, 3, 4], [5, 5, 1]]
Output: 15
Explaination: The best path is (0, 1) -> (1, 2) -> (2, 1). It gives the maximum sum as 15.
```

```
Input: mat[][] = [[2, 1, 1], [1, 2, 2]]
Output: 4
Explaination: The best path is (0, 0) -> (1, 1). It gives the maximum sum as 4.
```

```
Input: mat[][] = [[25]]
Output: 25
Explaination: (0, 0) is the only cell in mat[][], so maximum path sum will be 25.
```

**Constraints:** 
1 ≤ mat.size() ≤ 500
1 ≤ mat[i].size() ≤ 500
1 ≤ mat[i][j] ≤ 1000