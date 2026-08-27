# 📝 Account Merge (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/account-merge/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Arrays, Hash, DFS, Graph, union-find

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a 2D array  **arr[][]**  of size  **n** , where each element arr[i] is an array of strings representing an account, where the first element arr[i][0] is a name, and the rest of the elements are emails associated with this name. Two accounts belong to the same person if there is a common email associated with both accounts. A person can have any number of accounts initially, but all have the same name.

Merge these accounts and return them in the following format: the first element of each account is the name, and the rest of the elements are emails **** in **** lexicographically **** sorted order.

**Note:**  Accounts themselves can be returned in any order. Even if two accounts have the same name, they may belong to different people as different people could have the same name.

**Examples:**

```
Input: n = 4,
arr[][] =
[["John", "johnsmith@mail.com", "john_newyork@mail.com"],
["John", "johnsmith@mail.com", "john00@mail.com"],
["Mary", "mary@mail.com"],
["John", "johnnybravo@mail.com"]]
Output:
[["John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"],
["Mary", "mary@mail.com"],
["John", "johnnybravo@mail.com"]]
Explanation:
There are three accounts with the same name "John", and two of them share a common email which is "johnsmith@mail.com", thus these two accounts are merged, and remaining two will remain unchanged.
```

```
Input: n = 5,
arr[][] =
[["Gabe", "Gabe00@m.co", "Gabe3@m.co", "Gabe1@m.co"],
["Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"],
["Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"],
["Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"],
["Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"]]
Output:
[["Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"],
["Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"],
["Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"],
["Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"],
["Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co"]]
Explanation:
There is no common email in any of the users.
```

**Constraints:** 1 ≤ n ≤ 1000
2 ≤ arr[i].size ≤ 10
1 ≤ arr[i][j].size ≤ 30
arr[i][0] consists of English letters.