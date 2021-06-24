package com.chrystian.amazon;

import java.util.*;

public class TreeMaxSumPath {
//https://leetcode.com/problems/binary-tree-maximum-path-sum/

    /*
    personal thought: not much trick, just
    1. hard recursions
    2. besides recursion, there is a side effect for sum as left - root - right: use a hashmap to record the value and the path

    * */
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.left = root2;
        root.right = root3;

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> sumMap = new HashMap<>();
        int max = findMaxNum(root, sb, sumMap);
        int max2 = sumMap.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().get();
        return Math.max(max, max2);
    }

    public static int findMaxNum(TreeNode root, StringBuilder sb, Map<Integer, String> sumMap){
        if (root == null)
            return 0;

        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();

        int sumLeft = findMaxNum(root.left, sbLeft, sumMap);
        int sumRight = findMaxNum(root.right, sbRight, sumMap);

        if(root.val + sumLeft + sumRight >= Math.max(sumLeft, sumRight)){
            String path = sbLeft.toString() + root.val + "-" + sumRight;
            sumMap.put(root.val + sumLeft + sumRight, path);
        }

        if (sumLeft > sumRight){
            sbLeft.append("-").append(root.val);
            sb.append(sbLeft);
            return root.val + sumLeft;
        }else {
            sb.append(root.val).append("-").append(sbRight);
            return root.val + sumRight;
        }
    }

}
