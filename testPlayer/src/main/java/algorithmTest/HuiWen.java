package algorithmTest;

/**
 * @author 雨天留恋
 */
public class HuiWen {

    public static boolean isHuiWen(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i -1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHuiWen("abbvbba"));
    }
}
