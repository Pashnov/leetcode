package org.axp.medium;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class _92_ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        toString(head);
        ListNode x = new _92_ReverseLinkedListII().reverseBetween(head, 2, 4);
        toString(x);
        head = new ListNode(5);
        toString(head);
        x = new _92_ReverseLinkedListII().reverseBetween(head, 1, 1);
        toString(x);
        head = new ListNode(3, new ListNode(5));
        toString(head);
        x = new _92_ReverseLinkedListII().reverseBetween(head, 1, 2);
        toString(x);
        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        toString(head);
        x = new _92_ReverseLinkedListII().reverseBetween(head, 1, 2);
        toString(x);
    }

    private static void toString(ListNode x) {
        System.out.print(x.val);
        for (int i = 0; i < 10 && x.next != null; i++) {
            x = x.next;
            System.out.print(","+x.val);
        }
        System.out.println("   ");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode cursor = head;
        for (int i = 0; i < left-2; i++) {
            cursor = cursor.next;
        }
        var firstCut = left == 1 ? null : cursor;
        if (left > 1) {
            cursor = cursor.next;
        }
        ListNode newLastElem = null;
        ListNode new2ndElem = null;
        ListNode new1stElem = null;
        for (int i = 0; i < (right - left+1) && cursor != null; i++) {
            if (newLastElem == null) {
                newLastElem = cursor;
                new2ndElem = cursor;
                cursor = cursor.next;
                newLastElem.next = null;
            } else {
                new1stElem = cursor;
                cursor = cursor.next;
                new1stElem.next = new2ndElem;
                new2ndElem = new1stElem;
            }
        }

        if (firstCut == null) {
            head = new2ndElem;
            if (cursor != null) {
                newLastElem.next = cursor;
            }
        } else {
            firstCut.next = new2ndElem;
            newLastElem.next = cursor;
        }

        return head;
    }


    static  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
