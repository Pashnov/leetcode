package org.axp.easy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/?envType=daily-question&envId=2023-10-01
public class _557_ReverseWordsInAStringlll {

    public static void main(String[] args) {
        System.out.println(new _557_ReverseWordsInAStringlll().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        return Stream.of(s.split(" "))
                .parallel()
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
