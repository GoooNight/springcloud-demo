package algorithmTest;

/**
 * @author 雨天留恋
 * @date 2023-03-18 13:21
 * 1616. 分割两个字符串得到回文串
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由
 * b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 *
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c"
 * 和 "abc" + "" 都是合法分割。
 *
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 *
 * 注意， x + y 表示连接字符串 x 和 y 。
 */
public class CheckPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }

        for (int i = 0,j = b.length()-1; i < a.length(); i++,j--) {
            if (a.charAt(i) != b.charAt(j)) {
                if (isPalindrome(a.substring(0, i) + b.substring(i))) {
                    return true;
                }
                if (j != b.length()-1 && isPalindrome(a.substring(0, j+1) + b.substring(j+1))) {
                    return true;
                }
                break;
            }
            if (j == 0){
                return true;
            }
        }
        for (int i = 0,j = b.length()-1; i < a.length(); i++,j--) {
            if (a.charAt(j) != b.charAt(i)) {
                if (isPalindrome(b.substring(0, i) + a.substring(i))) {
                    return true;
                }

                if (j != b.length()-1 && isPalindrome(b.substring(0, j+1) + a.substring(j+1))) {
                    return true;
                }
                break;
            }
            if (j == 0){
                return true;
            }
        }


        return false;
    }

    /***
     * @param string:
     * @return boolean
     * @author 雨天留恋
     * @description 回文判断
     * @date 2023/3/18 13:44
     */
    public boolean isPalindrome(String string) {
        for (int i = 0,j=string.length()-1; i < string.length()/2; i++,j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new CheckPalindromeFormation().checkPalindromeFormation(
                "abc","cba"));
    }

}
