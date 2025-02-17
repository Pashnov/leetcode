package org.axp.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _53_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums) + " ->6");

        nums = new int[]{1};
        System.out.println(maxSubArray(nums) + " ->1");

//        nums = new int[]{5,4,-1,7,8};
//        System.out.println(maxSubArray(nums) + " ->23");
//
//        nums = new int[]{-2,1};
//        System.out.println(maxSubArray(nums) + " -> 1");
//
//        nums = new int[]{-2,-1};
//        System.out.println(maxSubArray(nums) + " -> -1");

        nums = new int[]{-1,-2,-3};
        System.out.println(maxSubArray(nums) + " -> -1");

        nums = new int[]{1,2};
        System.out.println(maxSubArray(nums) + " -> 3");

    }

    // from python
    public static int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;

        for (int n : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }

    public static int maxSubArray1(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum < nums[i] && currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
