package org.axp.hard;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class _4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{2}) + " 2.0");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{1}) + " 1.0");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4,5}) + " 3.0");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[]{}) + " 3.0");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1}, new int[]{1}) + " expected 1.0");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}) + " expected 2.5");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,3}, new int[]{2,7}) + " expected 2.5");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{-1,3}) + " expected 1.5");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{2,3}) + " expected 2.5");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{1, 2,3, 4}) + " expected 2.5");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 4, 4}) + " expected 3.0");
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{2,3,4,5}, new int[]{}) + " expected 3.5");
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp;
        int tempLength;
        if ((nums1.length + nums2.length)% 2 == 0) {
            temp = new int[2];
            tempLength = (nums1.length + nums2.length+2) / 2;
        } else {
            temp = new int[1];
            tempLength = (nums1.length + nums2.length + 1) / 2;
        }
        for (int i=0, j=0; (i+j) < tempLength; ) {
            int ii = nums1.length > i ? nums1[i] : Integer.MAX_VALUE;
            int jj = nums2.length > j ? nums2[j] : Integer.MAX_VALUE;
            if (ii < jj) {
                pushElem(temp, ii);
                i++;
            } else {
                pushElem(temp, jj);
                j++;
            }
        }
        if ((nums1.length + nums2.length)% 2 == 0) {
            return (temp[temp.length-1] + temp[temp.length-2])/2.;
        } else {
            return temp[temp.length-1];
        }
    }

    public void pushElem(int[] arr, int elem) {
        if (arr.length == 2) {
            arr[0] = arr[1];
            arr[1] = elem;
        } else {
            arr[0] = elem;
        }
    }



    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int[] temp;
        if ((nums1.length + nums2.length)% 2 == 0) {
            temp = new int[(nums1.length + nums2.length+2) / 2];
        } else {
            temp = new int[(nums1.length + nums2.length + 1) / 2];
        }
        for (int i=0, j=0; (i+j) < temp.length; ) {
            int ii = nums1.length > i ? nums1[i] : Integer.MAX_VALUE;
            int jj = nums2.length > j ? nums2[j] : Integer.MAX_VALUE;
            if (ii < jj) {
                temp[i+j] = ii;
                i++;
            } else {
                temp[i+j] = jj;
                j++;
            }
        }
        if ((nums1.length + nums2.length)% 2 == 0) {
            return (temp[temp.length-1] + temp[temp.length-2])/2.;
        } else {
            return temp[temp.length-1];
        }
    }






    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findFromSingleArray(nums2, nums2.length/2, nums2.length % 2 == 0);
        } else if (nums2.length == 0) {
            return findFromSingleArray(nums1, nums1.length/2, nums1.length % 2 == 0);
        } else {
            return findMedianFrom2SortedArrays(nums1, nums2, (nums1.length + nums2.length)/2, (nums1.length + nums2.length)% 2 == 0);
        }
    }

    private double findMedianFrom2SortedArrays(int[] nums1, int[] nums2, int middleIndex, boolean even) {
        if (even) {
            int[] currentMiddle2Numbers = new int[2];
            int i = 0, j = 0;
            if (nums1[0] > nums2[0]) {
                if (nums2.length > 1 && nums1[0] > nums2[1]) {
                    currentMiddle2Numbers[0] = nums2[0];
                    currentMiddle2Numbers[1] = nums2[1];
                    j = 2;
                } else {
                    currentMiddle2Numbers[0] = nums2[0];
                    currentMiddle2Numbers[1] = nums1[0];
                    i=1;
                    j=1;
                }
            } else {
                if (nums1.length > 1 && nums2[0] > nums1[1]) {
                    currentMiddle2Numbers[0] = nums1[0];
                    currentMiddle2Numbers[1] = nums1[1];
                    i = 2;
                } else {
                    currentMiddle2Numbers[0] = nums1[0];
                    currentMiddle2Numbers[1] = nums2[0];
                    i=1;
                    j=1;
                }
            }
            for (; i < nums1.length || j < nums2.length; ) {
                // look ahead
                int ii = nums1.length > i ? nums1[i] : Integer.MAX_VALUE;
                int jj = nums2.length > j ? nums2[j] : Integer.MAX_VALUE;

                if ((middleIndex + 1) == (i + j)) {
                    return (currentMiddle2Numbers[0] + currentMiddle2Numbers[1]) / 2.;
                }

                if (ii < jj) {
                    currentMiddle2Numbers[0] = currentMiddle2Numbers[1];
                    currentMiddle2Numbers[1] = ii;
                    i++;
                } else {
                    currentMiddle2Numbers[0] = currentMiddle2Numbers[1];
                    currentMiddle2Numbers[1] = jj;
                    j++;
                }
            }
            return (currentMiddle2Numbers[0] + currentMiddle2Numbers[1]) / 2.;

        } else {
            int currentMiddleNumber;
            int i = 0, j = 0;
            if (nums1[0] > nums2[0]) {
                currentMiddleNumber = nums2[0];
                j = 1;
            } else {
                currentMiddleNumber = nums1[0];
                i = 1;
            }
            for (; i < nums1.length || j < nums2.length; ) {
                // look ahead
                int ii = nums1.length > i ? nums1[i] : Integer.MAX_VALUE;
                int jj = nums2.length > j ? nums2[j] : Integer.MAX_VALUE;

                if ((middleIndex+1) == (i + j)) {
                    return currentMiddleNumber;
                }

                if (ii < jj) {
                    currentMiddleNumber = ii;
                    i++;
                } else {
                    currentMiddleNumber = jj;
                    j++;
                }
            }
            return currentMiddleNumber;
        }
    }

    private double findFromSingleArray(int[] arr, int middleIndex, boolean even) {
        if (even) {
            return (arr[middleIndex] + arr[middleIndex-1])/2.;
        }
        return arr[middleIndex];
    }




    // hasn't started working
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int commonSize = nums1.length + nums2.length;
        int middleIndex = commonSize/2;
        boolean even = commonSize % 2 == 0;

        int[] last2Numbers = new int[2];
        boolean first = true;
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            int ii = nums1.length != 0 ? nums1[i] : Integer.MIN_VALUE;
            int jj = nums2.length != 0 ? nums2[j] : Integer.MIN_VALUE;
            if (even) {
                if (first) {
                    first = false;
                    if (nums1.length == 0 && nums2.length == 2) {
                        return (jj+nums2[j+1])/2.;
                    } else if (nums2.length == 0 && nums1.length == 2){
                        return (ii+nums1[i+1])/2.;
                    } else {
                        if (ii > jj) {
                            last2Numbers[0] = jj;
                            last2Numbers[1] = ii;
                        } else {
                            last2Numbers[0] = ii;
                            last2Numbers[1] = jj;
                        }
                    }
                } else {
                    if (last2Numbers[0] < ii && ii < last2Numbers[1]) {
                        last2Numbers[0] = ii;
                    } else if (last2Numbers[0] < jj && jj < last2Numbers[1]) {
                        last2Numbers[0] = jj;
                    } else {
                        if (ii > jj) {
                            last2Numbers[0] = last2Numbers[1];
                            last2Numbers[1] = ii;
                        } else {
                            last2Numbers[0] = last2Numbers[1];
                            last2Numbers[1] = jj;
                        }
                    }
                }

                if (nums1.length == 0 || nums2.length == 0) {
                    if ((middleIndex) == (i + j)) {
                        return (last2Numbers[0] + last2Numbers[1]) / 2.;
                    }
                } else {
                    if ((middleIndex - 1) == (i + j)) {
                        return (last2Numbers[0] + last2Numbers[1]) / 2.;
                    }
                }

                if (ii == jj ) {
                    if (i > j) {
                        j++;
                    } else {
                        i++;
                    }
                } else if ((ii > jj && nums2.length != 0) || i >= (nums1.length -1) ) {
                    j++;
                } else {
                    i++;
                }
            } else {
                if (first) {
                    first = false;
                    if (ii > jj) {
                        last2Numbers[0] = jj;
                        last2Numbers[1] = ii;
                    } else {
                        last2Numbers[0] = ii;
                        last2Numbers[1] = jj;
                    }
                } else {
                    if (last2Numbers[0] < ii && ii < last2Numbers[1]) {
                        last2Numbers[0] = ii;
                    } else if (last2Numbers[0] < jj && jj < last2Numbers[1]) {
                        last2Numbers[0] = jj;
                    } else {
                        if (ii > jj) {
                            last2Numbers[0] = last2Numbers[1];
                            last2Numbers[1] = ii;
                        } else {
                            last2Numbers[0] = last2Numbers[1];
                            last2Numbers[1] = jj;
                        }
                    }
                }

                if ((middleIndex) == (i+j)) {
                    if (nums1.length == 0 || nums2.length == 0) {
                        return Math.max(last2Numbers[0], last2Numbers[1]);
                    }
                    return Math.min(last2Numbers[0], last2Numbers[1]);
                }

                if (ii == jj ) {
                    if (i > j) {
                        j++;
                    } else {
                        i++;
                    }
                } else if ((ii > jj || nums1.length == 0) && nums2.length != 0) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return 0.;
    }


}
