package Alogs.GFGDaily;

/* 
Given a binary tree and data value of two of its nodes. Find the number of turns needed to reach from one node to another in the given binary tree.

Example 1:

Input:      
Tree = 
           1
        /    \
       2       3
     /  \     /  \
    4    5   6    7                        
   /        / \                        
  8        9   10   
first node = 5
second node = 10
Output: 4
Explanation: 
Turns will be at 2, 1, 3, 6.
Example 2:

Input:      
Tree = 
           1
        /     \
       2        3
     /  \      /  \
    4    5    6    7                        
   /         / \                        
  8         9   10   
first node = 1
second node = 4  
Output: -1
Explanation: No turn is required since 
they are in a straight line.

Your Task:  
You don't need to read input or print anything. Complete the function NumberOFTurns() which takes root node and data value of 2 nodes as input parameters and returns the number of turns required to navigate between them. If the two nodes are in a straight line, ie- the path does not involve any turns, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 103
 */

public class NumOfTurnsInBT {

    static int ans;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(8);

        root.right.left = new Node(6);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);
        root.right.right = new Node(7);

        System.out.println(NumberOfTurns(root, 5, 10));
        System.out.println(NumberOfTurns(root, 1, 4));
    }

    static int NumberOfTurns(Node root, int first, int second) {
        ans = 0;
        Node lca = findLCA(root, first, second);
        boolean left = true;

        if (lca.data == first) {
            findNode(lca.left, left, second);
            findNode(lca.right, !left, second);
        } else if (lca.data == second) {
            findNode(lca.left, left, first);
            findNode(lca.right, !left, first);
        } else {
            findNode(lca.left, left, first);
            findNode(lca.right, !left, first);

            findNode(lca.left, left, second);
            findNode(lca.right, !left, second);
            ans++;
        }
        return ans;
    }

    private static boolean findNode(Node node, boolean left, int key) {
        if (node == null)
            return false;
        if (node.data == key)
            return true;

        if (left) {
            if (findNode(node.left, left, key))
                return true;
            if (findNode(node.right, !left, key)) {
                ans++;
                return true;
            }
        } else {
            if (findNode(node.left, !left, key)) {
                ans++;
                return true;
            }
            if (findNode(node.right, left, key))
                return true;
        }
        return false;
    }

    private static Node findLCA(Node node, int first, int second) {
        if (node == null)
            return null;

        if (node.data == first || node.data == second)
            return node;

        Node leftLCA = findLCA(node.left, first, second);
        Node rightLCA = findLCA(node.right, first, second);

        if (leftLCA != null && rightLCA != null)
            return node;
        return leftLCA != null ? leftLCA : rightLCA;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
