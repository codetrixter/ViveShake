/* 

Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.


(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12
 
Example 1:

Input:
     10
    /    \
   7     15
 /  \   /  \
N   9  11   N
Output:Yes
Explaination:Structure of every left and right subtree are same. 
Example 2:

Input:
      10
    /    \
   7     15
 /  \   /  \
5   N  11   N
Output: No
Explaination: 7's left child is not NULL and right child is NULL. That's why the tree is not foldable. 


Your Task:
The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false depending upon whether the tree is foldable or not.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= n <= 103
1 <= data of node <= 104

 */

public class FoldableBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(7);
        node.right = new Node(15);

        node.left.right = new Node(9);
        node.right.left = new Node(11);

        System.out.println(new FoldableBinaryTree().isFoldable(node));

        Node node1 = new Node(10);
        node1.left = new Node(7);
        node1.right = new Node(15);

        node1.left.left = new Node(5);
        node1.right.left = new Node(11);

        System.out.println(new FoldableBinaryTree().isFoldable(node1));
    }

    public boolean isFoldable(Node node) {
        if (node == null) {
            return true;
        }

        return dfs(node.left, node.right);
    }

    private boolean dfs(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        return dfs(a.left, b.right) && dfs(a.right, b.left);
    }
}

class Node {

    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
