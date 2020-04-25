package com.chrystian.amn.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MapRouteProblem {
    public static void main(String[] args){
        char[][] map = {
                {'O', 'O', 'O', 'O'},
                {'D', 'D', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'},
                };
        Integer result = navigate(map, 0, 0, 3,0);
        System.out.println(result);
    }

    private static Integer navigate(char[][] map, int startx, int starty, int targetx, int targety){
        if(startx == targetx && starty == targety){
            return 0;
        }
        if(map[startx][starty] == 'O'){
            map[startx][starty] = 'P';
            Integer left = null;
            Integer right = null;
            Integer up = null;
            Integer down = null;
            List<Integer> chances = new ArrayList<>();
            if(startx -1 >= 0){
                left = navigate(map, startx-1, starty, targetx, targety);
            }
            if(startx + 1 < map.length){
                right = navigate(map, startx+1, starty, targetx, targety);
            }
            if(starty - 1 >= 0){
                up = navigate(map, startx, starty-1, targetx, targety);
            }
            if(starty + 1 < map[0].length){
                down = navigate(map, startx, starty+1, targetx, targety);
            }
            if(left!=null)
                chances.add(left);
            if(right!=null)
                chances.add(right);
            if(up!=null)
                chances.add(up);
            if(down!=null)
                chances.add(down);
            if(chances.size() == 0)
                return null;
            Optional<Integer> shortest = chances.stream().sorted().findFirst();
            return 1 + shortest.get();
        }else {
            return null;
        }
    }
}
