# 📝 Coin Change (Minimum Coins) (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/number-of-coins1824/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given an array  **coins[]** , where each element represents a coin of a different denomination, and a target value  **sum** . You have an unlimited supply of each coin type.

Find the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

**Examples:**

```
Input: coins[] = [25, 10, 5], sum = 30
Output: 2
Explanation: Minimum 2 coins needed, 25 and 5  
```

```
Input: coins[] = [9, 6, 5, 1], sum = 19
Output: 3
Explanation: 19 = 9 + 9 + 1
```

```
Input: coins[] = [5, 1], sum = 0
Output: 0
Explanation: For 0 sum, we do not need a coin
```

```
Input: coins[] = [4, 6, 2], sum = 5
Output: -1
Explanation: Not possible to make the given sum.
```

 **Constraints:** 
1 ≤ sum * coins.size() ≤ 106
0 ≤ sum ≤ 104
1 ≤ coins[i] ≤ 104
1 ≤ coins.size() ≤ 103