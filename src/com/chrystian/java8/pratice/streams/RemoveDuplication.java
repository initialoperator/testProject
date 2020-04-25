package com.chrystian.java8.pratice.streams;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RemoveDuplication {
    public static void main(String[] args){
        String input = "I will see you tomorrow, will I not?";
//        String output = removeDuplication(input);
//        System.out.println(output);

        String keyword = "saw";
//        int occur = findOccurrences(input.toCharArray(), keyword);
//        System.out.println("occur: " + occur);

        //washer count
        int[] washers = {0, 3, 0};
//        int moves = move(washers);
//        System.out.println("total moves: "+ moves);

        int[] array = {-1, 2, 3, 0, 9, -4, 8};
        int[] result = findPairOfSumK(array, 17);
        System.out.println(result[0]+ " " + result[1]);
    }

    private static String removeDuplication(String input){
        Set<Character> uniques = new HashSet<>();

        char[] inputArray = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, inputArray.length).mapToObj(i -> inputArray[i]).filter(c -> {
            if(uniques.contains(c))
                return false;
            else{
                uniques.add(c);
                return true;
            }
        }).forEach(c -> sb.append(c));

        return sb.toString();
    }

    /*
    Given a matrix of characters and a word.
you have to count the number of occurrences of that word in that matrix. you can move to any of the eight valid directions from current position.
    * */
    private static int navigateMatrixAndCountOccurrences(char[][] matrix, String word){
        int result = 0;
        for(int i = 0; i < matrix.length; i++){
            char[] updown = new char[matrix[i].length];
            for(int k = 0; k < matrix[i].length; k++){
                updown[k] = matrix[i][k];
            }
            result += findOccurrences(updown, word);
        }

        for(int i = 0; i < matrix.length; i++){
            char[] downup = new char[matrix[i].length];
            for(int k = matrix.length; k > 0; k--){
                downup[k-1] = matrix[i][k-1];
            }
            result += findOccurrences(downup, word);
        }

        return result;
    }
    private static int findOccurrences(char[] array, String word){
        String charString = new String(array);
        int result = 0;
        while(charString.indexOf(word) > -1){
            result++;
            charString = charString.substring(charString.indexOf(word)+word.length(), charString.length());
        }
        return result;
    }

    /*
    你有n台超级洗衣机。最初，每台洗衣机都有一些衣服或是空的。

对于每一次移动，您可以选择任意m台（1≤m≤n）洗衣机，并将每台洗衣机的一件衣服同时传递给相邻的洗衣机

给定一个整数数组表示每个洗衣机中从左到右的衣服数量，您应该找到最小移动次数，使得所有洗衣机中具有相同数量的衣服。如果无法执行此操作，请返回-1。



n的范围是[1,10000]。
超级洗衣机的衣服数量范围是[0,1e5]。
    * */
    private static int move(int[] washers){
        int sum = IntStream.range(0, washers.length).map(i -> washers[i]).sum();
        if(sum%washers.length != 0)
            return -1;
        int avg = sum / washers.length;
        int count = 0;
        int lastCount = -1;
        int direction = 0;
        while (lastCount != count){
            lastCount = count;
            boolean hasMove = false;
            for(int i = 0; i < washers.length -1; i++){
                if(washers[i] > avg){
                    washers[i]--;
                    washers[i+1]++;
                    hasMove = true;
                }
            }
            if(hasMove)
                count++;

            hasMove = false;
            for(int i = washers.length -1; i > 0; i--){
                if(washers[i] > avg){
                    washers[i]--;
                    washers[i-1]++;
                    hasMove = true;
                }
            }
            if(hasMove)
                count++;

        }
        return count;
    }

    /*
    Given unsorted array and a number K. Find 2 numbers such that sum is K.
    * */
    private static int[] findPairOfSumK(int[] array, int k){
        int[] result = new int[2];
//        IntStream.of(array).reduce((i1, i2) -> {
//            System.out.println("i1: "+ i1 + ", i2: "+ i2);
//            if(i1 + i2 == k){
//                result[0] = i1;
//                result[1] = i2;
//            }
//            return 0;
//        });
        IntStream.range(0, array.length).forEach(i -> {
            IntStream.range(0, array.length).forEach(m -> {
                if(i != m){
                    if(array[i] + array[m] == k){
                        result[0] = array[i];
                        result[1] = array[m];
                    }
                }
            });
        });
        return result;
    }
}
