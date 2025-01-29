package org.axp.medium;

// copilot: disable
// https://leetcode.com/problems/rotate-list/description/
public class _61_Rotate_List {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(head);
        
        ListNode rotated = new _61_Rotate_List().rotateRight(head, 1);
        System.out.println(rotated);

        head = head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotated = new _61_Rotate_List().rotateRight(head, 2);
        System.out.println(rotated);

        head = head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotated = new _61_Rotate_List().rotateRight(head, 3);
        System.out.println(rotated);

        head = head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotated = new _61_Rotate_List().rotateRight(head, 4);
        System.out.println(rotated);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotated = new _61_Rotate_List().rotateRight(head, 5);
        System.out.println(rotated);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotated = new _61_Rotate_List().rotateRight(head, 6);
        System.out.println(rotated);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null || k == 0) {
            return head;
        }
        int size = 2;
        // 1st init iteration/rotation
        var precursor = head;
        var cursor = head.next;
        while (cursor.next != null) {
            precursor = cursor;
            cursor = cursor.next;
            size++;
        }
        precursor.next = null;
        cursor.next = head;
        head = cursor;
        // recalculate k, -1, as cycle was above and 'mod' not to rotate over size
        k = (k-1) % size;
        if (k == 0) {
            return head;
        }

        precursor = head;
        cursor = head.next;

        for (int i = 1; i < (size - k); i++) {
            precursor = cursor;
            cursor = cursor.next;
        }

        var newHead = cursor;
        precursor.next = null;


        while (cursor.next != null) {
            cursor = cursor.next;
        }

        cursor.next = head;

        return newHead;
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    @Override
    public String toString() {
        if (next != null) {
            return val + "," + next.toString();
        } else {
            return val + "";
        }
    }
}
