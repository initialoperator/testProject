package com.chrystian.amn.sorting;

import java.util.ArrayList;
import java.util.List;

public class HeapTree {//Min-heap
    private HeapNode head;
//    private HeapNode last;
    private HeapNode lastParent;//when the head is not yet initialized, last parent is meaning less. As soon as the head has value, the last parent will be at least the head.

    public HeapTree(){
        this.head = null;
//        this.last = head;
    }

    public void addNode(HeapNode node){
        if(head == null){
            head = node;
            lastParent = head;
        }else{
            HeapNode.addChildToLastParent(node, lastParent);
            //need to adjust() here;
            head.adjust(lastParent, node);
            this.lastParent = head.findLastNodeParent();
        }
    }

    public String stringify(){
        List<HeapNode> nodeList = new ArrayList<>();
        nodeList.add(head);
        int level = 0;
        StringBuilder sb = new StringBuilder();
        while(nodeList.size() > 0){
            List<HeapNode> childList = new ArrayList<>();
            sb.append("Level: "+level+": ");
            for(HeapNode node : nodeList){
                sb.append(node.value + "  ");
            }
            sb.append("\n");
            for(HeapNode node : nodeList){
                if(node.leftChild != null)
                    childList.add((HeapNode)node.leftChild);
                if(node.rightChild != null)
                    childList.add((HeapNode)node.rightChild);
            }
            nodeList = childList;
            level++;
        }
        return sb.toString();
    }

}
