package com.chrystian.amn.recursion.stack;

public class MyStack {
    private Node head;
    private Node minHead;

    public void push(int val){
        Node newly = new Node(val);
        if (head == null){
            head = newly;
        }else {

            newly.next = head;
            head = newly;
        }
        if (minHead == null){
            minHead = newly;
        }else {
            if(newly.val <= minHead.val){
                Node newMin = new Node(val);
                newMin.next = minHead;
                minHead = newMin;
            }

        }
    }

    public int pop(){
        if(head == null)
            return -9999;
        int headVal = head.val;
        head = head.next;

        if(headVal == minHead.val)
            minHead = minHead.next;
        return headVal;
    }

    public int min(){
        if(minHead == null)
            return -9999;
        return minHead.val;
    }
}
