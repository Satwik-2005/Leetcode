# 📝 Shortest Common Supersequence (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Strings, Dynamic Programming

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given two strings  **s1**  and  **s2** , find the length of the  **smallest string** which has both  **s1** and **s2** as its  **sub-sequences** .
 **Note:**  s1 and s2 can have both uppercase and lowercase English letters.

**Examples:**

```
Input: s1 = "geek", s2 = "eke"
Output: 5
Explanation: String "geeke" has both string "geek" and "eke" as subsequences.

```

```
Input: s1 = "AGGTAB", s2 = "GXTXAYB"
Output: 9
Explanation: String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.

```

```
Input: s1 = "geek", s2 = "ek"
Output: 4
Explanation: String "geek" has both string "geek" and "ek" as subsequences.
```

**Constraints:** 
1 ≤ s1.size(), s2.size() ≤ 500