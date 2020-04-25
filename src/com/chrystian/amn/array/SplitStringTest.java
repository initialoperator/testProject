package com.chrystian.amn.array;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class SplitStringTest {

    public static void main(String[] args){
        Set<String> dict = new HashSet<>();
        dict.add("shopping");
        dict.add("with");
        dict.add("flipkart");
        dict.add("is");
        dict.add("easy");

        String input = "shoppingwithflipkartiseasy";

        int beginningIndex = input.indexOf("shopping");
//        String substring = input.substring(100, input.length());
//        System.out.println(substring);
//        String result = split(input, dict);
//        System.out.println(result);

        String binary = "1010";
//        System.out.println(binaryToDecimal(binary));

        int[] movies = {90, 85, 75, 60, 120, 150, 125};
        int duration = 250;
        int[] result = findMovies(movies, duration);
        System.out.println(result[0] + " " + result[1]);
    }

    /*
    Given a string example : shoppingwithflipkartiseasy,
    Now we are given this string and a dictionary containing valid words ,
    now we need to break the sentence into words separated by space. Output : shopping with flipkart is easy
    * */
    private static String split(String input, Set<String> dict){
        Map<Integer, String> lookup = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        dict.stream().forEach(word -> {
            int beginningIndex = 0;
            String substring = input;
            while(substring.length() > 0){
                beginningIndex = substring.indexOf(word);
                if(beginningIndex < 0)
                    break;
                lookup.put(beginningIndex, word);
                substring = input.substring(beginningIndex+word.length(), input.length());
            }

        });
        lookup.keySet().stream().sorted().forEach(index -> {
            sb.append(lookup.get(index)+" ");
        });
        return sb.toString();
    }

    /*
    You are given a string of 0’s and 1’s you have to find the number of substrings in the string which starts and end with a 1.
eg : input : 0010110010 output : 6
    * */
    private static int binaryToDecimal(String bi){
        char[] digits = bi.toCharArray();
        return IntStream.range(0, digits.length).mapToDouble(i -> Math.pow(2, i) * ((digits[bi.length() - i - 1] == '1' ? 1 : 0))).mapToInt(d -> (int)d).sum();

    }

    /*
    You are on a flight and wanna watch two movies during this flight.
You are given int[] movie_duration which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

e.g.
Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output from aonecode.com
[90, 125]
90min + 125min = 215 is the maximum number within 220 (250min - 30min)
    * */
    private static int[] findMovies(int[] all, int duration){
        int[] result = new int[2];
        int limit = duration - 30;
        int[] max = {0};
        IntStream.range(0, all.length-1).forEach(i -> {
            IntStream.range(i+1, all.length).forEach(k ->{
                int sum = all[i] + all[k];
                if(sum < limit && sum > max[0]){
                    max[0] = sum;
                    result[0]= all[i];
                    result[1]= all[k];
                }
            });
        });
        return result;
    }
}
