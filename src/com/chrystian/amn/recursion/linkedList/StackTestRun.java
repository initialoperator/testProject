package com.chrystian.amn.recursion.linkedList;

public class StackTestRun {
    public static void main(String[] args){
        Stack s = new Stack();
        Node n1 = new Node(1);
        Node n2 = new Node(7);
        Node n3 = new Node(12);
        Node n4 = new Node(4);
        Node n5 = new Node(9);
        Node n6 = new Node(2);
//        s.addNewNode(n1);
//        s.addNewNode(n2);
//        s.addNewNode(n3);
//        s.addNewNode(n4);
//        s.addNewNode(n5);
//        s.addNewNode(n6);

        Queue q = new Queue();
        q.addNewNode(n1);
        q.addNewNode(n2);
        q.addNewNode(n3);
        q.addNewNode(n4);
        q.addNewNode(n5);
        q.addNewNode(n6);
        q.print();
    }
}
