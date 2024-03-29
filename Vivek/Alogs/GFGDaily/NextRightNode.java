import java.util.*;

/* 

Given a Binary tree and a key in the binary tree, find the node right to the given key. If there is no node on right side, then return a node with value -1.

Example 1:

Input:

       10
     /    \
    2      6
   / \      \
  8   4      5
and key = 2
Output: 6
Explanation: We can see in the above tree
that the next right node of 2 is 6.
Example 2:

Input:
      10
    /     \
   2       6
  / \       \
 8   4       5
and key = 5
Output: -1
Explanation: We can see in the above tree 
that there's No next right node of 5.
So, the output is -1.
Your Task:
You don't need to read input or print anything. Your task is to complete the function nextRight() which takes root node of the tree and an integer key as input parameters and returns the next right node of the node with value key. 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=N<=103
1<=data of node<=103
1<=key<=103

 */

public class NextRightNode {

    public static void main(String[] args) {
        Nd root = new Nd(10);
        root.left = new Nd(2);
        root.right = new Nd(6);
        root.left.left = new Nd(8);
        root.left.right = new Nd(4);
        root.right.right = new Nd(5);
        System.out.println(
                new NextRightNode().nextRight(root, 2));

        System.out.println(
                new NextRightNode().nextRight(root, 5));
    }

    Nd nextRight(Nd root, int key) {

        // Write your code here
        if (root == null) {
            return new Nd(-1);
        }

        Queue<Nd> que = new LinkedList<>();
        Queue<Nd> que2 = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            Nd temp = que.remove();
            if (temp.data == key) {
                return que.isEmpty() ? new Nd(-1) : que.remove();
            }
            if (temp.left != null) {
                que2.add(temp.left);
            }
            if (temp.right != null) {
                que2.add(temp.right);
            }

            if (que.isEmpty()) {
                que = que2;
                que2 = new LinkedList<>();
            }
        }

        return new Nd(-1);

    }

}

class Nd {
    int data;
    Nd left;
    Nd right;

    Nd(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
