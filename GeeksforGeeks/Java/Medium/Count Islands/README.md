# 📝 Count Islands (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
DFS, Graph

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a grid of size  **n*m**  (n is the number of rows and m is the number of columns in the grid) consisting of  **'W'** s (Water) and  **'L'** s (Land). Find the number of islands.

 **Note:** An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

**Examples:**

```
Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], 
                ['W', 'L', 'W', 'W', 'L'], 
                ['L', 'W', 'W', 'L', 'L'], 
                ['W', 'W', 'W', 'W', 'W'], 
                ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.
 
```

```
Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], 
                ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Explanation:
The image below shows 2 islands in the grid.
 
```

**Constraints:** 
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}