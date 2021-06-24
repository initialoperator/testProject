package com.chrystian.interviews;

import java.util.Arrays;

public class ArithmeticSubsequences {
	public static void main(String[] args) {
		ArithmeticSubsequences as = new ArithmeticSubsequences();
//		int[] array = {2,4,6,8,10};
		int[] array = {7,7,7,7,7};
		int result = as.numberOfArithmeticSlices(array);
		
		System.out.println("final result: " + result);
	}
	  public int numberOfArithmeticSlices(int[] nums) {
	        //sort the arrays
	    	Arrays.sort(nums);
	    	System.out.println("nums print: "+ Arrays.toString(nums));
	    	int bigDiff = nums[nums.length-1] - nums[0];
	    	int[][][] masterDict = new int[nums.length][bigDiff+1][1];
	    	for (int i = 0; i <= nums.length; i++) {
				for (int j = 0; j < masterDict[0].length; j++) {
					findAS(nums, masterDict, i, j, i);
					
				}
			}

	    	int count = 0;
	    	for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j <= bigDiff; j++) {
//					if(j == 2)
//				    	System.out.println(masterDict[i][j][0]);
					int length = masterDict[i][j][0];
					count += calculateSubSeq(j, length);
				}
			}
	    	return count;
	    }
	    
	   private void findAS(int[] nums,  int[][][] masterDict, int start, int diff, int curr) {
	    	if(curr >= nums.length)
	    		return;
	    	if(masterDict[start][diff][0] < 0)
	    		return;
	    	if(curr == start) {
	    		masterDict[start][diff][0] = 1;
	    		findAS(nums, masterDict, start, diff, curr+1);
	    	}else {
	    		int currNum = nums[curr];
	    		int startNum = nums[start];
	    		if(diff == 0) {
	    			if(currNum == startNum) {
	    				masterDict[start][diff][0]++;
	        			masterDict[curr][diff][0] = -1;
	    			}
	    			findAS(nums, masterDict, start, diff, curr+1);
	    			return;
	    		}
	    		if(((currNum - startNum) % diff == 0)
	    				&& ((currNum - startNum) / diff == masterDict[start][diff][0])){
	    			masterDict[start][diff][0]++;
	    			masterDict[curr][diff][0] = -1;
	    		}
	    		findAS(nums, masterDict, start, diff, curr+1);
	    	}
	    		
	    }
	    
	    private int calculateSubSeq(int diff, int sequenceLength) {
	    	int count = 0;
	    	if(sequenceLength < 3)
	    		return 0;
	    	if(diff == 0) {
	    		int possibilities = (int) Math.pow(2, sequenceLength) - sequenceLength - sequenceLength*(sequenceLength-1)/2 -1;
	    		count+= possibilities;
	    		return count;
	    	}
	    		
	    	for (int i = 1; i < sequenceLength; i++) {
				int possibilities =   sequenceLength - (2*i + 1) >= 0 ? 1 + 2 *(sequenceLength - 2*i - 1) : 0;
				count += possibilities;
			}
	    	return count;
	    }
}
