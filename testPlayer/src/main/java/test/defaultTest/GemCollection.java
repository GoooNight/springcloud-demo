package test.defaultTest;

import java.util.*;

/**
 * @author 雨天留恋
 * @date 2023-09-12 10:46
 * 图的遍历(广度)
 */
public class GemCollection {
    static int n;

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        List<Integer> res = new ArrayList<>();
        n = nums.length;
        permutations(nums,res);
    }

    public static void permutations(int[] nums,List<Integer> res){
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                res.remove(res.size() - 1);
            }
            int a = nums[i];
            res.add(a);
            int[] nums1 = new int[nums.length - 1];
            for (int j = 0,k = 0; j < nums.length - 1; j++,k++) {
                if (nums[j] == a){
                    k++;
                }
                nums1[j] = nums[k];
            }
            permutations(nums1, new ArrayList<>(res));
            if (res.size() == n){
                System.out.println(res);
            }
        }
    }
}