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

    static class Pair {
        TreeNode node;
        int number;

        public Pair(TreeNode node, int number) {
            this.node = node;
            this.number = number;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
           return 0;

        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().number;
            System.out.println(min);
            System.out.println();
            int first = 0;
            int last = 0;

            for(int i=0;i<size;i++) {
                Pair temp = queue.poll();

                TreeNode node = temp.node;
                int current = temp.number - min;
                System.out.println(current);
                System.out.println();

                if(i == 0)
                    first = current;

                if(i == size - 1)
                    last = current;

                if(node.left != null)
                    queue.offer(new Pair(node.left, current * 2 + 1));
                
                if(node.right != null)
                    queue.offer(new Pair(node.right, current * 2 + 2));
            }

            System.out.println();

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}