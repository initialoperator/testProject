package com.chrystian.interviews;

import java.util.PriorityQueue;

public class MaxBuildingHeight {

	public static void main(String[] args) {
		MaxBuildingHeight sol = new MaxBuildingHeight();
		int buildingNum = 10;
//		int[][] restrictions = new int[][] {{5,3},{2,5},{7,4},{10,3}};
		int[][] restrictions = new int[][]{{8,5},{9,0},{6,2},{4,0},{3,2},{10,0},{5,3},{7,3},{2,4}};
		int result = sol.maxBuilding(buildingNum, restrictions);
		System.out.println("Result: " + result);
	}
	
	public int maxBuilding(int n, int[][] restrictions) {
		
	    PriorityQueue<int[]> restrs = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));	
	    boolean restrictionOnLast = false;
	    for(int[] r : restrictions) {
	    	r[0] = r[0] - 1;
	    	restrs.add(r);
	    	if(r[0] == n-1)
	    		restrictionOnLast = true;
//	    	System.out.println("r position: " + r[0]);
	    }
//	    restrs.add(new int[]{0, 0});
	    if(!restrictionOnLast)
	    	restrs.add(new int[] {n-1, Integer.MAX_VALUE});
	    
	    int posCurr = 0;
	    int heightCurr = 0;
	    
	    int maxHeight = 0;
	    
	    while(!restrs.isEmpty()) {
	    	int posPrev = posCurr;
	    	int heightPrev = heightCurr;
	    	int[] r = restrs.remove();
	    	posCurr = r[0];
	    	heightCurr = r[1];
	    	
	    	System.out.println("posCurr: " + posCurr);
	    	System.out.println("heightCurr: " + heightCurr);
	    	System.out.println();
	    	
	    	int posDiff = Math.abs(posCurr - posPrev);
	    	int heightDiff = Math.abs(heightPrev - heightCurr);
	    	int heightMin = Math.min(heightPrev, heightCurr);
	    	
	    	if(heightDiff >= posDiff) {
	    		maxHeight = Math.max(maxHeight, heightMin+posDiff);
	    	}else {
	    		maxHeight = Math.max(maxHeight, heightMin+(posDiff+1)/2);
	    	}
	    	
	    }
	    	
	    
		return maxHeight;
    }
}
