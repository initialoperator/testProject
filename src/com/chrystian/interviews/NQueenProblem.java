package com.chrystian.interviews;

import java.util.ArrayList;
import java.util.List;

/* Java program to solve N Queen Problem using
	backtracking */
	public class NQueenProblem {
		public List<List<String>> solveNQueens(int n) {
			List<List<String>> ans=new ArrayList<>();
			nQueens(n,0,new int[n][n],ans);
			return ans;
		}

		public void nQueens(int n,int row,int [][] asf,List<List<String>> ans){
			if(n==0){
				List<String> hi=new ArrayList<>();
				for(int i=0;i<asf.length;i++){
					StringBuilder sans=new StringBuilder();
					for(int j=0;j<asf[0].length;j++){
						if(asf[i][j]==0){
							sans.append(".");
						}else{
							sans.append("Q");
						}
					}
					System.out.println(sans);
					hi.add(sans.toString());
				}
				ans.add(hi);

				return;
			}
			if(row>=asf.length){
				return;
			}
			for(int col=0;col<asf.length;col++){
				if(isQueenSafe(asf,row,col)){
					asf[row][col]=1;
					nQueens(n-1,row+1,asf,ans);
					asf[row][col]=0;
				}
			}
		}

		public boolean isQueenSafe(int [][] arr,int row,int col){
			int [][] option={{-1,-1},{-1,0},{-1,+1},{0,+1},{+1,+1},{+1,0},{+1,-1},{0,-1}};
			for(int rad=1;rad<=arr.length;rad++){
				// for every radius it has 8 options    
				for(int i=0;i<option.length;i++){
					int nr=row+rad*option[i][0];
					int nc=col+rad*option[i][1];
					if(nr>=0 && nr<arr.length && nc>=0 && nc<arr.length){
						if(arr[nr][nc]==1){
							return false;
						}
					}
				}
			}
			return true;
		}


		// driver program to test above function
		public static void main(String args[])
		{
			NQueenProblem Queen = new NQueenProblem();
			int result = Queen.solveNQueens(8).size();
			System.out.println(result);
		}
	}
	// This code is contributed by Abhishek Shankhadhar


