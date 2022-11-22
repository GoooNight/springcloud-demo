package algorithmTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 雨天留恋
 */
public class TwoNumSum {

    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        HashMap<Integer, Integer> dataUsed = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {
            if (dataUsed.get(target - nums[i])!=null) {
                index[0] = dataUsed.get(target - nums[i]);
                index[1] = i;
            }
            dataUsed.put(nums[i],i);
        }
        return index;
    }

    public static void main(String[] args) {
        List<Integer> b = new ArrayList<>();
        b.add(2);
        List<Integer> a = b;
        b = new ArrayList<>();
        b.add(3);
        System.out.println(a);
        System.out.println(b);
    }
}
