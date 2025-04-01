package org.axp.easy;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://leetcode.com/problems/valid-anagram/description/
public class _242_ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("ab", "a"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)%26]++;
            counts[t.charAt(i)%26]--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Long> collect = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long count = t.chars().boxed().filter(tt -> {
            Long l = collect.computeIfPresent(tt, (k, v) -> v - 1L);
            return l != null && l >= 0;
        }).count();
        return count == t.length();
    }
}
