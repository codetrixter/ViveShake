import java.util.*;
/* 
Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.


Example 1:
Input:
       1
      / \
     2   3
Output:
Complete Binary Tree
Example 2:

Input:
              1
            /   \
          2      3
           \    /  \
            4  5    6
Output:
Not Complete Binary Tree
 */
public class CompleteBinaryTree {
    
    public static void main(String[] args) {
        BSTNode root = new BSTNode(1);
        root.left = new BSTNode(2);
        root.right = new BSTNode(3);
        System.out.println(isCompleteBT(root));///true;


        BSTNode root2 = new BSTNode(1); 
        root2.left = new BSTNode(2);
        root2.right = new BSTNode(3);
        root2.left.right = new BSTNode(4);
        root2.right.left = new BSTNode(5);
        root2.right.right = new BSTNode(6);
        System.out.println(isCompleteBT(root2));
    }

    static boolean isCompleteBT(BSTNode root) {
        //add code here.
        Queue<BSTNode> que = new LinkedList<>();
          
        que.add(root);
        boolean foundNull = false;
        while(!que.isEmpty()) {
            int size = que.size();
            
            for (int i = 0; i < size; i++) {
                BSTNode temp = que.remove();
                if(temp == null) {
                    foundNull = true;
                } else if (foundNull) {
                    return false;
                } else {
                    que.add(temp.left);
                    que.add(temp.right);
                }
            }
        }
        return true;
	} 
}

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(int data) {
        this.data = data;
    }
}
