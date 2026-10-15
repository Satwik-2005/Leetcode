# 📝 Maximum Without 3 Consecutive Set Bits (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/geek-hates-too-many-1s--170647/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Bit Magic

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a non-negative integer  **n** , you can only change a set bit (1) to an unset bit (0). Find the maximum possible value of n such that its binary representation does not contain three consecutive set bits (111) after performing zero or more allowed operations.

**Examples:**

```
Input: n = 2
Output: 2
Explanation: The binary representation of 2 is 10, which does not contain three consecutive set bits. Therefore, no change is required.
```

```
Input: n = 7
Output: 6
Explanation: The binary representation of 7 is 111, which contains three consecutive set bits. Changing the rightmost set bit to 0 gives: 111 -> 110. Thus, the maximum possible value is 6.

```