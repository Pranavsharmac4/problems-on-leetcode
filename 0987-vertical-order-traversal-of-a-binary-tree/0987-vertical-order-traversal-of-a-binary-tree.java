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
import java.util.*;

class Solution {
    private class NodeInfo {
        int val, row, col;
        NodeInfo(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });
        List<List<Integer>> result = new ArrayList<>();
        if (nodes.isEmpty()) return result;

        int currentCol = nodes.get(0).col;
        List<Integer> currentList = new ArrayList<>();

        for (NodeInfo node : nodes) {
            if (node.col != currentCol) {
                result.add(currentList);
                currentList = new ArrayList<>();
                currentCol = node.col;
            }
            currentList.add(node.val);
        }
        result.add(currentList);

        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<NodeInfo> nodes) {
        if (node == null) return;
        
        nodes.add(new NodeInfo(node.val, row, col));
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}