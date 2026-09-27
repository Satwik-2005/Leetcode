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

    private TreeNode leftMaximum(TreeNode root) {
        if(root.right == null)
            return root;

        return leftMaximum(root.right);
    }

    private TreeNode delete(TreeNode root) {
        if(root.left == null)
            return root.right;

        else if(root.right == null)
            return root.left;

        else {
            TreeNode rightChild = root.right;
            TreeNode leftMaximum = leftMaximum(root.left);
            leftMaximum.right = rightChild;
            return root.left;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode prev = root;

        if(root == null)
            return root;

        if(root.val == key)
            return delete(root);

        while(root != null) {
            if(root.val > key) {
                if(root.left != null  &&  root.left.val == key)
                    root.left = delete(root.left);

                else
                    root = root.left;
            }

            else {
                if(root.right != null  &&  root.right.val == key)
                    root.right = delete(root.right);

                else 
                    root = root.right;
            }
        }

        return prev;
    }
}