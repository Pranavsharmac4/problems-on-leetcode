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
    public void check(TreeNode root, int lvl, List<Integer>al){
        if(root==null)return ;
                if(lvl==al.size()){
            al.add(lvl,root.val);
        }
        else{
            al.set(lvl, Math.max(al.get(lvl), root.val));
        }
            check(root.left,lvl+1,al);
            check(root.right,lvl+1,al);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>al=new ArrayList<>();
        check(root,0,al);
        return al;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna