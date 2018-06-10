package com.chrystian.amn.recursion.linkedList;

public class LinkedListTestRun {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[2];
        lists[1] = new ListNode(1);
        ListNode merged = ListNode.mergeKLists(lists);
        ListNode iterate = merged;
        while(iterate != null){
            System.out.println(iterate.val);
            iterate = iterate.next;
        }
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 */


