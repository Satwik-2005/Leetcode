# [Largest Rectangle with Column Swaps](https://www.geeksforgeeks.org/problems/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed0243/1)
## Hard
Given a binary matrix mat[][] of size n × m containing only 0s and 1s, any pair of columns may be swapped any number of times. Return the maximum area of a rectangle consisting entirely of 1's that can be formed after performing the column swaps.
Examples:
Input: mat[][] = [[0, 1, 0, 1, 0], [0, 1, 0, 1, 1], [1, 1, 0, 1, 0]]
Output: 6
Explanation: After swapping the 2nd and 3rd columns, the largest rectangle of 1s has an area of 6. 
Input: mat[][] = [[0, 1, 1, 0, 0], [1, 1, 1, 0, 1], [1, 1, 1, 0, 1], [1, 1, 1, 1, 1]]
Output: 12Explanation: After swapping the 4th and 5th columns, the largest rectangle of 1s has an area of 12.