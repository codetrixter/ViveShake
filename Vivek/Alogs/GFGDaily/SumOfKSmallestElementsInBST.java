/* 
 Given a Binary Search Tree. Find sum of all elements smaller than and equal to Kth smallest element.

Example 1:

Input: 
          20
        /    \
       8     22
     /    \
    4     12
         /    \
        10    14   , K=3

Output: 22
Explanation:
Sum of 3 smallest elements are: 
4 + 8 + 10 = 22
Example 2:
Input:
     10
    /  \
   5    11
  / \ 
 4   7
      \
       8 , K=2

Output: 9
Explanation:
The sum of two smallest elements 
is 4+5=9.
 
Your task:
You don't need to read input or print anything. Your task is to complete the function sum() which takes the root node and an integer K as input parameters and returns the sum of all elements smaller than and equal to kth smallest element.
 
Expected Time Complexity: O(K)
Expected Auxiliary Space: O(1)
 
Constraints:
1<=Number of nodes in BST<=100
1<=K<=N
 */

public class SumOfKSmallestElementsInBST {

    int K = 0;

    public static void main(String[] args) {
        SumOfKSmallestElementsInBST obj = new SumOfKSmallestElementsInBST();

        Node node = new Node(20);
        node.left = new Node(8);
        node.right = new Node(22);
        node.left.left = new Node(4);
        node.left.right = new Node(12);
        node.left.right.left = new Node(10);
        node.left.right.right = new Node(14);

        int k = 3;

        System.out.println(obj.sum(node, k));

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.right = new Node(8);

        int k1 = 2;

        System.out.println(obj.sum(root, k1));
    }

    int sum(Node root, int k) {
        K = k;
        return getSum(root);
    }

    int getSum(Node node) {
        if (node == null || K <= 0)
            return 0;
        int tempSum = 0;
        tempSum += getSum(node.left);
        if (K > 0) {
            tempSum += node.data;
            K--;
        }
        tempSum += getSum(node.right);

        return tempSum;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int key) {
        this.data = key;
        this.left = this.right = null;
    }
}
