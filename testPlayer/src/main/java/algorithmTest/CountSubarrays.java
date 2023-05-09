package algorithmTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 雨天留恋
 * @date 2023-03-16 18:24
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 *
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * 注意：
 *
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分
 *
 */
public class CountSubarrays {

    public int countSubarrays(int[] nums, int k) {
        // 结果集
        int result = 0;
        int index = 0;
        // 存储子数组中的中位数左右数字的个数
        HashMap<Integer, Integer> leftMap = new HashMap<>(nums.length);
        HashMap<Integer, Integer> rightMap = new HashMap<>(nums.length);
        // 初始化左右指针的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }
        int sum = 0;
        for (int i = index; i >=0; i--) {

            sum += ((nums[i]<nums[index]?1:0)-(nums[i]>nums[index]?1:0));
            if (leftMap.get(sum) == null) {
                leftMap.put(sum, 1);
            }else {
                leftMap.put(sum,leftMap.get(sum)+1);
            }
        }
        sum = 0;
        for (int i = index; i <nums.length; i++) {

            sum += ((nums[i]>nums[index]?1:0)-(nums[i]<nums[index]?1:0));
            if (rightMap.get(sum) == null) {
                rightMap.put(sum, 1);
            }else {
                rightMap.put(sum,rightMap.get(sum)+1);
            }
        }
        if (leftMap.size() > rightMap.size()){
            for (Integer sums : leftMap.keySet()) {
                if (rightMap.get(sums) != null) {
                    result += leftMap.get(sums) * rightMap.get(sums);
                }
                if (rightMap.get(sums+1) != null){
                    result += leftMap.get(sums) * rightMap.get(sums+1);
                }
            }
        }else {
            for (Integer sums : rightMap.keySet()) {
                if (leftMap.get(sums) != null) {
                    result += leftMap.get(sums) * rightMap.get(sums);
                }
                if (leftMap.get(sums-1) != null){
                    result += rightMap.get(sums) * leftMap.get(sums-1);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14};
        int k = 6;
        System.out.println(new CountSubarrays().countSubarrays(nums, k));
    }
}

