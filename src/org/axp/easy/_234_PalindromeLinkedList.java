package org.axp.easy;

public class _234_PalindromeLinkedList {

    public static void main(String[] args) {
        System.out.println("expected true == " + isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.println("expected false == " + isPalindrome(new ListNode(1, new ListNode(2))));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // count size
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        // reverse 1st half
        ListNode temp, newHead = null;
        cur = head;
        int index = 0;
        while (index < size/2) {
            index++;
            if (newHead == null) {
                newHead = cur;
                cur = cur.next;
                newHead.next = null;
            } else {
                temp = cur;
                cur = cur.next;
                temp.next = newHead;
                newHead = temp;
            }
        }
        // to handle odd size
        if ((size & 1) == 1) {
            cur = cur.next;
        }
        // to compare 1st reversed part and 2nd of list
        while (cur != null) {
            if (cur.val != newHead.val) {
                return false;
            } else {
                cur = cur.next;
                newHead = newHead.next;
            }
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
