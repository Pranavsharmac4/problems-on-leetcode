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
    public void lvl(TreeNode root, int lvl, ArrayList<List<Integer>>al ){
        if(root==null)return;
        if(lvl==al.size()){
            al.add(new ArrayList<>());
        }
       al.get(lvl).add(root.val);
        lvl(root.left,lvl+1,al);
        lvl(root.right,lvl+1,al);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>>al=new ArrayList<>();
        if(root==null)return al;
        lvl(root,0,al);
        return al;
    }
}