package dfsAndBfs;

/**
 * @author 雨天留恋
 * @date 2023-04-18 11:15
 * 递归实现DFS
 */
public class DFSByRecursion {

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

    public static void dfs(Node treeNode) {
        if (treeNode == null) {
            return;
        }
        // 遍历节点
        process(treeNode);
        // 遍历左节点
        dfs(treeNode.left);
        // 遍历右节点
        dfs(treeNode.right);
    }

    private static void process(Node treeNode) {
        System.out.println(treeNode.value);
    }
}
