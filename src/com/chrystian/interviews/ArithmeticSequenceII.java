package com.chrystian.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSequenceII {

	public static void main(String[] args) {
		
		int[] array = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//		int[] array = new int[]{2,4,6,8,10};
//		int[] array = new int[]{7,7,7,7,7};
		ArithmeticSequenceII sol = new ArithmeticSequenceII();
		int result = sol.numberOfArithmeticSlices(array);
		
		System.out.println("result: " + result);
		
		
//		String input = "abcdefghijklmnopqrstuvzxyz";
//		String[] output = sol.getPermutations(input);
//		for(String s : output) {
//			System.out.println(s);
//		}
	}
	
	public int numberOfArithmeticSlices(int[] nums) {
		int length = nums.length;
		int comArrayLength = 1 << length;
		Map<Integer,List<Integer>> dpMap = new HashMap<>();
//		Arrays.fill(dpMap, null);
		Arrays.sort(nums);
		int count = 0;
		
		for(int i = 0; i < comArrayLength; i++) {
			int shift = (int) (Math.log(i)/Math.log(2));
			int prevKey = i % (1 << shift);
			List<Integer> seq = new ArrayList<>();
			if(dpMap.containsKey(prevKey))
				seq = dpMap.get(prevKey);
//			List<Integer> seq = dpMap[prevKey] == null ? new ArrayList<>() : dpMap[prevKey];
			if(seq.size() > 0) {
				int curr = nums[shift];
				int prev = seq.get(seq.size() - 1);
				int prevprev = seq.get(seq.size() - 2);
				if(prev - prevprev == curr - prev) {
					count++;
					seq.add(nums[shift]);
				}
//				dpMap[i] = seq;
				dpMap.put(i, seq);
			}else {
				for(int k = 0; k <= shift; k++) {
					if((i & (1 << k)) > 0)
						seq.add(nums[k]);
				}
				if(isArithmetic(seq)) {
					count++;
//					dpMap[i] = seq;
					dpMap.put(i, seq);
				}
			}

				
		}
		
		return count;
	}
	
	public int numberOfArithmeticSlices2(int[] nums) {
		int length = nums.length;
		int comArrayLength = 1 << length;
		Arrays.sort(nums);
		Map<Integer, List<Integer>> dpMap = new HashMap<>();
		int count = 0;
		
		
		for(int i = 0; i < comArrayLength; i++) {
			List<Integer> seq = new ArrayList<>();
			int shift = (int) (Math.log(i)/Math.log(2));
			int prevKey = i % (1 << shift);
			int k = 0;
//			if(shift > 3)
//				k = shift;
			if(dpMap.containsKey(prevKey)) {
				seq = dpMap.get(prevKey);	
				seq.add(nums[shift]);
				if(isArithmetic(seq)) {
					count++;				
				}else {
					seq.remove(seq.size()-1);
				}
				dpMap.put(i, seq);	
			}else {
				for(; k <=shift; k++) {				
					
					if(((i & 1) << k) > 0)
						seq.add(nums[k]);
				}
				if(isArithmetic(seq)) {
					count++;
					dpMap.put(i, seq);
				}
			}
				
		}
		
		return count;
	}
	
	private boolean isArithmetic(List<Integer> array) {
		if(array.size() < 3)
			return false;
		for(int i = 1; i < array.size() - 1; i++) {
			int curr = array.get(i);
			int prev = array.get(i - 1);
			int next = array.get(i + 1);
			if(next - curr != curr - prev)
				return false;
		}
		return true;
	}
	
	  public int longestPalindrome(String word1, String word2) {
		  
		  
		  return 0;
	  }
	  
	  private String[] getPermutations(String word) {
		  int bitlength = (1 << word.length());
		  String[] result = new String[bitlength];
		  Arrays.fill(result, null);
		  char[] chars = word.toCharArray();
		  for (int i = 1; i < bitlength; i++) {
			  StringBuilder sb = new StringBuilder();
			  if(i > 2) {
				  int shift = (int)(Math.log(i)/Math.log(2));
				  int prevNum = i % 1 << shift;
				  String prevString = result[prevNum];
				  if(prevString != null) {
					  sb.append(prevString);
					  for(int k = shift; k <= i; k++) {
							if((i & (1 << k)) > 0){
								sb.append(chars[k-1]);
							}
						}
				  }else {
						for(int k = 1; k <= word.length(); k++) {
							if((i & (1 << k)) > 0){
								sb.append(chars[k-1]);
							}
						}					  
				  }
			  }
			result[i] = sb.toString();
		}
		  return result;
	  }
		  
		  
	  
}
