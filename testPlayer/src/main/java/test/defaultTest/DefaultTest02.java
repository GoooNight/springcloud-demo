package test.defaultTest;

import javax.swing.plaf.metal.MetalTheme;

/**
 * @author 雨天留恋
 * @date 2023-09-25 18:37
 */
public class DefaultTest02 {

    public static void main(String[] args) {
        // System.out.println(total(new int[]{10, 15, 20}));
        System.out.println(total(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public static int total(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int i = 0; i < cost.length; i++) {
            if (i == 0) {
                dp[i+1] = Math.min(cost[i],0);
            } else if (i == 1) {
                dp[i+1] = Math.min(cost[i - 1], cost[i]);

            }else {
                dp[i+1] = Math.min(dp[i]+cost[i],dp[i-1] + cost[i-1]);
            }
        }
        return dp[cost.length];
    }


}
