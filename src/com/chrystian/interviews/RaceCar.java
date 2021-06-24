package com.chrystian.interviews;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RaceCar {

	public static void main(String[] args) {
		String output = findPath2(34);
		System.out.println(output);
		System.out.println(output.length());
		int num = 0;
//		num = findNumberOfPath(0);
//		System.out.println(num);
		
		
		num = racecarHelperWithDP(34);
		System.out.println(num);
//
//		num = findNumberOfPath2(5478);
//		System.out.println(num);
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
	        while(!q.isEmpty()) {
	            Node top = q.remove();
	            if(top.pos + top.speed == target) return top.cost+1;
	            q.add(new Node(top.pos + top.speed, top.speed * 2, top.cost+1));
	            if(top.speed > 0 && top.pos + top.speed > target)
	                q.add(new Node(top.pos, -1, top.cost+1));
	            if(top.speed < 0 && top.pos + top.speed < target)
	                q.add(new Node(top.pos, 1, top.cost+1));
	        }
	        return 0;
	    }
	    public static int racecarHelperWithDP(int target) {
	        Queue<Node> q = new LinkedList<>();
			Set<String> visited = new HashSet<>();
	        q.add(new Node(0,1,0));
	        while(!q.isEmpty()) {
	            Node top = q.remove();
	            String key = "pos"+top.pos+"speed"+top.speed;
				if(visited.contains(key)) {
					continue;
				}else {
					visited.add(key);
				}
	            if(top.pos + top.speed == target) return top.cost+1;
	            q.add(new Node(top.pos + top.speed, top.speed * 2, top.cost+1));
	            if(top.speed > 0 && top.pos + top.speed > target)
	                q.add(new Node(top.pos, -1, top.cost+1));
	            if(top.speed < 0 && top.pos + top.speed < target)
	                q.add(new Node(top.pos, 1, top.cost+1));
	        }
	        return 0;
	    }
	
	private static class State {
		char instruction = ' ';
		long pos;
		long speed;
		public State() {
			
		}
		public State(long pos, long speed) {
			this.pos = pos;
			this.speed = speed;
		}
	}
	public static int findNumberOfPath2(int target) {
		Queue<State> queue = new LinkedList<>();
		int count = 0;
		//initial setup
		State initial = new State();
		initial.instruction = ' ';
		initial.pos = 0;
		initial.speed = 1;
		queue.add(initial);
		Queue<State> next = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		while(true) {
			while(!queue.isEmpty()) {				
				State s = queue.remove();
				String key = "pos"+s.pos+"speed"+s.speed;
				if(visited.contains(key)) {
					continue;
				}else {
					visited.add(key);
				}
				if(s.pos == target) {
					return count;
				}
				
				State newA = new State(s.pos+s.speed, s.speed * 2);
				State newR = new State(s.pos, s.speed > 0? -1 : 1);
				
				next.add(newA);
				if(s.speed > 0 && s.pos + s.speed > target)
	                next.add(newR);
	            if(s.speed < 0 && s.pos + s.speed < target)
	                next.add(newR);
					
			}
			count++;
			queue = next;
			next = new LinkedList<>();
		}		
	}
	
	public static int findNumberOfPath(int target) {
		long pos = 0;
		long speed = 1;
		
		List<Character> list = new ArrayList<>();
		Queue<State> queue = new LinkedList<>();
		
		//initial setup
		State initial = new State();
		initial.instruction = ' ';
		initial.pos = 0;
		initial.speed = 1;
		queue.add(initial);
//		construct2
		int count = 0;
		while(!queue.isEmpty()) {
			State s = queue.remove();
			State newA = new State();
			newA.instruction = 'A';
			newA.pos = s.pos+s.speed;
			newA.speed = s.speed * 2;
			
			State newR = new State();
			newR.instruction = 'R';
			newR.pos = s.pos;
			newR.speed = s.speed > 0? -1 : 1;
			
			count++;			
			if(newA.pos == target)
				break;
			queue.add(newA);
			count++;
			if(newR.pos == target)
				break;
			queue.add(newR);
		}
//		System.out.println(count);
		int depth = 0;
		while(count>0) {
			depth++;
			count = (count- 1)/2;
		}
		return depth;
	}
	
	public static String findPath2(int target) {
		long pos = 0;
		long speed = 1;
		
		List<Character> list = new ArrayList<>();
		Queue<State> queue = new LinkedList<>();
		
		//initial setup
		State initial = new State();
		initial.instruction = ' ';
		initial.pos = 0;
		initial.speed = 1;
		queue.add(initial);
//		construct2
		int count = 0;
		while(!queue.isEmpty()) {
			State s = queue.remove();
			State newA = new State();
			newA.instruction = 'A';
			newA.pos = s.pos+s.speed;
			newA.speed = s.speed * 2;
			
			State newR = new State();
			newR.instruction = 'R';
			newR.pos = s.pos;
			newR.speed = s.speed > 0? -1 : 1;
			
			count++;			
			if(newA.pos == target)
				break;
			queue.add(newA);
			count++;
			if(newR.pos == target)
				break;
			queue.add(newR);
		}
		System.out.println(count);
		//find lowerBound
		int lowerBound = 0;
		int power = 0;
		while(true) {
			int upperBound = lowerBound + (int) Math.pow(2, power);
			if(upperBound > count)
				break;
			lowerBound = upperBound;
			power++;
		}
		
		//trace path
		StringBuilder sb = new StringBuilder();
		while(power > 0) {
			int leavePos = count - lowerBound +1;
			if(leavePos % 2 == 0) {
				sb.append("R");
			}else {
				sb.append("A");
			}
			count = (count -1)/2;
			power--;
			lowerBound = lowerBound - (int)Math.pow(2, power);
		}
		return sb.reverse().toString();
	}
	public static String findPath(int target) {
		long pos = 0;
		long speed = 1;
		
		List<Character> list = new ArrayList<>();
		Queue<State> queue = new LinkedList<>();
		
		//initial setup
		State initial = new State();
		initial.instruction = ' ';
		initial.pos = 0;
		initial.speed = 1;
		
		State firstA = new State();
		firstA.instruction = 'A';
		firstA.pos = pos + speed;
		firstA.speed = speed * 2;
		
		State firstR = new State();
		firstA.instruction = 'A';
		firstA.pos = pos ;
		firstA.speed = -1;
		
		queue.add(initial);
		//construct
		int count = 0;		
		while (!queue.isEmpty()) {
			
			State s = queue.remove();
			State newA = new State();
			newA.instruction = 'A';
			newA.pos = s.pos+s.speed;
			newA.speed = s.speed * 2;
			
			State newR = new State();
			newR.instruction = 'R';
			newR.pos = s.pos;
			newR.speed = s.speed > 0? -1 : 1;
			
			list.add(s.instruction);
			
			queue.add(newA);
			if(newA.pos == target)
				break;
			queue.add(newR);
			if(newR.pos == target)
				break;
			
			
		}
		
		
		//empty the queue
		while (!queue.isEmpty()) {
			list.add(queue.remove().instruction);
		}
		
		System.out.println(list);
		
		StringBuilder sb = new StringBuilder(); 
		//calculate path
		int index = list.size() - 1;
		while(index > 0) {
			sb.append(list.get(index));	
			index = (index - 1)/2;
		}
		
//		calculate path2
//		int power = 0;
//		int lowerBound = 0;
//		while(true) {
//			int upper = lowerBound + (int) Math.pow(2, power);
//			if(upper > list.size())
//				break;
//			else {
//				lowerBound = upper;
//				power++;
//			}
//		}
//		
//		int position = list.size() - lowerBound -1;
//		while(lowerBound > 0) {
//			System.out.println(lowerBound);
//			sb.append(list.get(position+lowerBound));
//			lowerBound = lowerBound / 2;
//			position = position / 2;
//			
//		}
//		sb.append(list.get(position));
		
		return sb.reverse().toString();
	}
	
}
