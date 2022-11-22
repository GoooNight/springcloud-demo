package algorithmTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 雨天留恋
 * 最大相等频率
 */
public class MaxEqualFreq {
    public static int maxEqualFreq(int[] nums) {
        HashMap<Integer, Integer> map1 = new HashMap<>(8);
        HashMap<Integer, Integer> map2 = new HashMap<>(8);
        int result = 0;
        for (int num : nums) {
            if (map1.containsKey(num)) {
                Integer val = map1.get(num);
                map1.put(num, val + 1);
                if (map2.containsKey(val + 1)) {
                    Integer val2 = map2.get(val + 1);
                    map2.put(val + 1, val2 + 1);
                } else {
                    map2.put(val + 1, 1);
                }
            } else {
                map1.put(num, 1);
                if (map2.containsKey(1)) {
                    Integer val2 = map2.get(1);
                    map2.put(1, val2 + 1);
                } else {
                    map2.put(1, 1);
                }
            }
        }
        System.out.println(map2);
        Map.Entry<Integer, Integer> entry = map2.entrySet().stream().max(Comparator.comparing(o -> o.getKey() * o.getValue())).get();
        result = entry.getValue() * entry.getKey();
        if (result == nums.length) {
            if (entry.getKey() == 1) {
                return result;
            } else if (entry.getKey() == 2) {
                result = result - 1;
            } else {
                result = map2.get(entry.getKey() - 1) * (entry.getKey() - 1) + 1;
            }
        }else {
            if (entry.getKey() == 1) {
                return result;
            } else if (entry.getKey() == 2) {
                result = result + 1;
            } else {
                result = map2.get(entry.getKey() - 1) * (entry.getKey() - 1) + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}));
    }
}
