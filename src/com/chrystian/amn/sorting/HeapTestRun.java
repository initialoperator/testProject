package com.chrystian.amn.sorting;

import java.util.Random;

public class HeapTestRun {
    public static void main(String[] args) {
//        HeapNode tree = new HeapNode(50);
//        Random r = new Random();
//        for(int i = 0; i < 100; i++){
//            int val = r.nextInt(200);
//            System.out.println("unordered value: "+ val);
//            tree.addChild(new HeapNode(val));
//        }
//        System.out.println("after adding complete, the tree size is: " + tree.size());
//        System.out.println("now printing out the tree");
//        int[] array = tree.toArray();
//        for(int i : array){
//            System.out.println("array: "+i);
//        }
        testCase1();
    }

    private static void testCase1(){
        HeapTree tree = new HeapTree();
        int[] array = {50, 115, 83, 159, 184, 143, 110};
        for(int i : array)
            tree.addNode(new HeapNode(i));

        System.out.println(tree.stringify());
    }
}
