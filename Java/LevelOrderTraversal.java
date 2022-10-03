import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

    class Node
    {
        int data;
        Node left;
        Node right;
    }

    void printLevelOrder(Node root)
    {
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node node = q.poll();
            System.out.print(node.data+" ");

            if(node.left != null)
                q.add(node.left);

            if(node.right != null)
                q.add(node.right);
        }
    }

    Node getNewNode(int val)
    {
        Node newNode = new Node();
        newNode.data   = val;
        newNode.left  = null;
        newNode.right = null;

        return newNode;
    }

    Node insert(Node root, int val)
    {
        if(root == null)
            return getNewNode(val);
        if(root.data < val)
            root.right = insert(root.right, val);
        else if(root.data > val)
            root.left = insert(root.left,val);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LevelOrderTraversal obj = new LevelOrderTraversal();

        Node root = null;
        int n, val;
        n = sc.nextInt();

        while(n-- > 0)
        {
            val = sc.nextInt();
            root = obj.insert(root, val);
        }

        obj.printLevelOrder(root);
    }
}
