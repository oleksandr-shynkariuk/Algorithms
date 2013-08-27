package algorithms.trees;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);

        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        three.setRight(seven);
        four.setLeft(eight);
        four.setRight(nine);
        five.setLeft(ten);

        System.out.println("In-order:");
        Node.inOrder(one);

        System.out.println("\nPre-order:");
        Node.preOrder(one);

        System.out.println("\nPost-order:");
        Node.postOrder(one);

        System.out.println("\nLevel-order:");
        Node.levelOrder(one);

        System.out.println("\nLevel-order in O(n^2):");
        Node.levelOrderRec(one);
    }
}
