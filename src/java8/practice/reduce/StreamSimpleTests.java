package java8.practice.reduce;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSimpleTests {

    public static void main(String[] args){
//        String s = "program-to-iterate-over-a-stream-wi";
//        char[] ca = s.toCharArray();
//        List<String> input = IntStream.range(0, ca.length).mapToObj(i -> ca[i]).map(c -> Character.toString(c)).collect(Collectors.toList());
//        System.out.println(streamIndex(input));

        String[] inputString = {"you", "are", "pretty", "pretty", "pretty", "I", "you", "you", "are", "pretty", "pretty", "pretty", "I", "you", "you", "are", "pretty", "pretty", "pretty", "I", "you", "you", "are", "pretty", "pretty", "pretty", "I", "you"};
        List<String> input = new ArrayList<>(Arrays.asList(inputString));
//        String result = findMostOccurenceWord(input);
//        System.out.println(result);

        List<String> result = findTop10Words(input);
        result.stream().forEach(System.out::println);

    }

    /*
    In a file there are 1 million words . Find 10 most frequent words in that file.
    * */
    private static List<String> findTop10Words(List<String> words){
        Map<String, Integer> count = new HashMap<>();
        words.stream().forEach(word -> {
            if(count.get(word) == null){
                count.put(word, 1);
            }else{
                Integer i = count.get(word);
                i++;
                count.put(word, i);
            }
        });
        List<String> output =  count.entrySet().stream().sorted((e1, e2) -> {
            if(e1.getValue() > e2.getValue())
                return -1;
            if(e1.getValue() < e2.getValue())
                return 1;
            return 0;
        }).map(e -> e.getKey()).collect(Collectors.toList());
//        List<String> result = IntStream.range(0, 10).mapToObj(resultTemp::get).map(e -> e.getValue()).collect(Collectors.toList());
        return output;
    }

    static class MyEntry<K, V> implements Map.Entry<K, V>{
        private K key;
        private V value;

        public void setKey(K key){
            this.key = key;
        }
        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
    private static String findMostOccurenceWord(List<String> words){
        Map<String, Integer> count = new HashMap<>();
        words.stream().forEach(word -> {
            if(count.get(word) == null){
                count.put(word, 1);
            }else{
                Integer i = count.get(word);
                i++;
                count.put(word, i);
            }
        });
        Integer maxOccur = count.entrySet().stream().map(e -> e.getValue()).sorted(Comparator.reverseOrder()).findFirst().get();
        String max = count.entrySet().stream().filter(e -> e.getValue() == maxOccur).map(e -> e.getKey()).collect(Collectors.toList()).get(0);
        return max;
    }

    private static String streamIndex(List<String> input){
        int size = input.size();
        StringBuilder outputBuilder = new StringBuilder("[");
        IntStream.range(0, size).forEach(i -> {
            String output = i+"->"+input.get(i)+",";
            outputBuilder.append(output);
        });
        int replacement = outputBuilder.lastIndexOf(",");
        outputBuilder.replace(replacement, replacement, "]");
        return outputBuilder.toString();
    }
}
