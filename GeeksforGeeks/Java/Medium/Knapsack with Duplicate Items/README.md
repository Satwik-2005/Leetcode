# 📝 Knapsack with Duplicate Items (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a set of items, each with a weight and a value, represented by the array  **wt[]**  and  **val[]**  respectively. Also, a knapsack with a weight limit  **capacity** .
Your task is to fill the knapsack in such a way that we can get the maximum profit. Return the  **maximum profit** .

**Note:**  Each item can be taken any number of times.

**Examples:**

```
Input: val[] = [1, 1], wt[] = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times.

```

```
Input: val[] = [10, 40, 50, 70], wt[] = [1, 3, 4, 5], capacity = 8
Output: 110
Explanation: The optimal choice is to pick the 2nd element and the 4th element.

```

```
Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
Output: 0
Explanation: We can't pick any element. Hence, total profit is 0.
```

**Constraints:** 
1 ≤ val.size() = wt.size() ≤ 1000
1 ≤ capacity ≤ 1000
1 ≤ val[i], wt[i] ≤ 100