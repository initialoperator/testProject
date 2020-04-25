package com.chrystian.amn.recursion.stack;

public class BigO1StackTest {
    public static void main(String[] args) {
//        testBigO1MyStack();
        testQueuedStack();
    }


    private static void testBigO1MyStack(){
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);
        stack.push(7);

        System.out.println("min: " + stack.min());
        System.out.println("popped " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("popped " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("popped " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("popped " + stack.pop());
        System.out.println("min: " + stack.min());
    }

    private static void testQueuedStack(){
        QueuedStack stack = new QueuedStack();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);
        stack.push(7);

        System.out.println("popped " + stack.pop());
        System.out.println("popped " + stack.pop());
        System.out.println("popped " + stack.pop());
        System.out.println("popped " + stack.pop());
        System.out.println("popped " + stack.pop());
    }
}
