package com.chrystian.amn.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AnagramTest {

	public static void main(String[] args) {
		
	}
	
	public static int toMakeAnagram(String s1, String s2) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		
		char[] chars1 = s1.toCharArray();
		for(char c:chars1){
			if(map1.containsKey(c))
				map1.put(c, map1.get(c)+1);
			else
				map1.put(c, 1);
		}
		
		char[] chars2 = s2.toCharArray();
		for(char c:chars2){
			if(map2.containsKey(c))
				map2.put(c, map2.get(c)+1);
			else
				map2.put(c, 1);
		}
		
		map2.keySet().stream().forEach(k -> {
			int map1Has = map1.containsKey(k)? map1.get(k) : 0;
			map1.put(k, Math.abs(map1Has - map2.get(k)));
		});
		int sum = map1.entrySet().stream().map(Map.Entry<Character, Integer>::getValue).reduce(0, (a,b)->a+b);
		return sum;
	}
}
