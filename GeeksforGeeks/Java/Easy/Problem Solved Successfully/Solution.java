import java.util.*;

class Solution {

    void collect(Node node, int depth, ArrayList<Integer> leaves) {
        if (node == null) return;

        // Leaf node
        if (node.left == null && node.right == null) {
            leaves.add(depth);
            return;
        }

        collect(node.left, depth + 1, leaves);
        collect(node.right, depth + 1, leaves);
    }

    public int getCount(Node root, int k) {
        ArrayList<Integer> leaves = new ArrayList<>();

        // Start depth from 1
        collect(root, 1, leaves);

        // Sort leaf depths
        Collections.sort(leaves);

        int count = 0;

        for (int cost : leaves) {
            if (cost > k) break;

            k -= cost;
            count++;
        }

        return count;
    }
}