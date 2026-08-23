# 📝 Geek in a Maze (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/geek-in-a-maze--170637/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a maze  **mat[][]**  of size **n × m** , where each cell is either:

- '.' representing an empty cell, or

- '#' representing an obstacle.

Find the number of distinct empty cells that Geek can visit starting from the cell **(r, c)** .

- Geek can move up, down, left, or right to an adjacent non-obstacle cell inside the maze.

- On any path, Geek can make at most  **u**  upward moves and  **d**  downward moves.

- There is no limit on the number of left or right moves.

- If the starting cell is an obstacle, return 0.

**Note**  :  There can be multiple paths starting from [r, c].

**Examples:**

```
Input: r = 1, c = 0, u = 1, d = 1, mat = [['.', '.', '.'], ['.', '#', '.'], ['#', '.', '.']]
Output: 5
Explanation: Geek starts from (1, 0) and follows the path (1,0)->(0,0)->(0,1)->(0,2)->(1,2). The cells (1,1) and (2,0) are obstacles, so they cannot be visited. Hence, Geek can visit 5 distinct empty cells.
 
```

```
Input: r = 2, c = 1, u = 2, d = 2, mat = [['.', '.', '.'], ['.', '#', '.'], ['.', '.', '.']]
Output: 8
Explanation: Geek starts from (2, 1) and follows the path (2,1)->(2,2)->(1,2)->(0,2)->(0,1)->(0,0)->(1,0)->(2,0). The cell (1,1) is an obstacle, so it cannot be visited. Hence, Geek can visit all 8 empty cells.

```

```
Input: r = 2, c = 1, u = 1, d = 0, mat = [['.', '.', '.'], ['.', '#', '.'], ['.', '.', '.']]
Output: 5
Explanation: The paths followed are (2, 1)->(2, 0)->(1, 0) and (2, 1)->(2, 2)->(1, 2)
```