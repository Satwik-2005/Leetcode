# 📝 Wildcard Pattern Matching (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/wildcard-pattern-matching/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Recursion, Strings

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given two strings  ****pat**** and  ****txt****  which may be of different sizes, You have to return  ****true****  if the wildcard pattern i.e. pat, ******** matches with txt else return  ****false**** .

The wildcard pattern pat can include the characters ' ****?**** ' and ' ********* '.

- ' ****?**** ' – matches any single character.

- ' ********* ' – matches any sequence of characters (including the empty sequence).

****Note:**** The matching should cover the entire txt (not partial txt).

**Examples:**

```
Input: txt = "abcde", pat = "a?c*"
Output: true
Explanation: '?' matches with 'b' and '*' matches with "de".

```

```
Input: txt = "baaabab", pat = "a*ab"
Output: false
Explanation: The pattern starts with a, but the text starts with b, so the pattern does not match the text.
```

```
Input: txt = "abc", pat = "*"
Output: true
Explanation: '*' matches with whole text "abc".
```

**Constraints:** 
1 ≤ txt.size(), pat.size() ≤ 100