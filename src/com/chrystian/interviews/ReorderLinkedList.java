package com.chrystian.interviews;


public class ReorderLinkedList{
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        // n5.next = n6;
        ListNode head = n1;
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        ReorderLinkedList sol = new ReorderLinkedList();
        sol.reorderList(n1);
        
        head = n1;
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
    public void reorderList(ListNode head) {
        /* Common mistakes
        1. For fast-slow pointers, first add a sentinel at the beginning, so it can make the count more natural. And then, always have the fast pointer to move 1 extra step first.
        2. alway cut the tail of both the first half and second reversed half linked list (set lastNode.next = null), so cyclic linked list can be avoided.
        3. when merging, check both the head != null && tail != null. And because of 2), no need to check head != tail
        3. linked list of length 1 is the edge case, see how to cover that (this part is unfinished)
        */
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        System.out.println("slow: "+ slow.val);

        ListNode prev = slow.next;
        ListNode curr = prev.next;
        slow.next = null;
        prev.next = null;//remember this!
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 
        ListNode tail = prev;
        
        ListNode headStart = head;
        ListNode headEnd = tail;
        while(headStart != null){
            System.out.print(headStart.val + "->");
            headStart = headStart.next;
        }
        System.out.println();
        while(headEnd != null){
            System.out.print(headEnd.val + "->");
            headEnd = headEnd.next;
        }

        while(head != null && tail != null){
           ListNode tempHead = head.next;
           ListNode tempTail = tail.next;
           head.next = tail;
           tail.next = tempHead;
            head = tempHead;
            tail = tempTail;

            if(head == null)
                System.out.println("head is null");
            if(tail == null)
                System.out.println("tail is null");
        }
    }

    
  
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}