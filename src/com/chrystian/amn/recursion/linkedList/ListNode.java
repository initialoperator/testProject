package com.chrystian.amn.recursion.linkedList;

public class ListNode {//this class is define by the problem, note that the integer stored in list node is in a reverse order
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //assuming val is no greater than 9 and no smaller than 0 because it's a digit
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else {
            int sum = l1.val + l2.val;
            int extra = 0;
//            ListNode node = new ListNode(sum);
            if (sum > 9) {
                ListNode node = new ListNode(sum - 10);
                if (l1.next == null) {
                    ListNode nextNode = new ListNode(1);
                    node.next = addTwoNumbers(nextNode, l2.next);
                } else if (l2.next == null) {
                    ListNode nextNode = new ListNode(1);
                    node.next = addTwoNumbers(l1.next, nextNode);
                } else {
                    ListNode nextNode = new ListNode(1 + l1.next.val);
                    nextNode.next = l1.next.next;
                    node.next = addTwoNumbers(nextNode, l2.next);
                }
                return node;
            } else {
                ListNode node = new ListNode(sum);
                node.next = addTwoNumbers(l1.next, l2.next);
                return node;
            }
        }
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
