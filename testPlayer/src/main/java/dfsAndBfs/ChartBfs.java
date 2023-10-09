package dfsAndBfs;

import java.util.*;

/**
 * @author 雨天留恋
 * @date 2023-09-12 19:40
 */
public class ChartBfs {
    public static void main(String[] args) {
        Map<String, String[]> map = new HashMap<>();
        map.put("1",new String[]{"2","3","4"});
        map.put("2",new String[]{"1","4"});
        map.put("3",new String[]{"1"});
        map.put("4",new String[]{"1","2"});
        chart(map, "4");
    }

    public static void chart(Map<String, String[]> map, String first){
        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(first);
        while (!queue.isEmpty()){
            String node = queue.poll();
            if (visited.get(node) == null) {
                System.out.println(node);
                visited.put(node, 1);
                if (map.get(node)!= null && map.get(node).length > 0){
                    String[] s = map.get(node);
                    queue.addAll(Arrays.asList(s));
                }
            }
        }
    }
}
