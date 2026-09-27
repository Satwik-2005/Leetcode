/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<TreeNode, TreeNode> parentNodesOfEachNode(TreeNode root) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }

            if(node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        return parent;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentNodes = parentNodesOfEachNode(root);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int currentValue = 0;

        queue.offer(target);
        visited.put(target, true);

        while(!queue.isEmpty()) {
            int size = queue.size();
            
            if(currentValue == k)
                break;
            
            currentValue += 1;

            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();

                if(node.left != null  &&  visited.get(node.left) == null) {
                    visited.put(node.left, true);
                    queue.offer(node.left);
                }

                if(node.right != null  &&  visited.get(node.right) == null) {
                    visited.put(node.right, true);
                    queue.offer(node.right);
                }

                if(parentNodes.get(node) != null  &&  visited.get(parentNodes.get(node)) == null) {
                    visited.put(parentNodes.get(node), true);
                    queue.offer(parentNodes.get(node));
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr.val);
        }

        return list;
    }
}