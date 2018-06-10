package com.chrystian.amn.sorting;

public class BinaryNode {
    int value;
    BinaryNode leftChild;
    BinaryNode rightChild;

    public BinaryNode(int val){
        this.value = val;
    }
    public int getValue() {
        return value;
    }

    public void addChild(BinaryNode child){
        if(child == null)
            return;
        if(child.value > this.value){
            if(this.rightChild == null)
                this.rightChild = child;
            else
                this.rightChild.addChild(child);
        }else{
            if(this.leftChild == null)
                this.leftChild = child;
            else
                this.leftChild.addChild(child);
        }
    }

    public int[] toArray(){
        int[] leftArray = new int[0];
        if(this.leftChild != null){
            leftArray = this.leftChild.toArray();
        }
        int[] rightArray = new int[0];
        if(this.rightChild != null){
            rightArray = this.rightChild.toArray();
        }
        int totalLength = leftArray.length + 1 + rightArray.length;
        int[] array = new int[totalLength];
        int pos = 0;
        while(pos < leftArray.length){
            array[pos] = leftArray[pos];
            pos++;
        }
        array[pos] = this.value;
        pos++;
        while(pos < totalLength){
            array[pos] = rightArray[pos-leftArray.length-1];
            pos++;
        }
        return array;
    }

    public int size(){
        int sizeLeft = 0;
        if(this.leftChild != null)
            sizeLeft = leftChild.size();
        int sizeRight = 0;
        if(this.rightChild != null)
            sizeRight = rightChild.size();
        return sizeLeft + 1 + sizeRight;
    }

    public int depth(){
        int leftDepth = 0;
        int rightDepth = 0;
        if(this.leftChild != null)
            leftDepth = leftChild.depth();
        if(this.rightChild != null)
            rightDepth = rightChild.depth();
        return 1+ Math.max(leftDepth, rightDepth);
    }

    protected BinaryNode getLeftMostChild(){
        if(this.leftChild == null)
            return this;
        else return this.leftChild.getLeftMostChild();
    }
    protected BinaryNode getRightMostChild(){
        if(this.rightChild == null)
            return this;
        else return this.leftChild.getRightMostChild();
    }

    protected BinaryNode findParentOf(BinaryNode node){
        if(this.leftChild == node || this.rightChild == node)
            return this;
        else if(leftChild != null || node.value <= this.value)
            return leftChild.findParentOf(node);
        else if(rightChild != null || node.value > this.value)
            return rightChild.findParentOf(node);
        return null;
    }
}
