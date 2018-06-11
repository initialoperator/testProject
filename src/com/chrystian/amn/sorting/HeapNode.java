package com.chrystian.amn.sorting;

public class HeapNode extends BinaryNode{//smallest elemnent on top

    public HeapNode(int i){
        super(i);
    }

    public void add(HeapNode node){
        HeapNode parent = this.findEmptySlotParent();
        if(parent.leftChild == null)
            parent.leftChild = node;
        else
            parent.rightChild = node;
        adjust(parent, node);
    }
    public void adjust(HeapNode parent, HeapNode node){
        if(parent == null)
            return;
        if(parent.value > node.value){
            HeapNode grandParent = this.findParentOf(parent);
            if(grandParent != null){
                if(grandParent.leftChild == parent){
                    grandParent.leftChild = node;
                }else {
                    grandParent.rightChild = node;
                }
            }
            if(parent.leftChild == node){
                node.rightChild = parent.rightChild;
                node.leftChild = parent;
            }else {
                node.leftChild = parent.leftChild;
                node.rightChild = parent;
            }
            this.adjust(grandParent, parent);
        }
    }

    public HeapNode findParentOf(HeapNode node){
        if(this == node)
            return this;
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
            int depthLeft = this.leftChild.depth();
            int depthRight = this.rightChild.depth();
            if(depthLeft < depthRight){
                HeapNode subLeft = (HeapNode)this.leftChild;
                return subLeft.findEmptySlotParent();
            }else{
                HeapNode subRight = (HeapNode)this.rightChild;
                return subRight.findEmptySlotParent();
            }

        }
    }

}
