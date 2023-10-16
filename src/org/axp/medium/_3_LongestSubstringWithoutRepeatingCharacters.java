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
