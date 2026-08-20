/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
     int ans = Integer.MIN_VALUE;

     int dfs(Node root) {
         if (root == null)
             return Integer.MAX_VALUE;

         int left = dfs(root.left);
         int right = dfs(root.right);

         int min = Math.min(left, right);

         if (min != Integer.MAX_VALUE)
             ans = Math.max(ans, root.data - min);

         return Math.min(root.data, min);
     }

     int maxDiff(Node root) {
         dfs(root);
         return ans;
     }
 }