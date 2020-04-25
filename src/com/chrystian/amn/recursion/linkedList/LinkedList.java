package com.chrystian.amn.recursion.linkedList;

class LinkedList
{
    Node head;  // head of list

    public void addNewNode(Node node){
        appendNodeToNode(head, node);
    }

    private void appendNodeToNode(Node head, Node node){
        if(head == null){
            head = node;
        }else{
            Node child = head.next;
            appendNodeToNode(child, node);
        }
    }
}