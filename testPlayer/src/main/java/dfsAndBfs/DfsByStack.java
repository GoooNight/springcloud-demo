package dfsAndBfs;

import java.util.Stack;

/**
 * @author 雨天留恋
 * @date 2023-04-18 11:16
 * 用栈实现深度优先遍历不用会象递归那样层级过深导致的栈溢出问题
 * <p>
 * 具体示例查看树一章案例中的Tree类中的displayTree 方法
 */
public class DfsByStack {
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

    public static void dfsWithStack(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        // 先把根节点压栈
        stack.push(root);
        while (!stack.isEmpty()) {
            Node treeNode = stack.pop();
            // 遍历节点
            process(treeNode);

            // 先压右节点
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            // 再压左节点
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    private static void process(Node treeNode) {
        System.out.println(treeNode.value);
    }


}
