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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        treeRightView(root , 0 , map);
        for(int i=0;i<map.size();i++)
            list.add(map.get(i));

        return list;
    }

    static void treeRightView(TreeNode root , int level , Map<Integer,Integer> mp) {
        if(root == null)
            return;

        mp.computeIfAbsent(level , k -> root.val);

        treeRightView(root.right , level + 1 , mp);
        treeRightView(root.left , level + 1 , mp);
    }

}