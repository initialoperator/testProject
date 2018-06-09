package com.chrystian.amn.recursion;

public class TestRun {

    public static void main(String[] args) {
        Integer[][] array = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4},};
        Matrix2D m = new Matrix2D();
        m.convertArrayToLinkedMatrix(array);
        m.printAddress();
    }
}
