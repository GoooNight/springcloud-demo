package algorithmTest;

import java.util.HashMap;

/**
 * @author 雨天留恋
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        // 建立一个索引map
        HashMap<Character, Integer> resultMap = new HashMap<>(5);
        int length = 0;
        // 当前字符串的字符数组
        char[] sChars = s.toCharArray();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (resultMap.containsKey(sChars[end])) {
                start =Math.max(resultMap.get(sChars[end])+1, start);
            }
            length = Math.max(length,end - start + 1);
            resultMap.put(sChars[end],end);
            end ++ ;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
