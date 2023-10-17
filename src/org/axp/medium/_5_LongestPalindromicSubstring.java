package org.axp.medium;

// https://leetcode.com/problems/longest-palindromic-substring/
public class _5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new _5_LongestPalindromicSubstring().longestPalindrome("babad") + " == bab");
        System.out.println(new _5_LongestPalindromicSubstring().longestPalindrome("cbbd") + " == bb");
        System.out.println(new _5_LongestPalindromicSubstring().longestPalindrome("abb") + " == bb");
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        char[] s1 = s.toCharArray();
        s = null;

        var result = new char[]{s1[0]};
        for (int i = 1; i < s1.length - (result.length/2); i++) {
            // pair
            char r,l;
            for (int jl = i-1, jr = i; jl >= 0 && jr < s1.length; jl--, jr++) {
                r = s1[jr];
                l = s1[jl];
                if (r == l) {
                    if (jr-jl+1 > result.length) {
                        result = new char[jr-jl+1];
                        System.arraycopy(s1,jl,result,0,jr+1-jl);
                    }
                } else {
                    break;
                }
            }
            // even
            for (int jl = i-1, jr = i+1; jl >= 0 && jr < s1.length; jl--, jr++) {
                r = s1[jr];
                l = s1[jl];
                if (r == l) {
                    if (jr-jl+1 > result.length) {
                        result = new char[jr-jl+1];
                        System.arraycopy(s1,jl,result,0,jr+1-jl);
                    }
                } else {
                    break;
                }
            }

        }
        return new String(result);
    }


    public String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        var result = s.substring(0, 1);
        for (int i = 1; i < s.length() - (result.length()/2); i++) {
            // pair
            for (int jl = i-1, jr = i; jl >= 0 && jr < s.length(); jl--, jr++) {
                var r = s.charAt(jr);
                var l = s.charAt(jl);
                if (r == l) {
                    if (jr-jl+1 > result.length()) {
                        result = s.substring(jl, jr+1);
                    }
                } else {
                    break;
                }
            }
            // even
            for (int jl = i-1, jr = i+1; jl >= 0 && jr < s.length(); jl--, jr++) {
                var r = s.charAt(jr);
                var l = s.charAt(jl);
                if (r == l) {
                    if (jr-jl+1 > result.length()) {
                        result = s.substring(jl, jr+1);
                    }
                } else {
                    break;
                }
            }

        }
        return result;
    }

}
