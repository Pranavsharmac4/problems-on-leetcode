/**
 * Binary Tree Maximum Path Sum
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence 
 * has an edge connecting them. A node can only appear in the sequence at most once. Note that the path 
 * does not need to pass through the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * This program finds the maximum path sum of any non-empty path.
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeMaxPathSum {

    // Your solution class
    static class Solution {
        private int maxpathdown(TreeNode root, int[] maxvalue) {
            if (root == null) return 0;
            
            // Math.max(0, ...) ignores paths that would result in a negative sum
            int left = Math.max(0, maxpathdown(root.left, maxvalue));
            int right = Math.max(0, maxpathdown(root.right, maxvalue));
            
            // Update the global maximum path sum found so far
            maxvalue[0] = Math.max(maxvalue[0], left + right + root.val);
            
            // Return the maximum path sum extending downwards from the current node
            return Math.max(left, right) + root.val;
        }
        
        public int maxPathSum(TreeNode root) {
            int[] maxvalue = new int[1];
            maxvalue[0] = Integer.MIN_VALUE;
            maxpathdown(root, maxvalue);
            return maxvalue[0];
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        /*
         * Constructing a sample tree:
         *       -10
         *       /  \
         *      9   20
         *         /  \
         *        15   7
         */
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        // Instantiate the solution and test
        Solution solution = new Solution();
        int result = solution.maxPathSum(root);

        // Print the result (Expected Output: 42, which is 15 + 20 + 7)
        System.out.println("Maximum Path Sum: " + result); 
    }
}