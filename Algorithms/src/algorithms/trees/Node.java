package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Oleksandr Shynkariuk oleksandr.shynkariuk@gmail.com
 * Represent a tree node
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int d){
        this.data = d;
    }
    public Node left(){
        return left;
    }
    public Node right(){
        return right;
    }
    public int data(){
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * in-order traversal:
     * traverse left node, current node, then right node
     * Usage: in a BST prints sorted sequence -> easy way to check if a given tree is BST!
     * */
    public static void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data() + "->");
            inOrder(node.right);
        }
    }

    /**
     * Pre-order tree traversal
     * traverse current node, then left, then right node.
     * Usage: create a copy of the tree, get prefix expression on of an expression tree (Polish Notation)
     * */
    public static void preOrder(Node node){
        if(node != null){
            System.out.print(node.data() + "->");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * Post-order tree traversal
     * traverse left node, then right, then current node
     * Usage: delete a tree, get the postfix expression of an expression tree (Reverse Polish Notation)
     * */
    public static void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data() + "->");
        }
    }

    /**
     Level order tree traversal
     1) Create an empty queue q
     2) temp_node = root
     3) Loop while temp_node is not NULL
        a) print temp_node->data.
        b) Enqueue temp_node’s children (first left then right children) to q
        c) Dequeue a node from q and assign it’s value to temp_node
     Usage: typical BFS -> may compute shortest paths; explores tree in layers(levels).
     O(n)
     */
    public static void levelOrder(Node node){
        Queue<Node> queue = new ArrayDeque<Node>(9);
        while(node != null){
            System.out.print(node.data() + "->");
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            node = queue.poll();
        }
    }

    /**
     * Level order without stack using recursion.
     * Algorithm:
     There are basically two functions in this method.
     - One is to print all nodes at a given level (printGivenLevel),
     - and other is to print level order traversal of the tree (printLevelorder).
     printLevelorder makes use of printGivenLevel to print nodes at all levels one by one starting from root.

     printLevelorder(tree)
        for d = 1 to height(tree)
            printGivenLevel(tree, d);

     printGivenLevel(tree, level)
        if tree is NULL then return;
        if level is 1, then
            print(tree->data);
        else if level greater than 1, then
            printGivenLevel(tree->left, level-1);
            printGivenLevel(tree->right, level-1);

     * O(n^2)
     * */
    public static void levelOrderRec(Node node){
        //for(int i = 0; i < height(node); ++i){
        for(int i = 0; i <= getHeight(node); ++i){
            printGivenLevel(node, i);
        }
    }

    private static void printGivenLevel(Node node, int level){
        if(node == null)
            return;
        if(level == 1)
            System.out.print(node.data() + "->");
        else if(level > 1){
            printGivenLevel(node.left(), level - 1);
            printGivenLevel(node.right(), level - 1);
        }
    }

    private static int height(Node node){
        if(node == null)
            return 0;
        else {
            int lheight = height(node.left);
            int rheight = height(node.right);

            if(lheight > rheight)
                return (lheight + 1);
            return (rheight + 1);
        }
    }

    private static int getHeight(Node node){
        if(node == null) return 0;
        else {
            int val = 1 + Math.max(getHeight(node.left), getHeight(node.right));
            return val;
        }
    }

    /**
     * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
     * */
    public static boolean printAncestorsRec(Node node, int data){
        if(node == null)
            return false;
        if(node.data() == data)
            return true;
        if(printAncestorsRec(node.left(), data) || printAncestorsRec(node.right(), data)) {
            System.out.print(node.data() + " ");
            return true;
        }
        return false;
    }

    public static void printAncestors(Node node, int data){
        if(node == null)
            return;
        Stack<Node> stack = new Stack<Node>(); //stack for holding the ancestors

        // Traverse the complete tree in post-order way till we find the key
        while(true){
            // Traverse the left side. While traversing, push the nodes into
            // the stack so that their right subtrees can be traversed later
            if(node != null)
                System.out.println("Node here: " + node.data());
            else
                System.out.println("Node here is null");
            while(node != null && node.data() != data){
                stack.push(node);         // push current node
                node = node.left();       //move to net node
                print(stack);
            }

            // If the node whose ancestors are to be printed is found,
            // then break the while loop.
            if(node != null && node.data() == data)
                break;

            // Check if right sub-tree exists for the node at top
            // If not then pop that node because we don't need this
            // node any more.
            if(stack.peek().right() == null){
                node = stack.pop();

                // If the popped node is right child of top, then remove the top
                // as well. Left child of the top must have processed before.
                if(!stack.empty() && stack.peek().right() == node)
                    node = stack.pop();
            }

            // if stack is not empty then simply set the root as right child
            // of top and start traversing right sub-tree.
            if(stack.empty())
                node = null;
            else
                node = stack.peek().right();
        }

        print(stack);
    }

    private static void print(Stack<Node> stack){
        for(Node node : stack){
            System.out.print(node.data() + " ");
        }
        System.out.println();
    }
}
