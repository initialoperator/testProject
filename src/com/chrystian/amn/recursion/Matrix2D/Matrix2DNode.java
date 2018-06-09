package com.chrystian.amn.recursion.Matrix2D;

public class Matrix2DNode {
    private Matrix2DNode leftNode;
    private Matrix2DNode rightNode;
    private Matrix2DNode upNode;
    private Matrix2DNode downNode;

    private Integer value;
    private Long groupHash;
    private String address;

    public Matrix2DNode createEmptyMatrix(int vLength, int hLength){
        this.address = this.toString();
        //detailed implementation goes here.
        if(vLength > 1){
            if(this.getDownNode() == null)
                this.setDownNode(new Matrix2DNode());
        }
        if(hLength > 1){
            if(this.getRightNode() == null)
                this.setRightNode(new Matrix2DNode());
        }
        createDiagonalNode(this.getDownNode(), this.getRightNode());
        if(this.downNode != null)
            this.getDownNode().createEmptyMatrix(vLength -1, hLength);
        if(this.rightNode != null)
            this.getRightNode().createEmptyMatrix(vLength, hLength - 1);

        return this;
    }

    private void createDiagonalNode(Matrix2DNode left, Matrix2DNode up){
        if(left == null || up == null)
            return;
        Matrix2DNode diagonal = new Matrix2DNode();
        left.setRightNode(diagonal);
        diagonal.setLeftNode(left);
        up.setDownNode(diagonal);
        diagonal.setUpNode(up);
    }

    public void print(){
        Matrix2DNode currRow = this;
        while(currRow != null){
            Matrix2DNode currCol = currRow;
            while (currCol != null){
                System.out.print(currCol.value + " ");
                currCol  = currCol.getRightNode();
            }
            currRow = currRow.getDownNode();
        }
    }
    //getters and settters
    public Matrix2DNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Matrix2DNode leftNode) {
        this.leftNode = leftNode;
    }

    public Matrix2DNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(Matrix2DNode rightNode) {
        this.rightNode = rightNode;
    }

    public Matrix2DNode getUpNode() {
        return upNode;
    }

    public void setUpNode(Matrix2DNode upNode) {
        this.upNode = upNode;
    }

    public Matrix2DNode getDownNode() {
        return downNode;
    }

    public void setDownNode(Matrix2DNode downNode) {
        this.downNode = downNode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getGroupHash() {
        return groupHash;
    }

    public void setGroupHash(Long groupHash) {
        this.groupHash = groupHash;
    }

    public String getAddress() {
        return address;
    }


}
