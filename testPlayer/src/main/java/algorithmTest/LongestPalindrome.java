package algorithmTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 * 409. 最长回文串
 *
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int l = (int)map.values().stream()
                .filter(value -> value % 2 == 1).count();


        return l > 0?s.length() - l + 1:s.length();
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(s.length());
        System.out.println(longestPalindrome(s));
    }
}