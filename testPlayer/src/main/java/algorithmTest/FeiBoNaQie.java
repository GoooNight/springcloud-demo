package algorithmTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 雨天留恋
 */
public class FeiBoNaQie {

    public static int[] feiBoNaQie(int n) {
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            if(i == 0 || i == 1){
                results[i] = 1;
            }else{
                results[i] = results[i - 1] + results[i - 2];
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Arrays.toString(feiBoNaQie(n)));
    }

}
