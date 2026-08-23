# 📝 Most Isolated City (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Graph, Shortest Path, BFS, Disjoint Set

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

There are  **n**  cities labeled from 0 to n - 1 and  **m**  bidirectional weighted edges connecting them. Given a 2D array  **edges[][]** , where each edges[i] = [fromi, toi, weighti] represents a bidirectional edge between cities **** fromi and toi with weight weighti.

Also given an integer  **dis** . For each city, consider all other cities that are reachable through some path with a shortest path distance of at most dis. Return the city that can reach the fewest such cities. If multiple cities satisfy this condition, return the city with the greatest label.

**Examples**

```
Input: n = 4, m = 4, dis = 4, edges = [[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]]
Output: 3
Explanation:

The neighboring cities at a distance of dis for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a dis = 4, but we have to return city 3 since it has the greatest label.

```

```
Input: n = 5, m = 6, dis = 2, edges = [[0, 1, 2], [0, 4, 8], [1, 2, 3], [1, 4, 2], [2, 3, 1], [3, 4, 1]]
Output: 0
Explanation:

The neighboring cities at a distance of dis for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4]
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3]
The city 0 has 1 neighboring city at a dis = 2.

```

**Constraints:** 
1  ≤  n ≤  100
1 ≤ m ≤ n*(n-1)/2
1 ≤ weighti , dis ≤104