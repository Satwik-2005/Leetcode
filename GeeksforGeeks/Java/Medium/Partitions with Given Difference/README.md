# 📝 Partitions with Given Difference (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Arrays

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given an array ****arr[]****  and an integer  ****diff**** , count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.

****Note:****  A partition in the array means dividing an array into two subsets say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only one of the subsets.

**Examples :**

```
Input: arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: There is only one possible partition of this array. Partition : [6, 4], [5, 2]. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
```

```
Input: arr[] = [1, 1, 1, 1], diff = 0 
Output: 6 
Explanation: We can choose two 1's from indices [0,1], [0,2], [0,3], [1,2], [1,3], [2,3] and put them in sum1 and remaining two 1's in sum2.
Thus there are total 6 ways for partition the array arr. 

```

```
Input: arr[] = [3, 2, 5, 1], diff = 4  
Output: 0
Explanation: There is no possible partition of the array that satisfy the given difference. 
```