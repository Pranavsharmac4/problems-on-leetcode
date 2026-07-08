import java.util.*;

public class Topview {
    // 1. Make the Node class static so we can use it in main
    static class Node {
        int data;
        Node left;
        Node right;
        
        // Fixed: added 'int' type to the parameter
        public Node(int key) {
            data = key;
            left = null;
            right = null;
        }
    }

    // A helper class to store a node alongside its Horizontal Distance
    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void printTopView(Node root) {
        if (root == null) {
            return;
        }

        // TreeMap stores HD as the key and Node value as the value.
        // It automatically sorts the keys from lowest (leftmost) to highest (rightmost).
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Info> queue = new LinkedList<>();

        // Start BFS with the root at Horizontal Distance 0
        queue.add(new Info(root, 0));

        while (!queue.isEmpty()) {
            Info curr = queue.poll();
            int hd = curr.hd;
            Node currNode = curr.node;

            // If this is the FIRST time we are seeing this HD, it means it's the topmost node.
            // Add it to the map. If the map already has this HD, we ignore it.
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, currNode.data);
            }

            // Add left and right children to the queue with their respective HDs
            if (currNode.left != null) {
                queue.add(new Info(currNode.left, hd - 1));
            }
            if (currNode.right != null) {
                queue.add(new Info(currNode.right, hd + 1));
            }
        }

        // Print the final top view
        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Fixed: Added dot notation and capitalized String
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);

        /* 
           The Tree looks like this:
                 1 (HD: 0)
               /   \
     (HD:-1)  2     3 (HD: +1)
     
                   /
                  5 (HD: 0)  <-- Hidden from top view by node 1
        */

        System.out.print("Top View: ");
        printTopView(root); // Output should be: 2 1 3
    }
}