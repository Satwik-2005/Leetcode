# 📝 Minimum Multiplications to reach End (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Arrays, Graph, BFS

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given two integers,  **start**  and  **end** , along with an array of integers  **arr[]** . In one operation, you can multiply the current value by any element from arr[], and then take the result  **modulo 1000**  to obtain a new value.

Find the **minimum** steps in which  **end**  can be achieved starting from  **start** . If it is not possible to reach  **end** , then return  **-1** .

**Examples :**

```
Input: arr[] = [2, 5, 7], start = 3, end = 30
Output: 2
Explanation:
Step 1: 3*2 = 6 % 1000 = 6 
Step 2: 6*5 = 30 % 1000 = 30

```

```
Input: arr[] = [3, 4, 65], start = 7, end = 175
Output: 4
Explanation:
Step 1: 7 * 3 = 21 % 1000 = 21  
Step 2: 21 * 3 = 63 % 1000 = 63  
Step 3: 63 * 65 = 4095 % 1000 = 95  
Step 4: 95 * 65 = 6175 % 1000 = 175 

```

```
Input: arr[] = [2, 4], start = 3, end = 5
Output: -1
Explanation: Starting from 3 and multiplying by 2 or 4 always produces even numbers after the first step. Since 5 is odd, it can never be reached.
```

**Constraints:** 1  ≤ arr.size()  ≤ 103
1  ≤ arr[i]  ≤ 103
0  ≤ start, end  < 103