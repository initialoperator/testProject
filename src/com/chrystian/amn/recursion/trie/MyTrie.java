package com.chrystian.amn.recursion.trie;

import java.util.HashSet;
import java.util.Set;

public class MyTrie {
	TrieNode head;
    /** Initialize your data structure here. */
    public MyTrie() {
        head = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        MyTrie.insert(head, word.toCharArray(), word.length(),0);
    }
    
    private static void insert(TrieNode node, char[] word, int size, final int currPos) {
    	if(currPos == size)
    		return;
    	TrieNode next = node.nexts.stream().filter(n -> n.val.equals(word[currPos])).findFirst().orElse(null);
    	if(next == null) {
    		node.nexts.add(new TrieNode(word[currPos]));
    	}
    	next = node.nexts.stream().filter(n -> n.val.equals(word[currPos])).findFirst().orElse(null);
    	insert(next, word, size, currPos+1);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	
        return search(head, word.toCharArray(), word.length(), 0);
    }
    
    private static boolean search(TrieNode node, char[] word, int size, final int currPos) {
    	if(currPos == size)
    		return true;
    	if(node.nexts.contains(new TrieNode(word[currPos]))) {
    		TrieNode next = node.nexts.stream().filter(n -> n.val.equals(word[currPos])).findFirst().orElse(null);
    		return search(next, word, size, currPos+1);
    	}else
    		return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return false;
    }
    
    public static class TrieNode{
    	Character val;
    	Set<TrieNode> nexts;
    	
    	public TrieNode(char val) {
    		val = val;
    		nexts = new HashSet<TrieNode>();
    	}
     
    	
    	@Override
    	public int hashCode() {
    		return val.hashCode();
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if(o == this)
    			return true;
    		if(!(o instanceof TrieNode))
    			return false;
    		
    		try {
    			return this.val.equals(((TrieNode) o).val);
    		}catch (Exception e) {
    			return false;
    		}
    	}
    }
}
