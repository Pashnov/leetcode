package org.axp.start;

// https://leetcode.com/problems/running-sum-of-1d-array/submissions/1055460515/
public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
