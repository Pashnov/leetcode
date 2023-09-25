package org.axp.start;

import java.util.Objects;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1)).val);
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, new ListNode(2))).val);
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, new ListNode(2, new ListNode(3)))).val);
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))).val);
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4 , new ListNode(5)))))).val);
    }

    private ListNode middleNode(ListNode head) {
        var result = head;
        int index = 1;
        do {
            head = head.next;
            if (index > 1){
                result = result.next;
                index = 0;
            }
            index++;
        } while (head != null);
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



