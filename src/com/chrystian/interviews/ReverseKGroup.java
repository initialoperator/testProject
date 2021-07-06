package com.chrystian.interviews;

public class ReverseKGroup {
	public static void main(String[] args) {
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(10);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		
		ReverseKGroup sol = new ReverseKGroup();
		ListNode result = sol.reverseKGroup(n0, 1);
		
		StringBuilder sb = new StringBuilder();
		while(result!= null) {
			sb.append(result.val);sb.append("->");
			result = result.next;
		}
		
		System.out.println(sb);
	}
	
//	 Definition for singly-linked list.
	  static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 

    public ListNode reverseKGroup(ListNode head, int k) {
        //calculate the length of the list
    	int length = getLength(head);
    	int rep = length / k;
    	ListNode sentinel = new ListNode(Integer.MIN_VALUE);
    	sentinel.next = head;
    	
    	ListNode prev = sentinel; ListNode lastTail = sentinel;
    	ListNode curr = prev.next;
    	for(int i = 0; i < rep; i++) {    		
    		for(int m = 0; m < k; m++) {
    			if(m == k-1) {
//    				System.out.println("curr: " + curr.val);
    				ListNode nextHead = curr.next;
    				curr.next = prev;
    				ListNode originalHead = lastTail.next;
    				lastTail.next = curr;
    				originalHead.next = nextHead;
    				curr = nextHead;
    				lastTail = originalHead;
    				prev = lastTail;
    				
    			}else {
    				ListNode next = curr.next;
    				curr.next = prev;
    				prev = curr;
    				curr = next;
    			}
    		}
    		
    	}
    	
    	
    	return sentinel.next;
    }
    
    private int getLength(ListNode node) {
    	if(node == null)
    		return 0;
    	else
    		return 1 + getLength(node.next);
    }
}
