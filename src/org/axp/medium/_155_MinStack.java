package org.axp.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/problems/min-stack/
public class _155_MinStack {

    public static void main(String[] args) {
        _155_MinStack obj = new _155_MinStack();
//        obj.push(-2);
//        obj.push(0);
//        obj.push(-3);
//        System.out.println("param_4 = " + obj.getMin()  + ", expected '-3' ");
//        obj.pop();
//        System.out.println("param_3 = " + obj.top() + ", expected '0' ");
//        System.out.println("param_5 = " + obj.getMin() + ", expected '-2' ");

//        obj = new _155_MinStack();
//        obj.push(-1);
//        System.out.println("param_3 = " + obj.top() + ", expected '-1' ");
//        System.out.println("param_4 = " + obj.getMin() + ", expected '-1' ");

//        obj = new _155_MinStack();
//        obj.push(0);
//        obj.push(1);
//        obj.push(0);
//        System.out.println("param_5 = " + obj.getMin() + ", expected '0' ");
//        obj.pop();
//        System.out.println("param_7 = " + obj.getMin() + ", expected '0' ");

//        obj = new _155_MinStack();
//        obj.push(-2);
//        obj.push(0);
//        obj.push(-1);
//        System.out.println("param_4 = " + obj.getMin() + ", expected '-2' ");
//        System.out.println("param_5 = " + obj.top() + ", expected '-1' ");
//        obj.pop();
//        System.out.println("param_7 = " + obj.getMin() + ", expected '-2' ");

        obj = new _155_MinStack();
        obj.push(-10);
        obj.push(14);
        System.out.println("param_3 = " + obj.getMin() + ", expected '-10' ");
        System.out.println("param_4 = " + obj.getMin() + ", expected '-10' ");
        obj.push(-20);
        System.out.println("param_6 = " + obj.getMin() + ", expected '-20' ");
        System.out.println("param_7 = " + obj.getMin() + ", expected '-20' ");
        System.out.println("param_8 = " + obj.top() + ", expected '-20' ");
        System.out.println("param_9 = " + obj.getMin() + ", expected '-20' ");
        obj.pop();
        obj.push(10);
        obj.push(-7);
        System.out.println("param_13 = " + obj.getMin() + ", expected '-10' ");
        obj.push(-7);
        obj.pop();
        System.out.println("param_16 = " + obj.top() + ", expected '-7' ");
        System.out.println("param_17 = " + obj.getMin() + ", expected '-10' ");
        obj.pop();
    }

    LinkedList<int[]> stack = new LinkedList<>();
    int currentMinValue;

    public _155_MinStack() {}

    public void push(int val) {
        if (stack.isEmpty()) {
            currentMinValue = val;
            stack.push(new int[]{val, val});
            return;
        }
        currentMinValue = Math.min(val, currentMinValue);
        stack.push(new int[]{val, currentMinValue});
    }

    public void pop() {
        stack.poll(); // 2
        if (!stack.isEmpty()) {
            var nextElem = stack.peek();
            currentMinValue = nextElem[1];
        }
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

}
