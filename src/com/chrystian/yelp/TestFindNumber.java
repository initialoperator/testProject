package com.chrystian.yelp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestFindNumber {
    public static void main(String[] args) {

        Map<String, List<String>> topics = new HashMap<>();
        topics.put("Price", Arrays.asList("cheap", "expensive", "price"));
        topics.put("Business specialties", Arrays.asList("gnome", "gnomes"));
        topics.put("Harry Shrub", Arrays.asList("harry shrub"));

        List<String> reviews = new ArrayList<>();
        reviews.add("Harry Shrub did a great job with my garden, but I expected more gnomes for the price.");
        reviews.add("I love my new gnomes, they are so cute! My dog loves them too! Thanks Harry!");
        reviews.add("Very expensive at fifty dollars per gnome. Next time I'll buy from Cheap Gnomes Warehouse.");

        Map<String, Integer> result = countTopicOccurences(topics,reviews);
        System.out.println(result);
    }

    private static String findNumber(List<Integer> arr, int k) {
        boolean exists = arr.stream().filter(i -> i.intValue() == k).count() > 0;
        if (exists)
            return "YES";
        else
            return "FALSE";
    }

    private static List<Integer> oddNumbers(int l, int r) {
        return IntStream.range(l, r + 1).filter(i -> {
            int abs = Math.abs(i);
            if (abs % 2 == 0)
                return false;
            else
                return true;
        }).mapToObj(Integer::new).collect(Collectors.toList());

    }

    public static Map<String, Integer> countTopicOccurences(
            Map<String, List<String>> topics,
            List<String> reviews
    ) {
        //Complete me

        List<Set<String>> reviewWords = new ArrayList<>();
        for(String review: reviews){
            String[] words = review.split(" ");
            Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());
            reviewWords.add(wordSet);
        }

        Map<String, Integer> result = new HashMap<>();
        topics.keySet().stream().forEach(k -> {
            List<String> keywords = topics.get(k);
            int count = 0;
            for(String keyword:keywords){
                if(reviewWords.contains(keyword))
                    count++;
            }
            if(count > 0){
                result.put(k, new Integer(count));
            }
        });

        //sorting the map based on the occurrence
        Map<String, Integer> sortedResult = result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

        return sortedResult;
    }
}
