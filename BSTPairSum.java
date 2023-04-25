import java.util.HashSet;
import java.util.Stack;


public class BSTPairSum {


    public static void findPair(Node root, int sum) {
        if (root == null) {
            System.out.println("Nodes are not found");
            return;
        }


        HashSet<Integer> set = new HashSet<Integer>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);


        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (set.contains(sum - node.value)) {
                System.out.println("Pair is (" + node.value + "," + (sum - node.value) + ")");
                System.out.println("Sum is " + sum);
                return;
            }
            set.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }


        System.out.println("Nodes are not found");
    }


    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right = new Node(60);
        root.right.left = new Node(50);
        root.right.right = new Node(70);


        int sum = 130;
        findPair(root, sum);
    }
}


class Node {
    int value;
    Node left, right;


    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}