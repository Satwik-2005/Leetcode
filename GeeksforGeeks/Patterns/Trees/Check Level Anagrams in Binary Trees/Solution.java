/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {

    public static void levelOrder(ArrayList<ArrayList<Integer>> arr1,Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> r = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                Node node = q.poll();
                r.add(node.data);
                if(node.left != null) q.add(node.left);
                if(node.right != null ) q.add(node.right);
            }
        arr1.add(r);
        }
    //return arr1;
    }

    public boolean areAnagrams(Node root1, Node root2) {
        // code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arr1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();

        levelOrder(arr1,root1);
        levelOrder(arr2,root2);

        if(arr1.size() != arr2.size()) return false;

        for(int i=0;i<arr1.size() ; i++){
           ArrayList<Integer> a = new ArrayList<>(arr2.get(i));
           ArrayList<Integer> b = new ArrayList<>(arr1.get(i));
           Collections.sort(a);
           Collections.sort(b);
           if(!b.equals(a)) return false;
        }
    return true; 

    }
}