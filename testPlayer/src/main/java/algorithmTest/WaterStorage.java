package algorithmTest;

/**
 * @author 雨天留恋
 * @date 2023-03-10 20:13
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 *
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 *
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * 大佬的思路是，将问题思路转变为，如果我要 i 次装满所有的水缸，我各个位置的水桶都需要多大才行，即（bucket）的大小。
 *
 * 比如当 i = 1 的时候，即为倒一次水即可全部装满。就以实例1来说，那么，一次装满水，vat[0] = 6，bucket[0] = 1，
 * 所以相除，需要的bucket大小为6，原本为1，所以需要5次（6 - 1）扩容机会。vat[1] = 8, bucket[1] = 3，
 * 所以需要的bucket大小为8，需要5次扩容机会。总扩容次数为10次，装水次数为1，总操作次数为11。
 *
 */
public class WaterStorage {
    public int storeWater(int[] bucket, int[] vat) {
        int flag = 0;
        for (int i : vat) {
            if(i != 0){
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return 0;
        }
        int ans = 10000000;
        int sum = 0;
        for (int i = 1; i < 100000; i++) {
            sum = i;
            if (i >= ans) {
                break;
            }
            for (int j = 0; j < bucket.length; j++) {
                sum += Math.max(0, (vat[j] + i - 1) / (i) - bucket[j]);
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] bucket = new int[]{0};
        int[] vat = {0};
        System.out.println(new WaterStorage().storeWater(bucket, vat));
    }
}
