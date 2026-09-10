# 📝 Longest Common Substring (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Strings, Dynamic Programming

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given two strings  **s1**  and  **s2** , determine the length of the  **longest substring**  that appears in both strings.

**Examples:**

```
Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" with a length of 4.

```

```
Input: s1 = "abc", s2 = "acb"
Output: 1
Explanation: The longest common substrings are "a", "b", "c" all having length 1.

```

```
Input: s1 = "YZ", s2 = "yz"
Output: 0
Explanation: Comparison is case-sensitive, so 'Y' ≠ 'y' and 'Z' ≠ 'z'. Hence, no common substring exists.
```

**Constraints:** 
1 ≤ s1.size(), s2.size() ≤ 103
Both strings consist only of uppercase and lowercase English letters.