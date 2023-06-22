package algorithmTest;

import java.util.HashMap;

/**
 * @author 雨天留恋
 * @date 2023-05-24 15:09
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 * <p>
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。
 * <p>
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10-5 的结果将被视为正确答案。
 */
public class FrogPosition {

    /**
     * @param n:      节点数量
     * @param edges:  无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。
     * @param t:      多少次
     * @param target: 目标节点
     * @return double
     * @author 雨天留恋
     * @description TODO 暴力破解
     * @date 2023/5/24 15:09
     */
    public static double frogPosition(int n, int[][] edges, int t, int target) {
        // 由于1是顶点，因此，可以通过判断顶点1的位置判断树的正反
        int first = 0, last = 1;

        for (int[] edge : edges) {
            if (edge[1] == 1) {
                first = 1;
                last = 0;
                break;
            }
        }

        // 使用一个hashmap，保存每个节点跳转的概率
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.merge(edge[first], 1, Integer::sum);
        }
        // 找到是否存在这条通路，从起点开始，经过t-1个点，到达终点target
        // 第一步找到这条通路
        // 首先设置每个节点的前置节点
        int preNode = target;
        // 找到后把这条边存储到数组中
        int[][] resEdges = new int[n][2];
        // 数组的下表
        int index = 0;
        // 从target节点开始找
        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                // 判断当前边是否与前置节点相连
                if (edge[last] == preNode) {
                    // 重新赋值前置节点
                    preNode = edge[first];
                    // 把找到的边存到数组中
                    resEdges[index++] = new int[]{edge[first], edge[last]};
                    break;
                }
            }
            // 已经是根节点了，跳出循环
            if (preNode == 1) {
                break;
            }
        }
        // 全部遍历完后，查看通路是否成立
        if (index > t) {
            return 0;
        }
        // 不能停留在原地
        if (index < t && map.get(target)!=null) {
            return 0;
        }

        double res = 1;
        for (int i = 0; i < index; i++) {
            res *= 1.0 / map.get(resEdges[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(frogPosition(4, new int[][]{{2,1},{3,2},{4,3}}, 2, 3));
    }
}
