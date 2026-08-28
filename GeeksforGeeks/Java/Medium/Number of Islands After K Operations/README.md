# 📝 Number of Islands After K Operations (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/number-of-islands/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
union-find

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a grid of  **n**  rows and **m**  columns. Initially, all cells of the grid contain 0, where 0 represents water. You are also given a 2D array  **operators[][]** , where each operator **** contains two integers representing the row and column of a cell. Each operation converts the specified water cell into land by changing its value from 0 to 1.

After each operation, find the number of islands present in the grid.

An island is a group of one or more land cells (or 1s) that are connected through their top, bottom, left, or right sides. Cells connected only diagonally are not considered part of the same island. Return an array containing the number of islands after each operation.

**Examples:**

```
Input: n = 4, m = 5, k = 4, operators[][]= [[1,1],[0,1],[3,3],[3,4]]
Output: [1, 1, 2, 2]
Explanation: Initially, all cells contain 0, so there are no islands.
- After operation 1, cell (1,1) becomes land. It forms one island, so the count is 1.
- After operation 2, cell (0,1) becomes land. It is connected to the land cell at (1,1), so both cells form one island. The count remains 1.
- After operation 3, cell (3,3) becomes land. It is not connected to the existing island, so a new island is formed. The count becomes 2.
- After operation 4, cell (3,4) becomes land. It is connected to (3,3), so both cells form one island. The total count remains 2.
Therefore, the number of islands after each operation is [1, 1, 2, 2].

```

```
Input: n = 4, m = 5, k = 4, operators[][] = [[0,0],[1,1],[2,2],[3,3]]
Output: [1, 2, 3, 4]
Explanation: Initially, all cells contain 0, so there are no islands.
- After operation 1, cell (0,0) becomes land. It forms one island, so the count is 1.
- After operation 2, cell (1,1) becomes land. It is diagonally connected to (0,0), but diagonal cells are not considered connected. Therefore, it forms a new island and the count becomes 2.
- After operation 3, cell (2,2) becomes land. It is not connected through a side to any existing island, so another island is formed. The count becomes 3.
- After operation 4, cell (3,3) becomes land. It is also not connected through a side to any existing island, so the count becomes 4.
Therefore, the number of islands after each operation is [1, 2, 3, 4].

```