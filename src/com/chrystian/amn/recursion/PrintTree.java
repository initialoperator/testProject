package com.chrystian.amn.recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PrintTree {
	//author: 面试者张扬
	//面试题目：建造一个二叉树(binary tree),并可以把这个tree上每个节点的路径都打出来

	public static void main(String[] args) {
		//testing
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		Tree t = new Tree(n1);
		t.addNode(n2);
		t.addNode(n3);
		t.addNode(n4);
		t.addNode(n5);
		t.addNode(n6);
		t.addNode(n7);
		
		t.printTree();
	}
	public static class Node{
		//为了考虑到能把节点上的所有路径都打出来，有的节点会重复出现，为了方便实现此功能，每个Node都会用个对父节点（parent）的
		//In order to print all the paths connecting all nodes, some nodes will be repeatedly printed.
		//Therefore, a parent node reference is introduced in each Node object
		Integer value;
		Node parent;//对父节点的引用
		Node left;
		Node right;
		
		public Node(int i) {
			value = new Integer(i);
			//因为要及时引用父节点，所以子节点本身不可为null，当node.value == null时，理解为该节点未补触碰
			//In order to immediately reference its parent node, a child node cannot be null.
			//node.value == null means this node is prestige.
			left = new Node();
			right = new Node();
			left.parent = this;
			right.parent = this;
		}
		
		public Node() {
		}
		public static void addNode(Node head, Node node) {//把新节点加当前节点的根下 add new node to leave
			if(head.value ==null) {
				head.value = node.value;
				head.left = new Node();
				head.right = new Node();
				head.left.parent = head;
				head.right.parent = head;
			}else {
				
				Node child;
				if(getHeight(head.left) > getHeight(head.right))//树高度平衡逻辑 tree balancing logic
					child = head.right;
				else {
					child = head.left;
				}
				addNode(child, node);
			}
		}
		
		public static int getHeight(Node head) {
			if(head.value == null)
				return 0;
			else
				return 1 + Math.max(getHeight(head.left), getHeight(head.right));
		}
		
	}
	
	public static class Tree{
		Node head;//根
		public Tree(Node node) {
			this.head = node;
		}
		
		public void addNode(Node node) {
			Node.addNode(head, node);
		}
		
		public void printTree() {
			Set<Node> s = this.getAllLeaves();

			s.stream().forEach(n -> {
				Stack<Node> bucket = new Stack<>();
				//因为我们是从叶开始寻根，所以会用盏把顺序倒回来
				//since it starts from a leave, a stack is used to reverse the order from head(root)
				pushToStack(bucket, n);
				StringBuilder sb = new StringBuilder(bucket.pop().value.toString());
				while(!bucket.empty()) {
					sb.append("->" + bucket.pop().value);
				}
				System.out.println(sb.toString());
			});
		}
		
		private Set<Node> getAllLeaves(){//此方法目的为返回所有叶节点 return all leaves of the tree
			Set<Node> result = new HashSet<>();
			pushAllLeaves(result, head);
			return result;
		}
		
		private static void pushAllLeaves(Set<Node> set, Node node) {
			//返回叶节点核心递归算法
			//core recursive algorithm of returning all leaves
			if(node.left.value == null && node.right.value == null) {
				set.add(node);
			}else {
				if(node.left.value != null) {
					pushAllLeaves(set, node.left);
				}
				if(node.right.value != null) {
					pushAllLeaves(set, node.right);
				}
			}
		}
		
		private static void pushToStack(Stack<Node> stack, Node node) {
			//节点链条倒置算法
			//node path reversion algorithm.
			stack.push(node);
			if(node.parent != null) {
				pushToStack(stack, node.parent);
			}
		}
		
		
	}
}
