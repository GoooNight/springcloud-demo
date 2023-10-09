package taiLong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 雨天留恋
 * @date 2023-08-19 17:45
 */
public class Test01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int iter = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i< iter; i++) {
            Arrays.sort(arr);
            arr[n - 1] = arr[n- 1] * arr[n- 2];
            arr[n - 2] = 1;
        }


        System.out.println(Arrays.stream(arr).sum() % 1000000007);
    }
}
