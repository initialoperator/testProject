package com.chrystian.tencent;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AntsGetWarm {

	
	public static double getWarmupTime(List<Integer> ants, int distance) {
		List<Integer> sorted = ants.stream().collect(Collectors.toList());
		
		boolean done = false;
		
		while(!done) {
			double[] moves = new double[sorted.size()];
			for(int i = 0; i < sorted.size(); i++) {
				if(i == 0) {
					if(Math.abs(sorted.get(0) - sorted.get(1)) == distance)
						continue;
					else {
						double gap = distance - Math.abs(sorted.get(0) - sorted.get(1));
						if(gap < 0 && i > 0) {
							sorted.set(i, sorted.get(i)-1);
							moves[i] = -1;
						}else if(gap > 0) {
							sorted.set(i, sorted.get(i)+1);
							moves[i] = 1;
						}
						continue;							
					}
				}
				
				if(Math.abs(sorted.get(i) - sorted.get(i+1)) == distance
						|| Math.abs(sorted.get(i) - sorted.get(i-1)) == distance) 
					continue;
				
				
			}
			boolean hasmove = false;
			for(int i = 0; i < moves.length && !hasmove; i++) {
				if(moves[i] != 0)
					hasmove = true;
			}
			done = !hasmove;
		}
		
		return 0.00;
	}
}
