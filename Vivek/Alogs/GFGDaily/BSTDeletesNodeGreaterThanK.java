/* 
Given a BST and a value k, the task is to delete the nodes having values greater than or equal to k.

Example 1:

Input:
    4   
   / \  
  1   9 
k = 2 

Output:
1

Your Task:
The task is to complete the function deleteNode() which takes root, k as the argument, and returns the root of tree after deleting values greater than or equal to k. The driver code will print the inorder traversal of the updated tree in output itself.

Expected Time Complexity: O(Size of tree)
Expected Auxiliary Space: O(1).
 */

public class BSTDeletesNodeGreaterThanK {
    
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(9);
        postOrderTraversal(root);
        Node node = deleteNode(root, 2);
        System.out.println();
        postOrderTraversal(node);
    }

    private static void postOrderTraversal(Node node) {
        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+" ");
    }

    public static Node deleteNode(Node root,int k) {

        if(root == null) return null;
        root.left = deleteNode(root.left, k);
        root.right = deleteNode(root.right, k);
        
        if(root.data >= k) {
            return root.left;
        }
        return root;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
