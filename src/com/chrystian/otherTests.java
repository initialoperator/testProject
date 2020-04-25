package com.chrystian;

import javafx.util.Pair;

import java.util.Random;
import java.util.stream.IntStream;

public class otherTests {

    public static void main(String[] args){
        String S = "SMS messages are really short";
//        S = "How is this going to happenddddddd";
        int result = solution(S, 12);
        System.out.println(result);
    }
    static int find_min(int[] A) {
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }

    static int[] solution(int N){
        int[] result = new int[N];
        Random r = new Random();
        result[0] = r.nextInt();
        IntStream.range(1, N).forEach(i -> result[i] = randomPositiveInt());
        return result;
    }

    static int randomPositiveInt(){
        Random r = new Random();
        int random = r.nextInt();
        while (random == 0){
            random = r.nextInt();
        }
        return Math.abs(random);
    }



    static int solution(String S, int K) {
        String s = S.trim();
        if(s.length() <= K){
            return 1;
        }else{
            int spaceIndex = s.indexOf(" ");
            while(spaceIndex < s.length() && spaceIndex < K){
                int nextIndex = s.indexOf(" ", spaceIndex+1);
                if(nextIndex == -1 || nextIndex > K)
                    break;
                else if(nextIndex <= K){
                    spaceIndex = nextIndex;
                }
            }
            if(spaceIndex > K || spaceIndex < 0){
                return -1;
            }else {
                int nextResult;
                try{
                    nextResult = solution(s.substring(spaceIndex), K);
                }catch (StringIndexOutOfBoundsException e){
                    nextResult = 0;
                }
                if(nextResult == -1){
                    return -1;
                }else {
                    return 1 + nextResult;
                }
            }
        }
    }
}
