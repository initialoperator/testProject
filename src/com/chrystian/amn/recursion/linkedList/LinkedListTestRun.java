package com.chrystian.amn.recursion.linkedList;

import java.util.List;

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

    boolean isPalindrome(Node head)
    {
        Node reverse = reverse(head);
        while (head != null){
            if(head.data != reverse.data)
                return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
    Node reverse2(Node head){
        if(head == null)
            return null;
        Node reverse = new Node(head.data);
        Node pointer = head.next;
        while(pointer != null){
            Node newHead = new Node(pointer.data);
            newHead.next = reverse;
            reverse = newHead;
            pointer = pointer.next;
        }
        return reverse;
    }
    Node reverse(Node head)
    {
        int length = length(head);
        int[] array = new int[length];
        convertListToArray(head, array, 0);
        Node top = null;
        Node tail = null;
        for(int i = length -1; i >=0; i--){
            if(top == null){
                top = new Node(array[i]);
                tail = top;
            }else{
                tail.next = new Node(array[i]);
                tail = tail.next;
            }
        }
        return top;
    }

    private void convertListToArray(Node head, int[] array, int position){
        if(head == null)
            return;
        array[position] = head.data;
        convertListToArray(head.next, array, position+1);
    }

    int getMiddle(Node head)
    {
        if(head.next == null)
            return head.data;
        int length = length(head);
        int target = length/2;
        return getMiddle(head, 0, target);
    }
    private int getMiddle(Node head, int position, int target){
        if(head == null)//this case should not happend. maybe I can throw an exception
            return 0;
        if(position == target)
            return head.data;
        else
            return getMiddle(head.next, position+1, target);
    }

    private int length(Node head){
        if(head == null)
            return 0;
        else
            return 1 + length(head.next);
    }
}


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 */


