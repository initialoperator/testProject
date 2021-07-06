package com.chrystian.interviews;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.sql.rowset.spi.SyncResolver;


/**
 This problem can be solved in the same way of topological sort as for CourseScheduleII. 
 However, topological sort is still not fast enough for some large test cases in Leetcode.
 Therefore, due to the nature of this problem, we can use the "leaf stripping" way
 */
public class MinimumHeightTree {
    public static void main(String[] args) {
        MinimumHeightTree sol = new MinimumHeightTree();
        int[][] edges = {{1,0},{1,2},{1,3}};
        // edges = new int[][]{{0,1},{0,2},{0,3},{3,4},{4,5}};
        edges = new int[][]{};
        List<Integer> result = sol.findMinHeightTrees(1, edges);

        System.out.println(result);
    }    

    /*leaf stripping way. 
    The nature of this problem: middle node(s) are the result:
    -the result will be either 1 or 2 nodes in the middle, depends on the shape of the graph
    -each time, taking out the leaves (end tip of the graph) until the last one or two nodes are left.
    */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Set<Integer>> map = new ArrayList<>();
        List<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; i++){
            map.add(new HashSet<>());
        }
        for(int[] edge:edges){
            int node1 = edge[0];
            int node2 = edge[1];
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        for(int i = 0; i < n; i++){
            Set<Integer> node = map.get(i);
            if(node.size() == 1)
                leaves.add(i);
        }
        if(leaves.isEmpty())
            leaves.add(0);
        System.out.println("leaves at beginning: " + leaves);

        while(n > 2){
            n  -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();
            while(!leaves.isEmpty()){
                Integer leaf = leaves.remove(0);
                Set<Integer> neighbors = map.get(leaf);
                map.set(leaf, new HashSet<>());
                Iterator<Integer> iterator = neighbors.iterator();
                while(iterator.hasNext()){
                    Integer nei = iterator.next();
                    Set<Integer> neinei = map.get(nei);
                    neinei.remove(leaf);
                    if(neinei.size() == 1)
                        newLeaves.add(nei);
                }
            }
            System.out.println("new leaves: " + newLeaves);
            leaves = newLeaves;            
        }
        System.out.println(map);
        return leaves;

    }


    public List<Integer> findMinHeightTrees_slower(int n, int[][] edges) {//using topological sort, but slower compared to the leaf tripping way
        List<List<Integer>> map = new ArrayList<>();
            int[] visited = new int[n];
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int node1 = edge[0];
            int node2 = edge[1];
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        int height = 0;
        for(int i = 0; i < n; i++){
            int currHeight = findMinHeight(i, visited, map);
            height = height==0? currHeight : Math.min(height,currHeight);
            result[i] = currHeight;
        }
        
        System.out.println(Arrays.toString(visited));
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(result[i] == height)
                list.add(i);
        }
        return list;
    }
    private int findMinHeight(int node, int[] visited, List<List<Integer>> map){
        if(visited[node] == 0){
            visited[node] = -1;
            List<Integer> nexts = map.get(node);
            int height = 0;
            for(Integer next: nexts){
                if(visited[next] >= 0){
                    // System.out.println("Curr node: " + node);
                    int nextHeight = findMinHeight(next, visited, map);
                    // System.out.println("next height: " + nextHeight);
                    height =  Math.max(height, nextHeight);
                }
            }
            visited[node] = 1+height;
            return 1+height;            
        }else{
            return visited[node];
        }
    }
}
