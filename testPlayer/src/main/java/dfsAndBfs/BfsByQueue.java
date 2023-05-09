package dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 雨天留恋
 * @date 2023-04-18 11:18
 * 使用队列实现 bfs
 */
public class BfsByQueue {
    private static class Node {

        public int value; //节点值
        public Node left;  //左节点
        public Node right; //右节点

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    private static void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("value = " + node.value);
            Node left = node.left;
            if (left != null) {
                queue.add(left);
            }
            Node right = node.right;
            if (right != null) {
                queue.add(right);
            }
        }
    }
}
