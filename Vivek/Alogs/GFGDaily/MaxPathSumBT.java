public class MaxPathSumBT {
    
    /* 
     * Recurrence Relation: T(n) = 2T(n/2) + 1
     * Time Complexity = O(n)
     * Space Complexity = O(1)
     */
    private static int maxPathSum(Node node) {
        if (node == null)
            return 0;
        return Math.max(maxPathSum(node.left), maxPathSum(node.right)) + node.data;
    }

    public static void main(String[] args) {
        /* 
                  10
                 /  \
               -2    7
               / \   
              8  -4 

              ans = 17
         */
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(7);

        root.left.left = new Node(8);
        root.left.right = new Node(-4);

        System.out.println(maxPathSum(root)); // ans=17


        /* 
                1
               / \
              2   3

              ans = 4
         */

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println(maxPathSum(root2)); // ans 4
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
