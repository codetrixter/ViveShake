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
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
