package algorithmTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 * 最长等差数列
 * 没做出来
 */
public class LongestArithSeqLength {
    public static int longestArithSeqLength(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashMap<Integer, List<Map.Entry<Integer,Integer>>> map = new HashMap<>(8);
        int length = 2;
        for (int i = 0; i < collect.size(); i++) {
            for (int j = i + 1; j < collect.size(); j++) {
                List<Map.Entry<Integer, Integer>> entryList = map.get(collect.get(i) - collect.get(j));
                if (map.get(collect.get(i)-collect.get(j))!=null) {
//                    entryList.add(new Entry);
                }
            }
        }


        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestArithSeqLength(new int[]{44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28}));
    }
}
