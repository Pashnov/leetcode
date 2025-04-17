package org.axp.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
public class _1_TwoSum {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search  = target - nums[i];
            if (valueIndex.containsKey(search)) {
                return new int[]{valueIndex.get(search), i};
            } else {
                valueIndex.put(nums[i], i);
            }
        }
        throw new RuntimeException("no two sum solution");
    }
}
