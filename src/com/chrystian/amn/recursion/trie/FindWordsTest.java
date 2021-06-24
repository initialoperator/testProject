package com.chrystian.amn.recursion.trie;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-search-ii/

public class FindWordsTest {
	  public List<String> findWords(char[][] board, String[] words) {
		  List<String> result = new ArrayList<>();
	      MyTrie dict = getDictionary(words);
	      for(int i = 0; i < board.length; i++) {
	    	  for(int k = 0; k < board[i].length; i++) {
	    		  List<Coordinate> visited = new ArrayList<>();
	    		  if (contains(dict, board, i, k, visited)) {
	    			  //processing the word character by character
	    		  }
	    	  }
	      }
	    	  
		  return null;
	    }
	  
	  public static boolean contains(MyTrie dict, char[][] board, int row, int column, List<Coordinate> visited) {
		  return false;//hardcoded
	  }
	  
	  public static MyTrie getDictionary(String[] words) {
		  MyTrie trie = new MyTrie();
		  for(String word: words) {
			  trie.insert(word);
		  }
		  return trie;
	  }
	  private static class Coordinate{
		  int row;
		  int column;
		  
		  Coordinate(int row, int column){
			  row = row;
			  column = column;
		  }
	  }
}
