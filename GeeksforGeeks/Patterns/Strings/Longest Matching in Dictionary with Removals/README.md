# 📝 Longest Matching in Dictionary with Removals (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/find-largest-word-in-dictionary2430/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Strings

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a lowercase string  **s**  and a dictionary  **d[]**  containing lowercase words, find the longest word in the dictionary that can be obtained by deleting some characters from s without changing the order of the remaining characters.

**Note** : If multiple words have the same maximum length, return the lexicographically smallest one. If no valid word exists, return an empty string.

**Examples :**

```
Input: d = ["ale", "apple", "monkey", "plea"], s = "abpcplea"
Output: "apple" 
Explanation: After deleting "b", "c", "a" s became "apple" which is present in d.

```

```
Input: d = ["a", "b", "c"], s = "abpcplea"
Output: "a"
Explanation: After deleting "b", "p", "c", "p", "l", "e", "a" s became "a" which is present in d.
```

**Constraints:** 
1 ≤ |s| ≤ 5 * 105
1 ≤ n ≤ 104, where n is the number of words in dictionary
1 ≤ m ≤ 100, where m is the length of word in dictionary
s and all words in dictionary consist only of lowercase English letters.