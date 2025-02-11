package org.axp.easy;

// https://leetcode.com/problems/climbing-stairs/description/
public class _70_ClimbingStairs {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(n + "-" + climbStairs2(n)+ "-" + climbStairs(n));
        n = 2;
        System.out.println(n + "-" + climbStairs2(n)+ "-" + climbStairs(n));
        n = 3;
        System.out.println(n + "-" + climbStairs2(n)+ "-" + climbStairs(n));
        n = 4;
        System.out.println(n + "-" + climbStairs2(n)+ "-" + climbStairs(n));
        n = 5;
        System.out.println(n + "-" + climbStairs2(n)+ "-" + climbStairs(n));
        n = 6;
        System.out.println(n + "-" + climbStairs2(n)+ "-" + climbStairs(n));
    }

    // 0 -> {} (0)
    // 1 -> 1 (1)
    // 2 -> 1,1 + 2 (2) -> 1,f(1) +2,f(0)
    // 3 -> 1,1,1 + 1,2 + 2,1 (3) -> 1,f(2) + 2,f(1)
    // 4 -> 1,1,1,1 + 1,1,2 + 1,2,1 + 2,1,1 + 2,2 (5) -> 1,f(3) + 2,f(2) = 3+2 = 5
    // 4 -> f(4) = 1,f(3) + 2,f(2) (5)
    // 5 -> 1,1,1,1,1 -> 1,f(4)+2,f(3)
    // n -> f(n) = 1,f(n-1) + 2,f(n-1)
    public static int climbStairs1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ways = 0;
        int act1 = 1, act2 = 2;
        for (int i = 2; i < n; i++) {  // 1 2
            int current = act1 + act2; // 1 2
            act1 = act2;               // 1 1
            act2 = current;            // 1 2
            ways = current;           // 1 3
        }
        return ways;
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pref = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int newCurr = pref + curr;
            pref = curr;
            curr = newCurr;
        }
        return curr;
    }

    public static int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
