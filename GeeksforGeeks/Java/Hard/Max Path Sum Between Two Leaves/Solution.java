class Solution {

    int maxSum = Integer.MIN_VALUE;
    int leafCount = 0;

    public int maxPathSum(Node root) {

        getMax(root);

        if (leafCount < 2) {
            return -1;
        }

        return maxSum;
    }

    private int getMax(Node root) {

        // Null node
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            leafCount++;
            return root.data;
        }

        // Only right child
        if (root.left == null) {
            return root.data + getMax(root.right);
        }

        // Only left child
        if (root.right == null) {
            return root.data + getMax(root.left);
        }

        // Both children exist
        int leftSum = getMax(root.left);
        int rightSum = getMax(root.right);

        // Path between two leaf nodes through root
        maxSum = Math.max(maxSum,
                leftSum + root.data + rightSum);

        // Return maximum root-to-leaf sum
        return root.data + Math.max(leftSum, rightSum);
    }
}