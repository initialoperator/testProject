package com.chrystian.amn.recursion.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPathTest {

	static class Node{
		int val;
		List<Node> neighbors;
	}
	
	public static List<Node> shortestPath(Node start, Node end){
		List<Node> result = new ArrayList<>();
		Map<Node, Node> traceParent = new HashMap<>();
		java.util.Queue<Node> pipe = new java.util.LinkedList();
		pipe.add(start);
		traceParent.put(start, null);
		while(!pipe.isEmpty()) {
			Node node = pipe.poll();
			List<Node> neighbors = node.neighbors;
			for(Node n : neighbors) {
				if(!traceParent.containsKey(n)) {
					traceParent.put(n, node);
					if (n == end)
						break;
				}
			}
		}
		Node curr = end;
		java.util.Stack<Node> s = new java.util.Stack<>();
		while(curr != null) {
			s.add(curr);
			curr = traceParent.get(curr);
		}
		
		//missing transfering data from stack to list
		
		return result;
	}
}
