# 📝 Minimum Cost for n Characters (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/minimum-time1238/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given four integers  **n** ,  **i** ,  **d** , and  **c** , where:

- i is the cost of inserting a single character,

- d is the cost of deleting the last character,

- c is the cost of copying the entire current string and pasting it immediately (thereby doubling its length).

Find the minimum cost required to obtain exactly n characters on the screen. Initially, the screen is empty.

**Examples:**

```
Input: n = 9, i = 1, d = 2, c = 1
Output: 5
Explanation: Perform the following operations:
Insert (1 character)
Insert (2 characters)
Copy-paste (4 characters)
Copy-paste (8 characters)
Insert (9 characters)
Total cost = 1 + 1 + 1 + 1 + 1 = 5.
```

```
Input: n = 9, i = 10, d = 1, c = 1
Output: 17
Explanation: Perform the following operations:
Insert (1 character)
Copy-paste (2 characters)
Copy-paste (4 characters)
Delete (3 characters)
Copy-paste (6 characters)
Delete (5 characters)
Copy-paste (10 characters)
Delete (9 characters)
Total cost = 10 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 17.
Since insertion is expensive, it is cheaper to use copy-paste operations and adjust the length using deletions.
```