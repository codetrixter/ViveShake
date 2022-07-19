public class CeilInBST {
    public static void main(String[] args) {
        /* 
        Input:
              5
            /   \
           1     7
            \
             2 
              \
               3
        X = 3
        Output: 3
        Explanation: We find 3 in BST, so ceil
        of 3 is 3.
        */
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.right = new Node(2);
        root.left.right.right = new Node(3);
        int key = 3;
        System.out.println(findCeil(root, key));// ans : 3

        /* 
         Input:
              10
             /  \
            5    11
           / \ 
          4   7
                \
                 8
        X = 6
        Output: 7
        Explanation: We find 7 in BST, so ceil
        of 6 is 7.
         */
        Node newRoot = new Node(10);
        newRoot.left = new Node(5);
        newRoot.right = new Node(11);
        newRoot.left.left = new Node(4);
        newRoot.left.right = new Node(7);
        newRoot.left.right.right = new Node(8);

        System.out.println(findCeil(newRoot, 6));// ans 7
    }

    static int findCeil(Node root, int key) {
        if (root == null)
            return -1;
        int data;
        if (key < root.data) {
            data = findCeil(root.left, key);
            return data == -1 ? root.data : data;
        } else if (key > root.data) {
            return findCeil(root.right, key);
        } else {
            return key;
        }
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
