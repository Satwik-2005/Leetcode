/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    private void getPaths(Node root, 
                            ArrayList<ArrayList<Integer>> level,
                            ArrayList<Integer> list) {
        
        if(root.left == null  &&  root.right == null) {
            list.add(root.data);
            
            level.add(new ArrayList<>(list));
            
            list.remove(list.size() - 1);
        }
        
        list.add(root.data);
        
        
        if(root.left != null)
            getPaths(root.left, level, list);
        
        if(root.right != null)
            getPaths(root.right, level, list);
            
        list.remove(list.size() - 1);
    }
    
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> path = new ArrayList<>();
        ArrayList<Integer> eachPath = new ArrayList<>();
        
        getPaths(root, path, eachPath);
        
        return path;
    }
}