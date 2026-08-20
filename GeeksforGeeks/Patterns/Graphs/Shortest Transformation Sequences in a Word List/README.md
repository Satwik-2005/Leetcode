# 📝 Shortest Transformation Sequences in a Word List (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/word-ladder-ii/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph, BFS

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given two distinct words  **s**  and  **e** , and a list of unique words  **words[]** , where all words have the same length, find all  **shortest**  transformation  **sequences**  from s to e.

A valid transformation sequence must satisfy the following conditions:

- Only  **one**  character can be changed in each transformation.

- Every transformed word must  **exist**  in words[], including e.

- All words consist only of lowercase English letters.

- **s**  may or may not be present in words[].

Return all shortest transformation sequences from s to e. If no such sequence exists, return an  **empty**  list. The sequences may be returned in any order.

**Examples:**

```
Input: s = "der", e = "dfs", words[] = ["des", "der", "dfr", "dgt", "dfs"]
Output: [["der", "des", "dfs"], ["der", "dfr", "dfs"]]
Explanation: There are two shortest transformation sequences from "der" to "dfs", each having a length of 3:
"der" -> "dfr" -> "dfs"
"der" -> "des" -> "dfs"
Each transformation changes exactly one character, and every intermediate word belongs to words[]. Since these are the shortest possible sequences, both are included in the output.

```

```
Input: s = "gedk", e = "geek", words[] = ["geek", "gefk"]
Output: [["gedk", "geek"]]
Explanation: The word "gedk" can be transformed directly into "geek" by changing the third character ['d' to 'e']. Since "geek" is present in words[], the shortest transformation sequence is:
"gedk" -> "geek"
Therefore, the output contains a single sequence.

```

**Constraints:** 
1 ≤ n ≤ 500, where n is the length of words.
1 ≤ m ≤ 10, where m is the length of words[i]
The sum of all shortest sequences does not exceed 105. 
Let k is the number of shortest transformation sequences.