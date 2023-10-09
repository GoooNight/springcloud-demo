package test.defaultTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

/**
 * @author 雨天留恋
 * @date 2023-06-15 15:46
 */
public class DefaultTest {

    static final int mod = (int) (1e9) + 7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        long a[] = Arrays.stream(in.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long res = 0;
        long right = 0;
        long sum = 0;
        for (int i = 1; i < n; i++) {
            right += (i * a[i])%mod;
            sum += a[i];
        }
        sum%=mod;
        for (int i = 0; i + 1 < n; i++) {
//            if (a[i] == 0) {
//                continue;
//            }
//            for(int j=i+1;j//                res+=(j-i)*a[i]*a[j];
//                res%=mod;
//            }
            res += (a[i]*right) % mod;
            right-=sum;
            sum-=a[i+1];
            res %= mod;

        }
        System.out.println(res);
    }





}



