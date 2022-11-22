package algorithmTest;

import java.util.HashMap;

/**
 * @author 雨天留恋
 * 亲密字符串
 */
public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        char aChar = 0;
        char bChar = 0;
        int index = 0;
        HashMap<Character, Integer> map = new HashMap<>(8);
        boolean flag = false;
        for (int i = 0; i < goal.length(); i++) {
            if (!flag) {
                if (map.get(goal.charAt(i)) != null) {
                    map.put(goal.charAt(i), map.get(goal.charAt(i)) + 1);
                    flag = true;
                } else {
                    map.put(goal.charAt(i), 1);
                }
            }
            if (goal.charAt(i) != s.charAt(i)) {
                if (index == 2) {
                    return false;
                } else if (index == 0) {
                    aChar = s.charAt(i);
                    bChar = goal.charAt(i);
                    index++;
                } else if (index == 1) {
                    if (aChar != goal.charAt(i)) {
                        return false;
                    }
                    if (bChar != s.charAt(i)) {
                        return false;
                    }
                    index++;
                }
            }
        }
        if (index == 2) {
            return true;
        } else if (index == 1) {
            return false;
        } else {
            return flag;
        }
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("abac", "abad"));
    }
}
