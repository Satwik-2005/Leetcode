/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private ArrayList<Integer>list;

    private void inOrder(Node root)
    {
        if(root == null) return;

        inOrder(root.left);
        list.add(root.data);
        inOrder(root.right);

    }
    public int absDiff(Node root) {
        // code here
        list = new ArrayList<>();
        inOrder(root);

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i < list.size(); i++)
        {
            ans = Math.min(ans, Math.abs(list.get(i) - list.get(i -1 )));
        }

        return ans;
    }
}