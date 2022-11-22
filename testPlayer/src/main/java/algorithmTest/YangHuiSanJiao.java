package algorithmTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 雨天留恋
 */
public class YangHuiSanJiao {


    public static int[][] getYangHuiSanJiao(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    result[i][j] = 1;
                }else {
                    result[i][j] = result[i-1][j] + result[i-1][j-1];
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Arrays.deepToString(getYangHuiSanJiao(n)));
    }

}
