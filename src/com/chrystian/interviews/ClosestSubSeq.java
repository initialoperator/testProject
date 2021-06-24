package com.chrystian.interviews;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClosestSubSeq {

	public static void main(String[] args) {
		int[] array = new int[]{5, -7, 3, 5};
		ClosestSubSeq sol = new ClosestSubSeq();
		int minDiff = sol.minAbsDifference(array, 6);
		
		System.out.println("result is: " + minDiff);
		
		array = new int[]{7,-9,15,-2};
		minDiff = sol.minAbsDifference(array, -5);
		
		System.out.println("result is: " + minDiff);
		
		array = new int[] {1556913,-259675,-7667451,-4380629,-4643857,-1436369,7695949,-4357992,-842512,-118463};				
		minDiff = sol.minAbsDifference(array, -9681425);
		System.out.println("result is: " + minDiff);
		
		array = new int[] {-7189,-110,-8880,2590,-8095,-1448,263,-5740,-1471,2457,-6162,-47,-6918,3920,-1960,6473,8257,-3270};
		minDiff = sol.minAbsDifference(array, -662776569);
		System.out.println("result is: " + minDiff);
	}
    public int minAbsDifference(int[] nums, int goal) {
    	int result = Math.abs(goal);
    	
    	Map<String, Integer> dpMap = new HashMap<>();
    	List<Integer> numsl = IntStream.of(nums).sorted().boxed().collect(Collectors.toList());
    	int sum = IntStream.of(nums).sum();
    	result = Math.min(result, minHelper(numsl, dpMap, goal, sum));
    	return result;
    }
    
    private int minHelper(List<Integer> list, Map<String, Integer> dpMap, int goal, int  sum) {
    	int currMin = Math.abs(sum - goal);
    	if(list.isEmpty())
    		return currMin;
    	StringBuilder sb = new StringBuilder();
    	for(Integer i: list) {
    		sb.append(i);sb.append(',');    		
    	}
    	String key = sb.toString();
    	if(dpMap.containsKey(key)) {
    		int thatMin = dpMap.get(key);
    		return Math.min(currMin, thatMin);
    	}
    	int minTemp = currMin;
    	for (int i = 0; i < list.size(); i++) {
			Integer element = list.get(i);
			int position = i;
    		List<Integer> newL = IntStream.range(0, list.size()).filter(index -> index != position).map(index -> list.get(index)).boxed().collect(Collectors.toList());
    		minTemp = Math.min(minTemp, minHelper(newL, dpMap, goal, sum - element));
    	}
    	dpMap.put(key, minTemp);
    	return minTemp;
    }
    
    
    
    public int minAbsDifference2(int[] nums, int goal) {        
        int sum = IntStream.of(nums).sum();    
        System.out.println("total sum: " + sum);
        int currMin = Math.min(Math.abs(goal), Math.abs(sum - goal));
        List<Integer> negatives = IntStream.of(nums).filter(i -> i < 0).boxed().collect(Collectors.toList());
        List<Integer> positives = IntStream.of(nums).filter(i -> i > 0).boxed().collect(Collectors.toList());
        int result = removeElementsAndFindMin(goal, currMin, sum, positives, negatives);
//        result = Math.min(currMin, result);
    	return result;
    }
    
    private int removeElementsAndFindMin(int goal, int currMin, int sum, List<Integer> positives, List<Integer> negatives) {
    	if(sum == goal)
    		return 0;
    	
    	if((sum > goal && positives.isEmpty())
    			|| (sum < goal && negatives.isEmpty())
    			||(positives.isEmpty() && negatives.isEmpty())) {
    		return currMin;
    	}else {
    		int newSum = sum;
    		if(sum > goal) {
    			Integer ele = positives.stream().map(i -> Math.abs( sum - i - goal)).sorted().findFirst().get();
    			int i = 0;
    			while(true) {
    				if(positives.get(i) == sum - goal - (sum - positives.get(i) - goal)/Math.abs(sum - positives.get(i) - goal) * ele)
    					break;
    				i++;
    			}
    			Integer element = positives.remove(i);
    			 newSum = sum - element;
    			
    		}else {
    			Integer ele = negatives.stream().map(i -> Math.abs(sum - i - goal)).sorted().findFirst().get();
    			int i = 0;
    			while(true) {
    				if(negatives.get(i) == sum - goal - (sum - negatives.get(i) - goal)/Math.abs(sum - negatives.get(i) - goal)*ele)
    					break;
    				i++;
    			}
    			Integer element = negatives.remove(i);
    			 newSum = sum - element;
    		}
    		currMin = Math.min(currMin, Math.abs(newSum - goal));
    		return removeElementsAndFindMin(goal, currMin, newSum, positives, negatives);
    	}
    }
  
}
