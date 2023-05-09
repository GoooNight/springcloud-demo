package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.Node;

import java.util.Stack;

/**
 * @author 雨天留恋
 * @date 2023-04-18 14:28
 */
public class DfsTest {

    @Data
    @AllArgsConstructor
    private static class Node {
        private int value;
        private Node left;
        private Node right;
    }

    public static void dfs(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.getValue());
        dfs(treeNode.getLeft());
        dfs(treeNode.getRight());
    }

    public static void dfsByStack(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(treeNode);
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            System.out.println(node.getValue());
            if (node.getRight() != null) {
                nodeStack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                nodeStack.push(node.getLeft());
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node5 = new Node(5, node6, node7);
        Node node4 = new Node(4, node3, node5);
        dfsByStack(node4);



    }

}
