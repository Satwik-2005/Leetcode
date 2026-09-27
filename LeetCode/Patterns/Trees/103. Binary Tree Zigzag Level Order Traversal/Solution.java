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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return level;

        boolean leftToRight = true;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(Collections.nCopies(size , 0));

            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                int index = (leftToRight) ? i : size - i - 1;
                list.set(index, node.val);

                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);
            }

            leftToRight = !leftToRight;
            level.add(list);
        }

        return level;
    }
}