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
    public void maxlvl(List<Integer>al,TreeNode root, int lvl){
if(root==null)return;
if(lvl==al.size()){
    al.add(root.val);
}
else {
            al.set(lvl, al.get(lvl) + root.val); 
        }
        maxlvl(al,root.left,lvl+1);
        maxlvl(al,root.right,lvl+1);
    }
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer>al=new ArrayList<>();
        maxlvl(al,root,0);
        int num=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<al.size();i++){
            if(al.get(i)>max){
            max=al.get(i);
            num=i;
            }
        }
        // Return maxLevelIndex + 1 because the problem usually expects 
        // the root to be level 1, but our ArrayList is 0-indexed.
        return num+1;
    }
}