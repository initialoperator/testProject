package com.chrystian.amazon;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class TestOne {
//test id 23280666530042
	public static void main(String[] args) {
		String text = "Rose is a flower red rose are flower";
		List<String> excludes = new ArrayList<>();
		excludes.add("is");
		excludes.add("are");
		excludes.add("a");

		text = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favourite food.";
		excludes = new ArrayList<>();
		excludes.add("is");
		excludes.add("and");
		excludes.add("he");
		excludes.add("to");
		excludes.add("the");
		
		List<String> result = retrieveMostFrequentlyUsedWords(text, excludes);

		System.out.println(result);
	}
	
	static List<String> retrieveMostFrequentlyUsedWords(String helpText, 
            List<String> wordsToExclude){
		List<String> result = new ArrayList<>();
		String[] tokenArray = helpText.split("[\\p{Punct}\\s]+");
		
		Set<String> excludeSet = wordsToExclude.stream().map(String::toLowerCase).collect(Collectors.toSet());
		
		Map<String, Integer> wordCount = new HashMap();
		Arrays.stream(tokenArray).map(String::toLowerCase).filter(t -> !excludeSet.contains(t))
				.forEach(t -> {
					if(wordCount.containsKey(t)) {
						int count = wordCount.get(t);
						count++;
						wordCount.put(t, count);
					}else {
						wordCount.put(t, 1);
					}
				});
		
		String maxWord = wordCount.keySet().stream().max((t1, t2) -> wordCount.get(t1).compareTo(wordCount.get(t2))).orElse("");
		
		if(maxWord.equals("")) {
			return result;
		}
		int maxOccurrence = wordCount.get(maxWord);
		result = wordCount.keySet().stream().filter(t -> wordCount.get(t) == maxOccurrence).collect(Collectors.toList());
		
		
		return result;
}
	
    public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
    	List<String> result = new ArrayList<>();
//    	List<String> textLines = new ArrayList<>();
//    	List<String> numberLines = new ArrayList<>();
    	
    	Predicate<String> isNumberLine = line -> {
			String[] tokens = line.split("\\s");
			String pos1 = tokens[1];
			try {
				Integer.parseInt(pos1);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
    	};
    	List<String> textLines = logLines.stream().filter(isNumberLine.negate()).sorted(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] token1 = o1.split("\\s");
				String[] token2 = o2.split("\\s");
				String substring1 = o1.substring(token1[0].length());
				String substring2 = o2.substring(token2[0].length());
				int compare = substring1.compareTo(substring2);
				if(compare == 0)
					return token1[0].compareTo(token2[0]);
				return compare;
			}
    	}).collect(Collectors.toList());
    	
    	List<String> numberLines = logLines.stream().filter(isNumberLine).collect(Collectors.toList());
    	
    	result.addAll(textLines);
    	result.addAll(numberLines);
    	return result;
	}
}
