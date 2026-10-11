# 📝 Sort Two Parts Sorted (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/sort-the-half-sorted2157/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
two-pointer-algorithm, Sorting

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given an integer array  **arr[]**  where the two parts around a break point are individually sorted, merge them into a single sorted array.  The break point can be anywhere in the array, including at the beginning or end.

**Examples:**

```
Input: arr[] = [2, 3, 8, -1, 7, 10]
Output: [-1, 2, 3, 7, 8, 10] 
Explanation: [2, 3, 8] and [-1, 7, 10] are sorted in the original array. The overall sorted version is [-1 2 3 7 8 10].
```

```
Input: arr[] = [-4, 6, 9, -1, 3]
Output: [-4, -1, 3, 6, 9]
Explanation: [-4, 6, 9] and [-1, 3] are sorted in the original array. The overall sorted version is [-4 -1 3 6 9].
```

```
Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: One part is empty and the other part is whole array which is already sorted.
```