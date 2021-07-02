package com.chrystian.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultTest {
	public static void main(String[] args) {

		int m = Math.floorMod(5, -4);
		// System.out.println(m);
		
		// int[] array = new int[]{7,-9,15,-2};
//		int pos = Arrays.binarySearch(array, -9);		
//		System.out.println("pos: " + pos);
//		Arrays.sort(array);
//		pos = Arrays.binarySearch(array, -9);		
//		System.out.println("pos: " + pos);
		

		ResultTest sol = new ResultTest();
		// int result = sol.findQueens(7);
		// System.out.println(result);

		// String roman = sol.intToRoman(49);
		// System.out.println(roman);

		StringBuilder sb = new StringBuilder("hello");
		sb.deleteCharAt(0);
		System.out.println(sb);
	}

	public String intToRoman(int num) {//doing hard code if else is faster than using the folowing logic
		char[] digits = new char[]{'M', 'D','C','L','X','V','I'};
		int[] numbers = new int[]{1000,500,100,50,10,5,1};
        int remainder = num;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits.length; i += 2){
            int index = i;
            int digitNum = remainder/numbers[i];
			// System.out.println("digitNum: " + digitNum);
            if(digitNum == 0)
                continue;
            else if(digitNum < 4){
                IntStream.range(0, digitNum).forEach(d -> sb.append(digits[index]));
            }else if(digitNum < 9){
                StringBuilder temp = new StringBuilder();
				temp.append(digits[index-1]);
				// System.out.println("temp: " + temp);
                int diff = Math.abs(digitNum - 5);
                IntStream.range(0, diff).forEach(d -> temp.append(digits[index]));
                if(digitNum < 5)
                    temp.reverse();
                sb.append(temp);
            }else{
                sb.append(digits[i]); sb.append(digits[i-2]);
            }
            remainder = remainder % numbers[i];
			// System.out.println("stringBuilder in the middle: " + sb);
        }
        return sb.toString();
    }

	private static int calculateBitNumber(int target) {
		int bitmax = 32 - Integer.numberOfLeadingZeros(target);
		int[] bits = new int[bitmax];
		for(int i = 0; i < bitmax; i++) {
			if((target | (1 << i)) == target)
				bits[i] = 1;
			else
				bits[i] = 0;
			System.out.println(bits[i]);
		}
		
		int oneCounts = bitmax;
		int zeroCounts = 0;
		boolean onOne = true;
		int twisted = 0;
		for(int i =  bitmax -1 ; i  >= 0; i--) {
			if(onOne) {
				if(bits[i] == 1) continue;
				zeroCounts += i+1;
				onOne = false;
				twisted++;
			}else {
				if(bits[i] == 0) continue;
				oneCounts += i+1;
				twisted++;
			}
		}
		
		return oneCounts+zeroCounts;
	}
	
	private int produceOnesOfNumber(int number) {
		return 1 << number - 1;
	}
	
	
    public int findQueens(int n){
    	int[][] board = new int[n][n];
    	int[] history = new int[n];
    	Arrays.fill(history, -1);
        int result = tryPlacing(board, n, n, history);
        Map<Integer, Integer> map = new HashMap<>();
        result = result / factorial(map, n);
    	return result;
    }

    
    private int tryPlacing(int[][] board, int n, int lefts, int[] history){
    	System.out.println("start try placing, left: " + lefts);
        if(lefts == 0)
            return 1;
    	if(history[lefts-1] >= 0)
    		return history[lefts-1];
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int k = 0; k < n; k++){
            	if(board[i][k] == 0){
            		placing(board, n, i, k, 1);
            		int result = tryPlacing(board, n, lefts-1, history);
            		sum = result + sum;
            		placing(board, n, i, k, -1);
            		
            	}
            }
        }
//        history[lefts-1] = sum;
        return sum;
    }
    
    private void placing(int[][] board, int n, int i, int k, int placeOrRegret) {
    	 System.out.println("start placing, i: " + i + " k: "+k + " isplacing: " + placeOrRegret);
             board[i][k] += 1 * placeOrRegret;
             
             
             for(int a = 0; a < n; a++){
             	if(a == i)
             		continue;
             	board[a][k]+= 1 * placeOrRegret;
             }
             for(int a = 0; a < n; a++){
             	if(a == k)
             		continue;
             	board[i][a]+= 1 * placeOrRegret;
             }
//             System.out.println("here");
             
             int ai = i;
             int ak = k;
             while(ai >= 0 && ak >= 0) {
            	 if(ai != i)
            		 board[ai][ak]+= 1 * placeOrRegret;
            	 ai--;
            	 ak--;
             }
//             System.out.println("here2");
             
             ai = i;
             ak = k;
             while(ai < n && ak < n) {
            	 if(ai != i)
            		 board[ai][ak]+= 1 * placeOrRegret;
            	 ai++;
            	 ak++;
            	 
             }
             
             ai = i;
             ak = k;
             while(ai >= 0 && ak < n) {
            	 if(ai != i)
            		 board[ai][ak]+= 1 * placeOrRegret;
            	 ai--;
            	 ak++;
            	 
             }
             
             ai = i;
             ak = k;
             while(ai < n && ak >= 0) {
            	 if(ai != i)
            		 board[ai][ak]+= 1 * placeOrRegret;
            	 ai++;
            	 ak--;
            	 
             }
             for(int[] row : board) {
            	 System.out.println(Arrays.toString(row));
             }
    }
    
    private int factorial(Map<Integer, Integer> dp, int number){
        if(number <= 0)
            return 1;
        if(number == 1)
            return 1;
        if(dp.containsKey(number))
            return dp.get(number);
        
        int result = number * factorial(dp, number-1);
        dp.put(number, result);
        return result;
    }
    
}
