# 📝 542. 01 Matrix (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/01-matrix/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Array, Dynamic Programming, Breadth-First Search, Matrix

### 🚀 Performance
- **Runtime:** 14 ms
- **Memory:** 49.9 MB

---

### 📜 Problem Description

Given an  `m x n`  binary matrix  `mat` , return  *the distance of the nearest*  `0`  *for each cell* .

The distance between two cells sharing a common edge is  `1` .

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2021/04/24/01-1-grid.jpg) 

```
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

```

**Example 2:**

 ![image](https://assets.leetcode.com/uploads/2021/04/24/01-2-grid.jpg) 

```
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

```

**Constraints:**

	
- `m == mat.length`
	
- `n == mat[i].length`
	
- `1 <= m, n <= 104`
	
- `1 <= m * n <= 104`
	
- `mat[i][j]`  is either  `0`  or  `1` .
	
- There is at least one  `0`  in  `mat` .

**Note:**  This question is the same as 1765:  [https://leetcode.com/problems/map-of-highest-peak/](https://leetcode.com/problems/map-of-highest-peak/description/)