import java.util.*;

/* 
Given a Binary Search Tree. Convert a given BST into a Special Max Heap with the condition that all the
values in the left subtree of a node should be less than all the values in the right subtree of the node. This condition is applied on all the nodes in the so converted Max Heap.

Example 1:

Input :
                 4
               /   \
              2     6
            /  \   /  \
           1   3  5    7  

Output : 1 2 3 4 5 6 7 
Exaplanation :
               7
             /   \
            3     6
          /   \  /   \
         1    2 4     5
The given BST has been transformed into a
Max Heap and it's postorder traversal is
1 2 3 4 5 6 7.
Example 2:

Input :
                 3
               /   \
              1     5
               \   /  \
                2 4    6
                        \
                         7
Output : 1 2 3 4 5 6 7 
Exaplanation :
               7
             /   \
            3     6
          /   \  /   \
         1    2 4     5
The given BST has been transformed into a
Max Heap and it's postorder traversal is
1 2 3 4 5 6 7.
Your task :
You don't need to read input or print anything. Your task is to complete the function convertToMaxHeapUtil() which takes the root of the tree as input and converts the BST to max heap.
Note : The driver code prints the postorder traversal of the converted BST.
 
Expected Time Complexity : O(n)
Expected Auxiliary Space : O(n)
 */

public class BSTToMaxHeap {
    static int i = 0;

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(6);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right.left = new Node(5);
        node.right.right = new Node(7);

        printPreOrderTraversal(node);
        System.out.println();
        convertToMaxHeapUtil(node);
        printPreOrderTraversal(node);
    }

    static void printPreOrderTraversal(Node node) {
        if (node == null)
            return;
        printPreOrderTraversal(node.left);
        printPreOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void convertToMaxHeapUtil(Node root) {
        i = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        getSortedNum(list, root);
        createMaxHeap(list, root);
    }

    private static void getSortedNum(ArrayList<Integer> list, Node node) {
        if (node == null)
            return;
        getSortedNum(list, node.left);
        list.add(node.data);
        getSortedNum(list, node.right);
    }

    private static void createMaxHeap(ArrayList<Integer> list, Node node) {
        if (node == null)
            return;
        createMaxHeap(list, node.left);
        createMaxHeap(list, node.right);
        node.data = list.get(i++);
    }
}
