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

    static class Trible {
        TreeNode node;
        int row;
        int col;

        public Trible(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Trible> queue = new LinkedList<>();

        queue.offer(new Trible(root, 0, 0));

        while(!queue.isEmpty()) {
            Trible tuple = queue.poll();

            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            map.putIfAbsent(row, new TreeMap<>());
            map.get(row).putIfAbsent(col, new PriorityQueue<>());
            map.get(row).get(col).offer(node.val);

            if(node.left != null)
                queue.offer(new Trible(node.left, row - 1, col + 1));

            if(node.right != null)
                queue.offer(new Trible(node.right, row + 1, col + 1));
        }

        List<List<Integer>> level = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> vt: map.values()) {
            List<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> nodes : vt.values()) 
                while(!nodes.isEmpty()) 
                    list.add(nodes.poll());

            level.add(list);
        }

        return level;
    }
}