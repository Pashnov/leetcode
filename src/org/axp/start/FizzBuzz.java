package org.axp.start;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/fizz-buzz/submissions/1055511677/
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> strs = new ArrayList<>(n);
        for (int i = 1; i <= n; i++ ) {
            if (i % 3 == 0 && i % 5 == 0) {
                strs.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strs.add("Fizz");
            } else if (i % 5 == 0) {
                strs.add("Buzz");
            } else {
                strs.add(String.valueOf(i));
            }
        }
        return strs;
    }

}
