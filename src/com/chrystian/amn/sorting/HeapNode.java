package com.chrystian.amn.sorting;

public class HeapNode extends BinaryNode{//smallest elemnent on top
    private int height;
    public HeapNode(int i){
        super(i);
    }

    public static void addChildToLastParent(HeapNode child, HeapNode parent){
        if(parent == null)
            parent = child;
        else{
            if(parent.leftChild == null)
                parent.leftChild = child;
            else
                parent.rightChild = child;
        }
    }

    public HeapNode findLastNodeParent(){
        if(this.leftChild == null || this.rightChild == null)
            return this;
        HeapNode left = (HeapNode)this.leftChild;
        HeapNode right = (HeapNode)this.rightChild;
        int leftDepth = left.depth();
        int rightDepth = right.depth();
        return leftDepth <= rightDepth ? left.findLastNodeParent() : right.findLastNodeParent();
    }

//    public String stringify(int height){
//        String thisVal = this.value + "_"+height;
//        String leftVal = "";
//        String rightVal = "";
//        if(this.leftChild != null)
//            leftVal = ((HeapNode)this.leftChild).stringify(height+1);
//        if(this.rightChild != null)
//            rightVal = ((HeapNode)this.rightChild).stringify(height+1);
//
//
//    }

    public void addChild(HeapNode node){
        HeapNode parent = this.findEmptySlotParent();
        if(parent.leftChild == null)
            parent.leftChild = node;
        else
            parent.rightChild = node;
        adjust(parent, node);
    }

    public void adjust(HeapNode parent, HeapNode node){
        if (parent==null)
            return;
        else if(parent.value > node.value){
            int temp = parent.value;
            parent.value = node.value;
            node.value = temp;
            HeapNode grandParent = this.findParentOf(parent);
            adjust(grandParent, parent);
        }
    }


    public HeapNode findParentOf(HeapNode node){
        if(this == node)
            return null;
        else{
            if(this.leftChild == node)
                return (HeapNode)this.leftChild;
            else if(this.rightChild == node)
                return (HeapNode)this.rightChild;
            else{
                HeapNode parent = ((HeapNode)this.leftChild).findParentOf(node);
                if (parent != null)
                    return parent;
                parent = ((HeapNode)this.rightChild).findParentOf(node);
                if (parent != null)
                    return parent;
                return null;
            }
        }
    }

    public HeapNode findEmptySlotParent(){
        if(this.leftChild == null || this.rightChild == null)
            return this;
        else{
//            boolean leftBalanced =((HeapNode)this.leftChild).isCompletBalanced();
            boolean rightBalanced = ((HeapNode)this.rightChild).isCompletBalanced();
            if(rightBalanced){
                HeapNode subLeft = (HeapNode)this.leftChild;
                return subLeft.findEmptySlotParent();
            }else {
                HeapNode subRight = (HeapNode)this.rightChild;
                return subRight.findEmptySlotParent();
            }

        }
    }

    public boolean isCompletBalanced(){
        if(this.leftChild == null && this.rightChild != null)
            return false;
        if(this.leftChild != null && this.rightChild == null)
            return false;
        if(this.leftChild == null && this.rightChild == null)
            return true;
        if(this.leftChild.depth() != this.rightChild.depth())
            return false;
        return ((HeapNode)this.leftChild).isCompletBalanced() && ((HeapNode)this.rightChild).isCompletBalanced();
    }

//    public void adjust_delete(HeapNode parent, HeapNode node){
//        if(parent == null)
//            return;
//        if(parent.value > node.value){
//            HeapNode grandParent = this.findParentOf(parent);
//            if(grandParent != null){
//                if(grandParent.leftChild == parent){
//                    grandParent.leftChild = node;
//                }else {
//                    grandParent.rightChild = node;
//                }
//            }
//            if(parent.leftChild == node){
//                node.rightChild = parent.rightChild;
//                HeapNode temp = (HeapNode)node.leftChild;
//                node.leftChild = parent;
//                parent.leftChild = temp;
//            }else {
//                node.leftChild = parent.leftChild;
//                HeapNode temp = (HeapNode)node.rightChild;
//                node.rightChild = parent;
//                parent.rightChild = temp;
//            }
//            this.adjust(grandParent, node);
//        }
//    }
}
