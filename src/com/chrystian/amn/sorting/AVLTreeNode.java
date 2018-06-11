package com.chrystian.amn.sorting;

public class AVLTreeNode extends BinaryNode {

    public  AVLTreeNode(int val){
        super(val);
    }


    public void addChild(AVLTreeNode child){
        super.addChild(child);
        adjust();
    }

    private AVLTreeNode getBottomImbalancedRoot(){
        if(this.leftChild == null || this.rightChild == null)
            return null;
        else{
            AVLTreeNode leftChild = (AVLTreeNode)this.leftChild;
            AVLTreeNode rightChild = (AVLTreeNode)this.rightChild;
            AVLTreeNode leftImbanlancedRoot = leftChild.getBottomImbalancedRoot();
            AVLTreeNode rightImbalancedRoot = rightChild.getBottomImbalancedRoot();
            if(leftImbanlancedRoot == null && rightImbalancedRoot == null){
                if(Math.abs(this.leftChild.depth() - this.rightChild.depth()) > 1)
                    return this;
            }else{
                return leftImbanlancedRoot == null ? rightImbalancedRoot:leftImbanlancedRoot; //possible error: assuming only one side is imbalanced
            }

        }

        return null;
    }

    private void adjust(){
        AVLTreeNode root = this.getBottomImbalancedRoot();
        if(root == null)
            return;
        AVLTreeNode parent = (AVLTreeNode)this.findParentOf(root);
        int leftDepth = root.leftChild == null ? 0: root.leftChild.depth();
        int rightDepth = root.rightChild == null ? 0: root.rightChild.depth();
        AVLTreeNode pivot = leftDepth > rightDepth? (AVLTreeNode)root.leftChild:(AVLTreeNode)root.rightChild;

        //start to rotate and replace
        if(parent == null){
            if(root.value > pivot.value){
                root.addChild(pivot.rightChild);
                pivot.rightChild = root;
            }else {
                root.addChild(pivot.leftChild);
                pivot.leftChild = root;
            }
            return;
        }
        if(parent.leftChild == root){
            parent.leftChild = pivot;
            if(root.value > pivot.value){
                root.addChild(pivot.rightChild);
                pivot.rightChild = root;
            }else {
                root.addChild(pivot.leftChild);
                pivot.leftChild = root;
            }
        }else{
            if(root.value > pivot.value){
                root.addChild(pivot.rightChild);
                pivot.rightChild = root;
            }else {
                root.addChild(pivot.leftChild);
                pivot.leftChild = root;
            }
        }
        //so far the rotation should have made root become balanced
        adjust();//after rotation, check the root again to see if there is any imbalance
    }


}
