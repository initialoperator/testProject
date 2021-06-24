package com.chrystian.amn.recursion.trees;

import java.util.Stack;

public class ShortestDistance {
	
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode();
		n0.val = 0;
		TreeNode n1 = new TreeNode();
		n1.val = 1;
		TreeNode n2 = new TreeNode();
		n2.val = 2;
		TreeNode n3 = new TreeNode();
		n3.val = 3;
		TreeNode n4 = new TreeNode();
		n4.val = 4;
		TreeNode n5 = new TreeNode();
		n5.val = 5;
		TreeNode n6 = new TreeNode();
		n6.val = 6;
		TreeNode n7 = new TreeNode();
		n7.val = 7;
		TreeNode n8 = new TreeNode();
		n8.val = 8;
		TreeNode n9 = new TreeNode();
		n9.val = 9;
		TreeNode n10 = new TreeNode();
		n10.val = 10;
		TreeNode n11 = new TreeNode();
		n11.val = 11;
		
		n0.leftChild = n1; n0.rightChild = n2;
		n1.leftChild = n3; n1.rightChild = n4;
		n2.leftChild = n5; n2.rightChild = n6;
		n3.leftChild = n7; n3.rightChild = n8;
		n4.leftChild = n9; n4.rightChild = n10;
		n5.leftChild = n11;
		
		int dist1 = findDistance(n2, n5, n0);
		int dist2 = findDistance(n10, n6, n0);
		
		System.out.println(dist1);
		System.out.println(dist2);
	}

	public static int findDistance(TreeNode n1, TreeNode n2, TreeNode root) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		constructPaths(s1, s2, n1, n2, root);
		System.out.println(s1);
		System.out.println(s2);
		while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
			s1.pop();
			s2.pop();
		}
		return s1.size()+s2.size();
	}
	public static void constructPaths(Stack<TreeNode> s1, Stack<TreeNode> s2,TreeNode n1, TreeNode n2, TreeNode currentNode) {
		if(currentNode == null)
			return;
		if(currentNode == n1)
			s1.push(currentNode);
		if(currentNode == n2)
			s2.push(currentNode);
		
		if(s1.size() > 0 && s1.peek() == n1 && s2.size() > 0 && s2.peek() == n2)
			return;
		
		int size1b4 = s1.size();
		int size2b4 = s2.size();
		
		constructPaths(s1, s2, n1, n2, currentNode.leftChild);
		constructPaths(s1, s2, n1, n2, currentNode.rightChild);
		
		int size1af = s1.size();
		int size2af = s2.size();
		
		if(size1af > size1b4)
			s1.push(currentNode);
		if(size2af > size2b4)
			s2.push(currentNode);
	}
}
