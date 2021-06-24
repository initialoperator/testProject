package com.chrystian.amazon;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestTwo {
    public static void main(String[] args){
        List<Integer> h = Arrays.asList(1,2,3);
        List<Integer> v = Arrays.asList(1,2);

        long result = storage(3, 2, h, v);
        System.out.println(result);
    }
    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {
        List<List<Integer>> items = new ArrayList<>();
        items.add(priceOfJeans.stream().filter(i -> i < dollars).collect(Collectors.toList()));
        items.add(priceOfShoes.stream().filter(i -> i < dollars).collect(Collectors.toList()));
        items.add(priceOfSkirts.stream().filter(i -> i < dollars).collect(Collectors.toList()));
        items.add(priceOfTops.stream().filter(i -> i < dollars).collect(Collectors.toList()));

        Map<Integer, Integer> result = new HashMap<>();
        for(List<Integer> item: items){
            result = findOptions2(item, result, dollars);
        }

        long sum = result.entrySet().stream().map(entry -> entry.getValue()).map(Long::valueOf).reduce(0L, Long::sum);
        return sum;
    }

    public static Map<Integer,Integer> findOptions2(List<Integer> items, Map<Integer, Integer> prevReduce, int remains){
        Map<Integer, Integer> result = new HashMap<>();
        if(prevReduce.isEmpty()){
            items.stream().filter(i -> i <= remains).forEach(i -> result.put(i, 1));
            return result;
        }else {
            items.stream().forEach(i -> {
                prevReduce.entrySet().stream().forEach(entry -> {
                    int accum = entry.getKey() + i;
                    if (accum <= remains){
                        if(result.get(accum) == null)
                            result.put(accum, entry.getValue());
                        else
                            result.put(accum, result.get(accum)+entry.getValue());
                    }

                });

            });
            return result;
        }

    }

    public static long findOptions(List<List<Integer>> items, int remains, int position){
        if(remains < 0)
            return 0;
        if(position >= items.size())
            return 1;
        else{
            List<Integer> itemPrices = items.get(position);
            final int newPos = position+1;
//            Long result = itemPrices.stream().parallel().map(i -> {
//                return findOptions(items, remains-i, newPos);
//            }).reduce(0L, Long::sum);

            Long sum = 0L;
            for(Integer ip:itemPrices){
                sum += findOptions(items, remains-ip, position+1);
            }
            return sum;
        }
    }

/*
The approach is to accumulate the sum of all possible combination from the list of 4 lists recursively, until the budget reach below 0, which will return 0 for this combination, or the lists has been navigated to the end, which will return 1 for this combination.

For now, the runtime compexity is O(nmop), where n, m, o, p are the length of the 4 lists. The current algorithm still needs to improved on efficiency to have the rest 3 test cases finished running.
* */



    public static long storage(int n, int m, List<Integer> h, List<Integer>v){
        Set<Integer> hset = new HashSet<>();
        Set<Integer> vset = new HashSet<>();
        h.stream().forEach(hset::add);
        v.stream().forEach(vset::add);

        List<Integer> nList = IntStream.range(0, n+2).filter(i -> !hset.contains(i)).boxed().collect(Collectors.toList());
        int hBiggest = IntStream.range(0, nList.size()).map(i -> {
            if (i+1 < nList.size())
                return nList.get(i+1) - nList.get(i);
            else return 0;
        }).max().getAsInt();

        List<Integer> mList = IntStream.range(0, m+2).filter(i -> !vset.contains(i)).boxed().collect(Collectors.toList());
        int vBiggest = IntStream.range(0, mList.size()).map(i -> {
            if (i+1 < mList.size())
                return mList.get(i+1) - mList.get(i);
            else return 0;
        }).max().getAsInt();

        return Long.valueOf(hBiggest) * Long.valueOf(vBiggest);
    }

    public static int findPair(int[] A){
        List<Integer> positives = Arrays.stream(A).filter(i -> i > 0).boxed().collect(Collectors.toList());
        Set<Integer> negatives = Arrays.stream(A).filter(i -> i < 0).boxed().collect(Collectors.toSet());

        int max = 0;
        for(Integer p : positives){
            if (p > max && negatives.contains((-1 * p)))
                max = p;
        }


        ZonedDateTime time =  ZonedDateTime.now();

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return max;

    }
}



/*
*

*
* */