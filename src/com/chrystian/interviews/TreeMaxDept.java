package com.chrystian.interviews;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeMaxDept {



    public int maxDepth(Node root) {//bfs
        int depth = 0;
        Queue<Node> bfs = new LinkedList<>();
        if(root != null){
            root.val = 1;
            bfs.add(root);
        }
        while(!bfs.isEmpty()){
            Node node = bfs.remove();
            depth = node.val;
            List<Node> children = node.children;
            if(children.size()>0){
                depth = node.val+1;
                for(Node child:children){
                    child.val = depth;
                    bfs.add(child);
                }
            }
        }
        
        return depth;
    }

    public int maxDepth2(Node root) {//dfs
        if(root == null)
            return 0;
        else{
            int d = 0;
            List<Node> children = root.children;
            for(Node child: children){
                d = Math.max(d, maxDepth(child));
            }
            return 1+d;
        }
            
    }

    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
