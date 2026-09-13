# 📝 Edit Distance (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/edit-distance3702/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Strings, Dynamic Programming

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given two strings  **s1**  and  **s2.** Return the minimum number of operations required to convert s1 to s2.
The possible operations are permitted:

1. Insert a character at any position of the string.
2. Remove any character from the string.
3. Replace any character from the string with any other character.

**Examples:**

```
Input: s1 = "geek", s2 = "gesek"
Output: 1
Explanation: One operation is required, inserting 's' between two 'e' in s1.
```

```
Input: s1 = "gfg", s2 = "gfg"
Output: 0
Explanation: Both strings are same.

```

```
Input: s1 = "abcd", s2 = "bcfe"
Output: 3
Explanation: We can convert s1 into s2 by removing ‘a’, replacing ‘d’ with ‘f’ and inserting ‘e’ at the end. 
```