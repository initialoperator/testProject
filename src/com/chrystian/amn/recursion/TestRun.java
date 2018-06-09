package com.chrystian.amn.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRun {

    public static void main(String[] args) {
        Integer[][] array = {{0, 0, 1, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0, 1}, {1, 1, 0, 0, 1, 1, 0}, {0, 0, 1, 1, 0, 0, 1}};
        Matrix2D m = new Matrix2D();
        m.convertArrayToLinkedMatrix(array);
//        m.printAddress();
        m.print();
        int sectionCount = countSection(m);
        System.out.println("total number of sections: " + sectionCount);
    }

    private static int countSection(Matrix2D matrix){
        //precondition：matrix only contains 1's and 0's

        List<Long> hashList = new ArrayList<>();
        Random random = new Random();
        Matrix2DNode currRow = matrix.getHeadUpLeft();
        while(currRow != null){
            Matrix2DNode currCol = currRow;
            while(currCol != null){
                Long hash = random.nextLong();
                boolean result = findNextNode(currCol, hash);
                if(result)
                    hashList.add(hash);
                currCol = currCol.getRightNode();
            }
            currRow = currRow.getDownNode();
        }
        return hashList.size();
    }

    private static boolean findNextNode(Matrix2DNode node, Long hash){//direction goes from left to right, from top to bottom
        if(node == null)
            return false;
        if (node.getValue().equals(1) && node.getGroupHash() == null){
            node.setGroupHash(hash);
            findNextNode(node.getRightNode(), hash);
            findNextNode(node.getDownNode(), hash);
            return true;
        }
        return false;
    }
}
