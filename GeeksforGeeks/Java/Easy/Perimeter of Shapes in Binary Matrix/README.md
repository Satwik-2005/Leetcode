# 📝 Perimeter of Shapes in Binary Matrix (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/find-perimeter-of-shapes/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Matrix, Geometric

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a binary matrix  **mat[][]**  of size  **n × m** , where each cell contains either  **0**  or  **1** , find the total perimeter of all figures formed by cells containing  **1s** . Two cells are considered adjacent if they share a common side.

A single cell containing 1 has a perimeter of 4, whereas two adjacent cells containing 1 (i.e., 11) together have a perimeter of 6.

![image](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/932783/Web/Other/blobid0_1786107666.png)

**Examples :**

```
Input: mat[][] = [[0,1,0,0,0], [1,1,1,0,0], [1,0,0,0,0]]
Output: 12
Explanation: The five cells form a single figure. Hence, the perimeter of the figure is 12.     

```

```
Input: mat[][] = [[1,0], [1,1]]
Output: 8
Explanation: The two adjacent cells share one common side. Hence, the perimeter of the figure is 6.  

```