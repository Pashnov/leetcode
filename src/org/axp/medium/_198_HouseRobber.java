package org.axp.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/house-robber/description/
public class _198_HouseRobber {

    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("start");
        int[] nums = new int[] {1, 2, 3, 1};
//        System.out.println("4 " + rob(nums));
//
//        nums = new int[] {2,7,9,3,1};
//        System.out.println("12 "+rob(nums));
//
//        nums = new int[] {1,3,1};
//        System.out.println("3 "+rob(nums));
//
//        nums = new int[] {2,1,1,2};
//        System.out.println("4 "+rob(nums));

        nums = new int[] {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        System.out.println("xxx "+rob(nums));
    }

    public static int rob(int[] nums) {
        cache.clear();
//        return rob(nums, 0, "root");
        return rob(nums, 0);
    }

//    public static int rob(int[] nums, int startIndex, String part) {
    public static int rob(int[] nums, int startIndex) {
        if (cache.containsKey(startIndex)) {
            return cache.get(startIndex);
        }
//        System.out.println("len=" + nums.length + ",six=" +startIndex + "," + part);
        if (nums.length == 0 || (nums.length - startIndex) <= 0) {
            cache.put(startIndex, 0);
            return 0;
        }
        if (nums.length == 1) {
            cache.put(startIndex, nums[0]);
            return nums[0];
        }
        if ((nums.length - startIndex)  == 1) {
            cache.put(startIndex, nums[startIndex]);
            return nums[startIndex];
        }
        if (nums.length == 2) {
            cache.put(startIndex, nums[0] > nums[1] ? nums[0] : nums[1]);
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        if ((nums.length - startIndex)  == 2) {
            if (nums[startIndex] > nums[startIndex + 1]) {
                cache.put(startIndex, nums[startIndex]);
                return nums[startIndex];
            } else {
                cache.put(startIndex, nums[startIndex+1]);
                return nums[startIndex + 1];
            }
        }

//        int leftSum = nums[startIndex] +    rob(nums, startIndex + 2, part+"Left");
//        int rightSum = nums[startIndex+1] + rob(nums, startIndex + 3, part+"Right");

        int leftSum = nums[startIndex] +    rob(nums, startIndex + 2);
        int rightSum = nums[startIndex+1] + rob(nums, startIndex + 3);

        cache.put(startIndex, Math.max(leftSum, rightSum));
        return Math.max(leftSum, rightSum);
    }
}
