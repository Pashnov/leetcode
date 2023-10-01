package org.axp.medium;

public class _2_AddTwoNumbers {
    public static void main(String[] args) {
//        System.out.println(new _2_AddTwoNumbers().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
//                new ListNode(5, new ListNode(6, new ListNode(4)))) + "7,0,8");
//        System.out.println(new _2_AddTwoNumbers().addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9 ))))))),
//                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))) + " - [8,9,9,9,0,0,0,1]");
        System.out.println(new _2_AddTwoNumbers().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(9))),
                new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))))) + "  [7,0,4,0,1]");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (innerAdd(l1, l2, (byte)0)) {
            return l1;
        } else  {
            return l2;
        }
    }

    private boolean innerAdd(ListNode l1, ListNode l2, byte leadingInt) {
        if (l1 != null && l2 != null) {
            l1.val = l1.val + l2.val + leadingInt;
            if (l1.val > 9) {
                leadingInt = 1;
                l1.val %= 10;
            } else {
                leadingInt = 0;
            }
            l2.val = l1.val;
            if (l1.next==null && l2.next==null) {
                if (leadingInt > 0 ) {
                    l1.next = new ListNode(leadingInt);
                    return true;
                }
            }
            return innerAdd(l1.next,l2.next, leadingInt);
        } else if (l1 != null) {
            innerAddSingle(l1, leadingInt);
            return true;
        } else if (l2 != null) {
            innerAddSingle(l2, leadingInt);
            return false;
        }

        return true;

    }

    private void innerAddSingle(ListNode l2, byte leadingInt) {
        l2.val = l2.val + leadingInt;
        if (l2.val > 9) {
            leadingInt = 1;
            l2.val %= 10;
        } else {
            leadingInt = 0;
        }
        if (l2.next != null) {
            innerAddSingle(l2.next, leadingInt);
        } else {
            if (leadingInt > 0 ) {
                l2.next = new ListNode(leadingInt);
            }
        }
    }




    // winner
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        byte leadingInt = 0;
        int newVal;
        newVal = l1.val + l2.val + leadingInt;
        if (newVal > 9) {
            leadingInt = 1;
            newVal %= 10;
        }
        l1 = l1.next; l2 = l2.next;

        ListNode start = new ListNode(newVal);
        ListNode root = start;

        while (l1 != null || l2 != null) {
            newVal = getIntNull(l1) + getIntNull(l2) + leadingInt;
            if (newVal > 9) {
                leadingInt = 1;
                newVal %= 10;
            } else {
                leadingInt = 0;
            }
            start.next = new ListNode(newVal);
            start = start.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (leadingInt > 0) {
            start.next = new ListNode(leadingInt);
        }
        return root;
    }

    public int getIntNull(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }




    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        byte leadingInt = 0;
        int newVal;
        newVal = l1.val + l2.val + leadingInt;
        if (newVal > 9) {
            leadingInt = 1;
            newVal %= 10;
        }
        l1 = l1.next; l2 = l2.next;

        ListNode start = new ListNode(newVal);
        ListNode root = start;


        while (l1 != null && l2 != null) {
            newVal = l1.val + l2.val + leadingInt;
            if (newVal > 9) {
                leadingInt = 1;
                newVal %= 10;
            } else {
                leadingInt = 0;
            }
            start.next = new ListNode(newVal);
            start = start.next;
            l1 = l1.next; l2 = l2.next;
        }
        while (l1 != null) {
            newVal = l1.val + leadingInt;
            if (newVal > 9) {
                leadingInt = 1;
                newVal %= 10;
            } else {
                leadingInt = 0;
            }
            start.next = new ListNode(newVal);
            start = start.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            newVal = l2.val + leadingInt;
            if (newVal > 9) {
                leadingInt = 1;
                newVal %= 10;
            } else {
                leadingInt = 0;
            }
            start.next = new ListNode(newVal);
            start = start.next;
            l2 = l2.next;
        }
        if (leadingInt > 0) {
            start.next = new ListNode(leadingInt);
        }
        return root;
    }

    static class ListNode {
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

