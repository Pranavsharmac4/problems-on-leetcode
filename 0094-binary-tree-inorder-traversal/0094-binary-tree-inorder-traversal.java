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
    public void inorder(TreeNode root,List<Integer>al){
        if(root==null)return;
      
        inorder(root.left,al);
          al.add(root.val);
        inorder(root.right,al);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer>al=new ArrayList<>();

        inorder(root,al);
        return al;
    }
}