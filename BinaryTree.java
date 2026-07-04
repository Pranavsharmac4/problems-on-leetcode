import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    // 1. The Node Class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // 2. Insert Method
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node current, int data) {
        // Base case: we found an empty spot
        if (current == null) {
            return new Node(data);
        }

        // Navigate left or right based on the value
        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        } else {
            // Value already exists
            System.out.println("Value " + data + " is already in the tree.");
        }

        return current;
    }

    // 3. In-Order Traversal (Left, Root, Right)
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    private void inOrderRecursive(Node node, List<Integer> result) {
        if (node != null) {
            inOrderRecursive(node.left, result); // Visit left subtree
            result.add(node.data);               // Visit node itself
            inOrderRecursive(node.right, result);// Visit right subtree
        }
    }

    // --- Example Usage ---
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        int[] valuesToInsert = {50, 30, 20, 40, 70, 60, 80};
        
        for (int val : valuesToInsert) {
            tree.insert(val);
        }
        
        // This will print the numbers in sorted, ascending order.
        System.out.println("In-order traversal: " + tree.inOrderTraversal());
    }
}