package java8.practice.reduce;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceTestRun {

    public static void main(String[] args) {
        List<String> textes = Arrays.asList("public", "static", "StringJoiner", "Amazon", "Madamasca", "Son_Masayoshi", "zebra");
        String o = textes.stream().reduce("a", (a, b) -> {
            if(a.compareTo(b) > 0)
                return a;
            else
                return b;
        });

//        System.out.println(o);

        int n = 7;
        int m = 5;
        List<Integer> h = Arrays.asList(2, 3);
        List<Integer> v = Arrays.asList(3);
        System.out.println(prison(n, m, h, v));
    }

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        // Write your code here
        List<Integer> horizontalSpace = new ArrayList<>();
        List<Integer> horizontalAfterRemoved = IntStream.range(0, n+1).filter(i -> !h.contains(i)).sorted().boxed().collect(Collectors.toList());
        List<Integer> verticalAfterRemoved = IntStream.range(0, m+1).filter(i -> !v.contains(i)).sorted().boxed().collect(Collectors.toList());

        Stream<Integer> tempStream = horizontalAfterRemoved.stream();

        List<Integer> hwList = IntStream.range(0, horizontalAfterRemoved.size()).map(i -> {
            if(i >= horizontalAfterRemoved.size()-1){
                return 0;
            }else{
                Integer curr = horizontalAfterRemoved.get(i);
                Integer next = horizontalAfterRemoved.get(i+1);
                return Math.abs(curr - next);
            }
        }).boxed().collect(Collectors.toList());
        List<Integer> vwList = IntStream.range(0, verticalAfterRemoved.size()).map(i -> {
            if(i >= verticalAfterRemoved.size()-1){
                return 0;
            }else {
                Integer curr = verticalAfterRemoved.get(i);
                Integer next = verticalAfterRemoved.get(i+1);
                return Math.abs(curr - next);
            }
        }).boxed().collect(Collectors.toList());
        long result = hwList.stream().mapToInt(Integer::intValue).map(hw -> {
            return vwList.stream().mapToInt(Integer::intValue).map(vw -> hw * vw).max().getAsInt();
        }).max().getAsInt();
        return result;
    }
}
