package com.chrystian.amn.sorting;

import java.util.Random;

public class BinaryTreeTestRun {
    public static void main(String[] args) {
        BinaryNode tree = new BinaryNode(50);
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            int val = r.nextInt(200);
            System.out.println("unordered value: "+ val);
            tree.addChild(new BinaryNode(val));
        }
        System.out.println("after adding complete, the tree size is: " + tree.size());
//        System.out.println("now printing out the tree in order");
        int[] array = tree.toArray();
        AVLTreeNode head = null;
        for(int i : array){
//            System.out.println("array: "+i);
            if(head == null)
                head = new AVLTreeNode(i);
            else
                head.addChild(new AVLTreeNode(i));
        }
        System.out.println("Normal binary tree done, AVL tree is going to start.....");
        System.out.println("after AVL adding complete, the head size is: " + head.size());
        int[] avlArray = head.toArray();
        for(int i : avlArray){
            System.out.println("AVL array: " + i);
        }
    }
}
