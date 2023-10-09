package test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 * @date 2023-03-10 20:38
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int pre = 0;
        int last = 0;
        int res = 0;
        long sum = 0;
        while (last < n) {
            sum +=  a[last];
            if (sum < (long) (last - pre + 1) *k){
                last ++;
                continue;
            }
            if (sum == (long) (last - pre + 1) * k){
                res = Math.max(res,last-pre+1);
            }
            if (sum > (long) (last - pre + 1) *k){
                if (pre < last){
                    sum -= a[pre];
                    pre ++;
                    sum -= a[last];
                } else if (pre == last){
                    last++;
                }
                continue;
            }
            last ++ ;
        }
        System.out.println(res>0?res:-1);

    }
}


