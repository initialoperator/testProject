package com.chrystian.interviews;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;




public class RaceCar2 {

	public static void main(String[] args) {

		int num = 0;		
		num = racecarHelper(5478);
		System.out.println(num);

	}
	
	private static class Node {
        public int pos; 
        public int speed;
        public int cost;
        Node(int pos, int speed, int cost) {
            this.pos = pos;
            this.speed = speed;
            this.cost = cost;
        }
    }
    public static int racecarHelper(int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,1,0));
        Queue<Node> next = new LinkedList<>();
		Set<String> visited = new HashSet<>();
        while(true) {
        	while(!q.isEmpty()) {
                Node top = q.remove();
                
                String key = "pos"+top.pos+"speed"+top.speed;
    			if(visited.contains(key)) {
    				continue;
    			}else {
    				visited.add(key);
    			}
    			
                if(top.pos + top.speed == target) return top.cost+1;
                next.add(new Node(top.pos + top.speed, top.speed * 2, top.cost+1));
                if(top.speed > 0 )
                    next.add(new Node(top.pos, -1, top.cost+1));
                if(top.speed < 0)
                    next.add(new Node(top.pos, 1, top.cost+1));
            }
        	q = next;
        	next = new LinkedList<>();
        }
		
//        return 0;
    }
    

//    public int racecarUsingPair(int target) {
//        LinkedList<Pair<Integer,Integer>> list=new LinkedList<>();
//        HashSet<Pair<Integer,Integer>> visit=new HashSet<>();
//        Pair<Integer,Integer> p=new Pair<>(0,1);
//        list.addLast(p);
//        visit.add(p);
//        for (int level=0;list.size()>0;level++){
//            int size=list.size();
//            while (size-->0){
//                Pair<Integer,Integer> info=list.removeFirst();
//                int pos=info.getKey(),speed=info.getValue();
//                if (pos==target) return level;
//                Pair<Integer,Integer> next=new Pair<>(pos+speed,speed<<1);
//                if (!visit.contains(next) && pos+speed>0 && pos+speed<target*2){
//                    list.add(next);
//                    visit.add(next);
//                }
//                next=new Pair<>(pos,speed>0?-1:1);
//                if (!visit.contains(next) && pos>0 && pos<target*2){
//                    list.add(next);
//                    visit.add(next);
//                }
//            }
//        }
//        return -1;
//    }
}
