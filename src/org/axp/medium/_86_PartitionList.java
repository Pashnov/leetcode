package org.axp.medium;

// https://leetcode.com/problems/partition-list/description/
public class _86_PartitionList {

    public static void main(String[] args) {
        System.out.println(new _86_PartitionList().partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
//        ListNode result = head.val < x ? head: null;
        ListNode result =  null;
        ListNode middle = head;
        ListNode end = head;
        while (head.next != null) {
            if (head.next.val < x) {
                if (result == null) {
                    result = head.next;

                    continue;
                }
                result.next = head.next;
            } else {

            }
        }
        return null; // todo
    }

    public ListNode partition0(ListNode head, int x) {
        ListNode firstHead = null;
        ListNode firstTail = null;
        ListNode secondHead = null;
        ListNode secondTail = null;
        while (head != null) {
            if (head.val < x) {
                if (firstHead == null) {
                    firstHead = new ListNode(head.val);
                    firstTail = firstHead;
                } else {
                    firstTail.next = new ListNode(head.val);
                    firstTail = firstTail.next;
                }
            } else {
                if (secondHead == null) {
                    secondHead = new ListNode(head.val);
                    secondTail = secondHead;
                } else {
                    secondTail.next = new ListNode(head.val);
                    secondTail = secondTail.next;
                }
            }
            head = head.next;
        }
        if (firstHead != null) {
            firstTail.next = secondHead;
        } else {
            firstHead = secondHead;
        }
        return firstHead;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            if (next != null) {
                return val + "," + next.toString();
            } else {
                return val + "";
            }
        }
    }
}


