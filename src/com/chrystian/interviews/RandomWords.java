package com.chrystian.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class RandomWords {

	public static void main(String[] args) {
		
		String input = "this is the land of free but I hope this will not come of the map since this land of hope go against the will";
		String input2 = "this is the land of free and the land of hope";
		String output = generateRandom(input2, 20, 2);
		System.out.println(output);
	}
	
	public static String generateRandom(String input, int n) {
		//create a dict
		Map<String, List<Integer>> dict = new HashMap<>();
		String[] words = input.split(" ");
		for(int i = 0; i < words.length; i++) {
			if(dict.containsKey(words[i])) {
				dict.get(words[i]).add(i);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				dict.put(words[i], list);
			}
		}
		System.out.println(dict);
		
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		int position = r.nextInt(words.length);
		for(int i = 0; i < n; i++) {
			String word = words[position];
			sb.append(word); sb.append(" ");
			List<Integer> occurs = dict.get(word);
			int index = occurs.get(r.nextInt(occurs.size()));
			index = (index+1)%words.length;
			position = index;
		}
		
		return sb.toString().trim();
		
	}
	
	public static String generateRandom(String input, int n, int keylength) {
		//create a dict
		Map<String, List<Integer>> dict = new HashMap<>();
		String[] words = input.split(" ");
		for(int i = 0; i < words.length; i++) {
			String key = constructKey(words, i, keylength);
			if(dict.containsKey(key)) {
				dict.get(key).add(i);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				dict.put(key, list);
			}
		}
		System.out.println(dict);
		
//		randomly pick (next) words based on the dict
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		int tempposition = r.nextInt(words.length);
		int position = (tempposition - keylength + 1 + words.length) % words.length;
		String word = constructKey(words, position, keylength);
		System.out.println(word);
		sb.append(word);sb.append(" ");
//		position = tempposition;
		for(int i = 1; i < n; i++) {
			List<Integer> occurs = dict.get(word);
			int index = occurs.get(r.nextInt(occurs.size()));
			index = (index+keylength)%words.length;
			sb.append(words[index]);sb.append(" ");
			position = index;
			position = (position - keylength + 1 + words.length) % words.length;
			word = constructKey(words, position, keylength);
			System.out.println(word);
		}
		
		return sb.toString().trim();
		
	}
	
	private static String constructKey(String[] words, int pos, int keylength) {
		StringBuilder sb = new StringBuilder();
		while(keylength > 0) {
			sb.append(words[pos]); sb.append(" ");
			pos = (pos + 1  + words.length) % words.length;
			keylength--;
		}
		return sb.toString().trim();
	}
}
