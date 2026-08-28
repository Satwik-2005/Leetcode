# 📝 Maximum Stone Removal (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/maximum-stone-removal-1662179442/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given an 2D array of non-negative integers  **stones[][]** where stones[i] = [xi , yi] represents the location of the ith stone on a 2D plane, the task is to return the maximum possible number of stones that you can remove.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

**Note:**  Each coordinate point may have at most one stone.

**Examples:**

```
Input: stones[][] = [[0, 0], [0, 1], [1, 0], [1, 2], [2, 1], [2, 2]]
Output: 5
Explanation:
      
One way to remove 5 stones is as follows:
1. Remove stone [2, 2] because it shares the same row as [2, 1].
2. Remove stone [2, 1] because it shares the same column as [0, 1].
3. Remove stone [1, 2] because it shares the same row as [1, 0].
4. Remove stone [1, 0] because it shares the same column as [0, 0].
5. Remove stone [0, 1] because it shares the same row as [0, 0].
Stone [0, 0] cannot be removed since it does not share any row/column with another stone still on the plane.

```

```
Input: stones[][] = [[0, 0], [0, 2], [1, 1], [2, 0], [2, 2]]
Output: 3
Explanation:
     
One way to remove 3 stones is as follows:
1. Remove stone [2, 2] because it shares the same row as [2, 0].
2. Remove stone [2, 0] because it shares the same column as [0, 0].
3. Remove stone [0, 2] because it shares the same row as [0, 0].
Stones [0, 0] and [1, 1] cannot be removed since they do not share any row/column with another stone still on the plane.
```

**Constraints:** 1 ≤ stones.size() ≤ 1000
0 ≤ xi, yi ≤ 104
No two stones are at same position.