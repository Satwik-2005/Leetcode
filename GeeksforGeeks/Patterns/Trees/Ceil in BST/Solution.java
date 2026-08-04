/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        // code here
        int ceil = -1;
        
        while(root != null) {
            int val = root.data;
            
            if(root.data == x) {
                return root.data;
            }
            
            else if(x > root.data)
                root = root.right;
                
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        
        return ceil;
    }
}