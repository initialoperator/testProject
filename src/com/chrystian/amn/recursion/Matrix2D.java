package com.chrystian.amn.recursion;

public class Matrix2D {

    private Matrix2DNode headUpLeft;

    public Matrix2DNode convertArrayToLinkedMatrix(Integer[][] arrayMatrix){
        //precondition: array matrix is already fulfilled
        int vLength = arrayMatrix.length;
        int hLength = arrayMatrix[0].length; //assuming the array is rectangly fulfilled
        this.headUpLeft = new Matrix2DNode();
        this.headUpLeft.createEmptyMatrix(vLength, hLength);
        Matrix2DNode currRow = this.headUpLeft;
        for(int i = 0; i <vLength; i++){
            Matrix2DNode currCol = currRow;
            for(int k = 0; k < hLength; k++){
                currCol.setValue(arrayMatrix[i][k]);
                currCol = currCol.getRightNode();
            }
            currRow = currRow.getDownNode();
        }
        return this.headUpLeft;
    }

    public void print(){
        Matrix2DNode currRow = this.headUpLeft;
        while(currRow != null){
            Matrix2DNode currCol = currRow;
            while (currCol != null){
                System.out.print(currCol.getValue() + " ");
                currCol  = currCol.getRightNode();
            }
            System.out.println();
            currRow = currRow.getDownNode();
        }
    }

    public void printAddress(){
        Matrix2DNode currRow = this.headUpLeft;
        while(currRow != null){
            Matrix2DNode currCol = currRow;
            while (currCol != null){
                System.out.print(Matrix2D.getNodeAddress(currCol) + "-"+Matrix2D.getNodeAddress(currCol.getRightNode())+"-"+ Matrix2D.getNodeAddress(currCol.getDownNode())+"   ");
                currCol  = currCol.getRightNode();
            }
            System.out.println();
            currRow = currRow.getDownNode();
        }
    }

    public static String getNodeAddress(Matrix2DNode node){
        if(node == null)
            return "";
        else{
            return node.getAddress().split("@")[1];
        }
    }

    public Matrix2DNode getHeadUpLeft() {
        return headUpLeft;
    }

    public void setHeadUpLeft(Matrix2DNode headUpLeft) {
        this.headUpLeft = headUpLeft;
    }
}
