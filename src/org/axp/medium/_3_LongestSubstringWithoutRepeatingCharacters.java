package org.axp.medium;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb") + " == 3");
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb") + " == 1");
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew") + " == 3");
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcd") + " == 4");
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcda") + " == 4");
        System.out.println(new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("ohvhjdml") + " == 6");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        var longestSubstringSize = 1;
        var startI = 0;
        main: for (int i = 1; i < s.length(); i++) {
            for (int j = startI; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    startI = j + 1;
                    continue main;
                }
            }
            if (i - startI >= longestSubstringSize) {
                longestSubstringSize++;
            }
        }

        return longestSubstringSize;
    }

    // Max's
    public int lengthOfLongestSubstring_(String s) {
        char[] chars = s.toCharArray();
        int currentLenght = 0;
        int maxLength = 0;
        int l = 0, r = 0;
        for (int i = 1; i <= chars.length; i++) {
            r = i;
            String substring = s.substring(l, r - 1);
            if (substring.contains(String.valueOf(chars[i]))) {
                currentLenght = r - l;
                maxLength = currentLenght > maxLength ? currentLenght : maxLength;
                l = l + substring.indexOf(chars[i]) + 1;
            }
        }

        return maxLength > 0 ? r - l : maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        int startIndex = 0;
        main:for (int i = 0; i < s.length(); i++) {
            if (startIndex == i) {
                result = 1;
            } else {
                char c = s.charAt(i);
                if (c == s.charAt(startIndex)){
                    startIndex++;
                } else {
                    for (int j = i - 1; j >= startIndex; j--) {
                        if (c == s.charAt(j)) {
                            startIndex = j+1;
                            continue main;
                        }
                    }
                    if ((i - startIndex + 1) > result) {
                        result = i - startIndex + 1;
                    }
                }
            }
        }
        return result;
    }
}
