package algorithmTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).sorted().distinct().boxed().collect(Collectors.toList());
        int length = 0;
        for (int start = 0,end = 0; end < collect.size(); end++) {
            if (end!=0 && !collect.get(end).equals(collect.get(end - 1)+1) ) {
                start = end;
            }
            length = Math.max(length, end - start +1);
        }
        return length;
    }
}
