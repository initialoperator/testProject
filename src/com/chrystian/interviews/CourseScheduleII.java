package com.chrystian.interviews;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/*
This problem should be solved with a topological sorting way. The algorithm simulates traversing in a graph of nodes with a map for nodes and a map for dp
Key points to remember about this simulation:
-for the dp map, a node can have 3 states:
    -unvisited
    -visiting/unsettled, meaning its visit is not finsihed because the program is currently visiting its next nodes in a recursion
    -visited/settled
-if the recursive program encounters an unsetled node, it means a cycle is found in the graph.
*/
public class CourseScheduleII {//Amazon questiion

    public static void main(String[] args) {
        CourseScheduleII sol = new CourseScheduleII();
        int[][] prerequisites =  {{1,0},{2,0},{3,1},{3,2}};
        int[] result = sol.findOrder(4, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            map.add(new ArrayList<>());
        }
        for(int[] dep : prerequisites){
            int curr = dep[0];
            int prev = dep[1];
            map.get(curr).add(prev);
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfsWithList(visited, i, map, list))
                return new int[0];
        }
        


        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    private boolean dfsWithList(int[] visited, int course, List<List<Integer>> courses, List<Integer> list){
        if(visited[course] ==  1){
            return false;
        }
        if(visited[course] == 0){
            visited[course] = 1;
            List<Integer> prevs = courses.get(course);
            for(Integer prev: prevs){
                if(!dfsWithList(visited, prev, courses, list))
                    return false;
            }
            visited[course] = 2;
            list.add(course);
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        //preparing:
        List<List<Integer>> courses = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<>());
        }
        for(int[] dep: prerequisites){
            int prev = dep[1];
            int curr = dep[0];
            courses.get(curr).add(prev);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(visited, i, courses))
                return false;
        }
        return true;
    }

    private boolean dfs(int[] visited, int course, List<List<Integer>> courses){
        if(visited[course] == 2)
            return true;
        else if(visited[course] == 1){
            return false;
        }else{
            visited[course] = 1;
            List<Integer> prevs = courses.get(course);
            for(Integer p: prevs){
                if(!dfs(visited, p, courses))
                    return false;
            }
        }
        visited[course] = 2;
        return true;
    }
    
    
    
   
    
}
