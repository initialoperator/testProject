package com.chrystian.amn.recursion.linkedList;

public class Stack {
    Node head;
    public Node addNewNode(Node newNode){
        if(this.head == null){
            this.head = newNode;
            return head;
        }
        newNode.next = head;
        this.head = newNode;
        return head;
    }

    public Node popup(){
        Node pop = this.head;
        this.head = this.head.next;
        return pop;
    }

    public void print(){
        print(this.head);
    }
    private void print(Node node){
        if(node != null){
            System.out.println(node.data);
            print(node.next);
        }
    }
}
