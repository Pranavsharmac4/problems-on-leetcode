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
    public void view(TreeNode root,int lvl,List<Integer> al){
        if(root==null)return;
if(lvl==al.size()){
al.add(root.val);
}
view(root.right,lvl+1,al);
view(root.left,lvl+1,al);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>al=new ArrayList<>();
        view(root,0,al);
        return al;
    }
}