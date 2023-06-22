package algorithmTest;

import java.util.HashMap;

/**
 * @author 雨天留恋
 * @date 2023-06-06 14:32
 */
public class EqualPairs {
    public static int equalPairs(int[][] grids) {
        int result = 0;
        // 行map，记录每种行元素出现的个数
        HashMap<String, Integer> rowMap = new HashMap<>(200);
        // 列map，记录每列与行匹配的个数
        HashMap<String, Integer> columnMap = new HashMap<>(200);
        for (int i = 0; i < grids[0].length; i++) {
            StringBuilder s = new StringBuilder();
            for (int i1 : grids[i]) {
                s.append(i1);
                s.append(",");
            }
            rowMap.merge(s.toString(), 1, Integer::sum);
        }
        for (int i = 0; i < grids[0].length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < grids[0].length; j++) {
                s.append(grids[j][i]);
                s.append(",");
            }
            if (rowMap.get(s.toString()) != null) {
                columnMap.merge(s.toString(),rowMap.get(s.toString()), Integer::sum);
            }
        }
        for (Integer value : columnMap.values()) {
            result += value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println(equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }
}
