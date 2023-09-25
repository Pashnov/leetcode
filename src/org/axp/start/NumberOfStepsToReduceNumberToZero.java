package org.axp.start;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/submissions/
public class NumberOfStepsToReduceNumberToZero {

    public static void main(String[] args) {
        int i = new NumberOfStepsToReduceNumberToZero().numberOfSteps(14);
        System.out.println(i);
    }

    public int numberOfSteps(int num) {
        int i = 0;
        while (num != 0) {
            i++;
            if ((num & 1) == 0) {
                num = num >> 1;
            } else {
                num -= 1;
            }
        }
        return i;
    }

    // stackoverflow
//    public int numberOfSteps(int num) {
//        return num == 1 ? 1
//                : (num & 1) == 0
//                    ? 1 + numberOfSteps(num >> 1)
//                    : 1 + numberOfSteps(num - 1);
//    }
}
