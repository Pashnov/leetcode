package org.axp.medium;

import java.util.List;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class _153_FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
//        System.out.println(findMin(new int[]{4,5,6,7,8,9,10,11,12,0,1,2}));
//        System.out.println(findMin(new int[]{2,3,4,5,1}));
//        System.out.println(findMin(new int[]{3,4,5,1,2}));
//        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1 ) {
            return nums[0];
        }

        int startIndex = 0;
        int length = nums.length;

        while (true) {
            if (Math.min(nums[startIndex], nums[(startIndex + (length / 2))-1])
                    > Math.min(nums[startIndex + (length / 2)], nums[startIndex + length-1])) {
                // took right part
                startIndex = startIndex + (length / 2);
                if (length % 2 == 0) {
                    length /= 2;
                } else {
                    length = (length / 2) + 1;
                }
            } else {
                // took left part
                length /= 2;
            }

            if (length < 2 ) {
                return Math.min(
                        Math.min(nums[startIndex], nums[ ((startIndex + (length / 2))-1) < 0 ? 0 : (startIndex + (length / 2))-1]),
                        Math.min(nums[startIndex + (length / 2)], nums[startIndex + length-1]));
            }
        }
    }






    public static int findMin3(int[] nums) {
        if (nums.length == 1 ) {
            return nums[0];
        }

        int startIndex = 0;
        int length = nums.length;

        var leftMin = Math.min(nums[startIndex], nums[(length / 2)-1]);
        var rightMin = Math.min(nums[length / 2], nums[length-1]);

        while (true) {
            if (leftMin > rightMin) {
                // took right part
                startIndex = startIndex + (length / 2);
                if (length % 2 == 0) {
                    length /= 2;
                } else {
                    length = (length / 2) + 1;
                }
            } else {
                // took left part
                length /= 2;
            }

            if (length < 2 ) {
                return Math.min(leftMin, rightMin);
            }

            leftMin = Math.min(nums[startIndex], nums[(startIndex + (length / 2))-1]);
            rightMin = Math.min(nums[startIndex + (length / 2)], nums[startIndex + length-1]);
        }
    }




    public static int findMin2(int[] nums) {
        if (nums.length == 1 ) {
            return nums[0];
        }

        int startIndex = 0;
        int length = nums.length;

        int middleIndex = length / 2;

        var leftMin = Math.min(nums[startIndex], nums[middleIndex-1]);
        var rightMin = Math.min(nums[middleIndex], nums[length-1]);

        int min;

        while (true) {
            if (leftMin > rightMin) {
                // took right part
                min = rightMin;
                startIndex = middleIndex;
                if (length % 2 == 0) {
                    length /= 2;
                } else {
                    length = (length / 2) + 1;
                }
            } else {
                // took left part
                min = leftMin;
                length /= 2;
            }

            if (length < 2 ) {
                return min;
            }

            middleIndex = startIndex + (length / 2);

            leftMin = Math.min(nums[startIndex], nums[middleIndex-1]);
            rightMin = Math.min(nums[middleIndex], nums[startIndex + length-1]);
        }
    }


//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(4,5,6,7,8,9,10,11,12,0,1,2));
//        System.out.println(findSmallest(list));
//        for (int i = 0; i < list.size(); i++) {
//            Integer first = list.get(0);
//            list.remove(0);
//            list.add(first); // as last;
//            int smallest = findSmallest(list);
//            if (smallest != 0 ) {
//                System.out.println(" error: " + list);
//                break;
//            } else {
//                System.out.println(smallest);
//            }
//        }
//    }
//
    private static int findSmallest1(List<Integer> list) {
        if (list.size() == 1 ) {
            return list.get(0);
        }
//        System.out.println(list);
        int middleIndex = list.size() / 2;

        var leftMin = Math.min(list.get(0), list.get(middleIndex-1));

        var rightMin = Math.min(list.get(middleIndex), list.get(list.size()-1));

        int min;

        while (true) {
            if (leftMin > rightMin) {
                // took right part
                min = rightMin;
                list = list.subList(middleIndex, list.size());
            } else {
                // took left part
                min = leftMin;
                list = list.subList(0, middleIndex);
            }


            if (list.size() < 2 ) {
                return min;
            }

            middleIndex = list.size() / 2;

            leftMin = Math.min(list.get(0), list.get(middleIndex-1));
            rightMin = Math.min(list.get(middleIndex), list.get(list.size()-1));


        }
    }
}
