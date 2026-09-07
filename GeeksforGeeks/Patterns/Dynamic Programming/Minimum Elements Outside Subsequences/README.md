# 📝 Minimum Elements Outside Subsequences (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/minimum-number-of-elements-which-are-not-part-of-increasing-or-decreasing-subsequence2617/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Arrays

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given an array  **arr[]**  of size  **n** , partition its elements into a strictly increasing subsequence and a strictly decreasing subsequence.

Each element can belong to at most one of these subsequences, and some elements may remain unused.

Determine the minimum number of elements that cannot be included in either subsequence.

**Examples:**

```
Input: arr[] = [7, 8, 1, 2, 4, 6, 3, 5, 2, 1, 8, 7]
Output: 2
Explanation: One possible increasing subsequence is: [1, 2, 4, 5, 8]. One possible decreasing subsequence is: [7, 6, 3, 2, 1]. The remaining elements are 8 and 7, so the minimum number of unselected elements is 2.
```

```
Input: arr[] = [1, 4, 2, 3, 3, 2, 4]
Output: 0
Explanation: One possible increasing subsequence is: [1, 2, 3, 4]. One possible decreasing subsequence is: [4, 3, 2]. All elements are included in one of the two subsequences.
```

**Constraints:** 1 ≤ n ≤ 100
1 ≤ arr[i] ≤ 100