package org.axp.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
public class _1299_ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        System.out.println("in: " + Arrays.toString(arr));
        System.out.println("exp:[18, 6, 6, 6, 1, -1]");
        System.out.println("out:" +Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        var currentGreatestElement = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        if (arr.length == 1) {
            return arr;
        }
        var temp = 0;
        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (arr[i] > currentGreatestElement) {
                temp = arr[i];
                arr[i] = currentGreatestElement;
                currentGreatestElement = temp;
            } else {
                arr[i] = currentGreatestElement;
            }
        }
        return arr;
    }
}
