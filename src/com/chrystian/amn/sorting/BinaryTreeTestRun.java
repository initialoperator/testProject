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
        System.out.println("now printing out the tree in order");
        int[] array = tree.toArray();
        for(int i : array){
            System.out.println("array: "+i);
        }
    }
}
