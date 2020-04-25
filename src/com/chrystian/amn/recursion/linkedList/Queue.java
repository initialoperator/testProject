package com.chrystian.amn.recursion.linkedList;

public class Queue {
    private Node head;
    public void addNewNode(Node newNode){
        if(this.head == null)
            this.head = newNode;
        else
            add(head, newNode);
    }
    private void add(Node head, Node newNode){
        if(head.next == null)
            head.next = newNode;
        else
            add(head.next, newNode);
    }

    public Node pop(){
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
