package org.axp.medium;

// https://leetcode.com/problems/reverse-integer/
public class _7_Reverse_Integer {
    public static void main(String[] args) {
        System.out.println(new _7_Reverse_Integer().reverse(-1234) + " -4321" );
        System.out.println(new _7_Reverse_Integer().reverse(2147483647) + " 7463847412");

    }

    // way 2
    public int reverse(int x) {
        int signum = Integer.signum(x);
        x = Math.abs(x);

        byte lastDigit;
        long reversed = 0;
        while (x != 0) {
            lastDigit = (byte) (x % 10);
            reversed = (reversed * 10) + lastDigit;
            x /= 10;
        }
        long preResult = reversed * signum;
        if (preResult > Integer.MAX_VALUE || preResult < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) preResult;
    }

    // way 1
//    public int reverse(int x) {
//        int signum = Integer.signum(x);
//        String reversed = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
//        try {
//            return Integer.parseInt(reversed) * signum;
//        } catch (RuntimeException e) {
//            return 0;
//        }
//    }

}
