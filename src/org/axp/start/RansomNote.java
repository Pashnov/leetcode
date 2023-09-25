package org.axp.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/ransom-note/
public class RansomNote {

    public static void main(String[] args) {
//        System.out.println(new RansomNote().canConstruct("read", "daaedr"));
//        System.out.println(new RansomNote().canConstruct("read", "daaed"));
//         System.out.println(new RansomNote().canConstruct("a", "a"));
         System.out.println(new RansomNote().canConstruct(
                 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                 "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println(new RansomNote().canConstruct("read", "daaed"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        char[] letters = magazine.toCharArray();
        int lettersSize = letters.length;
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            int charIndex = -1;
            for (int j = 0; j < lettersSize; j++) {
                if (letters[j] == c) {
                    charIndex = j;
                    if (j != (lettersSize -1)) {
                        System.arraycopy(letters, j + 1, letters, j, lettersSize - j-1);
                    }
                    lettersSize--;
                    break;
                }
            }
            if (charIndex < 0) {
                return false;
            }
        }
        return true;
    }

//    public boolean canConstruct(String ransomNote, String magazine) {
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char c = ransomNote.charAt(i);
//            int charIndex = magazine.indexOf(c);
//            if (charIndex == 0) {
//
//                magazine = magazine.substring(1);
//            } else if (charIndex > 0) {
//                magazine = magazine.subSequence(0, charIndex) + magazine.substring(charIndex+1);
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean canConstruct(String ransomNote, String magazine) {
//        StringBuilder sb = new StringBuilder(magazine);
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char c = ransomNote.charAt(i);
//            int charIndex = sb.indexOf(c+"");
//            if (charIndex >= 0) {
//                sb.deleteCharAt(charIndex);
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character, Long> letters = magazine.chars()
//                .mapToObj(charInt -> (char) charInt)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char c = ransomNote.charAt(i);
//            Long l = letters.get(c);
//            if (Objects.nonNull(l) && l > 0) {
//                letters.put(c, l-1);
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
}
