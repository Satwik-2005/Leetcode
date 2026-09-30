# 📝 Ways to Reach Origin (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/paths-to-reach-origin3850/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Arrays, Dynamic Programming, Matrix

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Geek is standing at a point  **(x, y)**  on a 2D grid and wants to reach the origin (0, 0).

From any point, Geek can move in only two directions: left, from (x, y) to (x - 1, y), or down, from (x, y) to (x, y - 1).

Find the total number of distinct paths for Geek to reach (0, 0) from (x, y). Since the answer can be very large, return it modulo 109+7.

**Examples:**

```
Input: x = 3, y = 0
Output: 1
Explanation: The only possible path is (3, 0) -> (2, 0) -> (1, 0) -> (0, 0), since y = 0, there is no option to move down at any step.
```

```
Input: x = 3, y = 6
Output: 84
Explanation: There are a total of 84 distinct paths from (3, 6) to (0, 0) using only left and down moves.
```