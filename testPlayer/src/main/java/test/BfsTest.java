package test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 雨天留恋
 * @date 2023-04-18 14:47
 */
public class BfsTest {
    @Data
    @AllArgsConstructor
    private static class Node {
        private int value;
        private Node left;
        private Node right;
    }

    public static void bfs(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(treeNode);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            System.out.println(node.getValue());
            if (node.getLeft() != null) {
                nodeQueue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodeQueue.add(node.getRight());
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
        bfs(node4);
    }

}
