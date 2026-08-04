/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int count = 0;

        while(current != null) {
            if(current.left == null) {
                count++;

                if(count == k)
                    return current.val;

                current = current.right;
            }

            else {
                TreeNode previous = current.left;

                while(previous.right != null  &&  previous.right != current)
                    previous = previous.right;

                if(previous.right == null) {
                    previous.right = current;
                    current = current.left;
                }

                else {
                    previous.right = null;
                    count++;

                    if(count == k)
                        return current.val;

                    current = current.right;
                }
            }
        }

        return -1;
    }
}