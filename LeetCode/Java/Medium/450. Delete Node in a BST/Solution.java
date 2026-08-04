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

    private TreeNode findLeftMaximum(TreeNode root) {
        if(root.right == null)
            return root;

        return findLeftMaximum(root.right);
    }

    private TreeNode deletionNode(TreeNode root) {
        if(root.right == null)
            return root.left;

        else if(root.left == null)
            return root.right;

        else {
            TreeNode rightChild = root.right;
            TreeNode leftMax = findLeftMaximum(root.left);
            leftMax.right = rightChild;

            return root.left;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val == key)
            return deletionNode(root);

        TreeNode current = root;

        while(current != null) {
            int val = current.val;

            if(val > key) {
                if(current.left != null  &&   current.left.val == key) {
                    current.left = deletionNode(current.left);
                    break;
                }

                else
                    current = current.left;
            }

            else {
                if(current.right != null  &&  current.right.val == key) {
                    current.right = deletionNode(current.right);
                    break;
                }

                else
                    current = current.right;
            }
        }

        return root;
    }
}