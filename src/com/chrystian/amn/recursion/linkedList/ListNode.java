package com.chrystian.amn.recursion.linkedList;

public class ListNode {//this class is define by the problem, note that the integer stored in list node is in a reverse order
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	ListNode curr = head;
    	
    	for (int i = 2; i < 10; i++) {
    		curr.next = new ListNode(i);
    		curr = curr.next;
    	}
    	
//    	printNode(head);
    	
    	ListNode reverse = head.reverse();
    	
    	printNode(reverse);
    }
    
    public static void printNode(ListNode head) {
    	ListNode curr = head;
    	while(curr != null) {
    		System.out.print(curr.val + "->");
    		curr = curr.next;
    	}    	
    	System.out.println("");
    }

    public ListNode reverse() {
    	if(this.next == null)
    		return this;
    	else {
    		ListNode prev = this;
    		ListNode curr = next;
    		ListNode result = reverseNode(prev, curr);
    		prev.next = null;
    		return result;
    			
    	}    		
    	
    }
    
    private static ListNode reverseNode(ListNode prev, ListNode curr) {
    	if(curr.next == null) {
    		curr.next = prev;
    		return curr;
    	}else {
    		ListNode nextOne = curr.next;
    		curr.next = prev;    		
    		ListNode node = reverseNode(curr, nextOne);
    		
    		return node;
    	}
    	
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //assuming val is no greater than 9 and no smaller than 0 because it's a digit
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else {
            int sum = l1.val + l2.val;
            int extra = 0;
//            ListNode node = new ListNode(sum);
            if (sum > 9) {
                ListNode node = new ListNode(sum - 10);
                if (l1.next == null) {
                    ListNode nextNode = new ListNode(1);
                    node.next = addTwoNumbers(nextNode, l2.next);
                } else if (l2.next == null) {
                    ListNode nextNode = new ListNode(1);
                    node.next = addTwoNumbers(l1.next, nextNode);
                } else {
                    ListNode nextNode = new ListNode(1 + l1.next.val);
                    nextNode.next = l1.next.next;
                    node.next = addTwoNumbers(nextNode, l2.next);
                }
                return node;
            } else {
                ListNode node = new ListNode(sum);
                node.next = addTwoNumbers(l1.next, l2.next);
                return node;
            }
        }
    }

    /*https://leetcode.com/problems/merge-k-sorted-lists/description/*/
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 )
            return null;
        else{
            ListNode head = null;
            ListNode end = head;
            boolean stillGoing = true;
            int min = 0;
            while(stillGoing){
                stillGoing = false;
                for(ListNode list : lists){
                    if(list == null)
                        continue;
                    min = list.val;
                    stillGoing = true;
                }
                if(!stillGoing)
                    break;
                for(ListNode list : lists){
                    if(list == null)
                        continue;
                    min = Math.min(min, list.val);
                }
                if(head == null){
                    end = new ListNode(min);
                    head = end;
                }else{
                    end.next = new ListNode(min);
                    end = end.next;
                }
                for(int i = 0; i < lists.length; i++){
                    if(lists[i] == null)
                        continue;
                    if(lists[i].val == min){
                        end.val = min;
                        lists[i] = lists[i].next;
                        break;
                    }
                }

            }
            return head;
        }
    }

    public static ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        else{
            int length = lists.length;
            int sublength1 = length/2;
            int sublength2 = length - sublength1;
            ListNode[] sublist1 = new ListNode[sublength1];
            ListNode[] sublist2 = new ListNode[sublength2];
            for(int i = 0; i < sublength1; i++){
                sublist1[i] = lists[i];
            }
            for(int i = 0; i < sublength2; i++){
                sublist2[i] = lists[i+sublength1];
            }
            ListNode ln1 = mergeKListsDivideAndConquer(sublist1);
            ListNode ln2 = mergeKListsDivideAndConquer(sublist2);
            return mergeListNodes(ln1,ln2);
        }
    }
    private static ListNode mergeListNodes(ListNode n1, ListNode n2){
        ListNode head = null;
        ListNode tail = head;
//        while(true){
            if(n1 == null){
                if(head == null){
                    tail = n2;
                    head = tail;
//                    break;
                }else{
                    tail.next = n2;
                }
            }else if(n2 == null){
                if(head == null){
                    tail = n1;
                    head = tail;
//                    break;
                }else{
                    tail.next = n1;
                }
            }else{
                int min = Math.min(n1.val, n2.val);
                if(head == null){
                    tail = new ListNode(min);
                    head = tail;
                }else{
                    tail.next = new ListNode(min);
                    tail = tail.next;
                }
                if(min == n1.val)
                    tail.next = mergeListNodes(n1.next, n2);
                else
                    tail.next = mergeListNodes(n1, n2.next);
            }
//        }
        return head;
    }
}
