package com.chrystian.java8.pratice.streams;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class CombineSingleLinkedLists {

//	LinkedList#add
//	LinkedList#
	
	public Queue<Integer> mergeLinkedLists(Queue<Integer> a, Queue<Integer> b){
		Queue<Integer> result = new LinkedList<>();
		
		while(!a.isEmpty()&& !b.isEmpty()) {
			if(a.peek() < b.peek()) {
				result.add(a.remove());
			}else {
				result.add(b.remove());
			}
		}
		
		while(!a.isEmpty()) {
			result.add(a.remove());
		}
		while(!b.isEmpty()) {
			result.add(b.remove());
		}
		
		
		return result;
	}
	
	public LinkedList<Integer> mergeLinkedLists(LinkedList a, LinkedList b){
		LinkedList<Integer> result = new LinkedList<>();
		ListIterator<Integer> ia = a.listIterator(0);
		ListIterator<Integer> ib = b.listIterator(0);
		
		
		while(ia.hasNext() && ib.hasNext()) {
			Integer aHead = ia.next();
			Integer bHead = ib.next();
			
			if(aHead < bHead)
		}
		return result;
	}
	
	
//	表t2（date--日期，格式“2021-01-01”，time_t--时间，uid--用户id，is_login--是否登录，0未登录，1已登录）
//
//	1.求截止到今天内的前30天内登录5天及以上的用户的所有uid列表
	
	
//	select uid, count(is_login) from t2 where is_login = 1 and date > sysdate - 30 group by uid having count(is_login) >= 5
			
	select uid,count(date) from(	
	select distinct date, uid from t2 where is is_login = 1 and date > sysdate - 30
	) 
	group by uid having count(date) >=5
	
	
 
	
}
