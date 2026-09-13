# 📝 Party in Town (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/party-in-town3951/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
DFS, Tree

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Geek Town has n houses numbered from 1 to n, choose a house to host a party such that its distance from its farthest house is as small as possible. Return this minimum possible distance.

- The houses are connected by n − 1 bidirectional roads, forming a tree.
- The connections are given as an adjacency list adj, where adj[i] contains all houses directly connected to house i + 1.

**Examples:**

```
Input: adj[][] = [[2], [1, 4, 3], [2], [2]] 

Output: 1
Explanation: Party should take place at house number 2. Maximum distance from house number 2 is 1.
```

```
Input: adj[][] = [[2], [1, 3], [4, 2], [3]]

Output: 2
Explanation: Party should take place at house number 2 or 3. The minimum distance is 2.
```