package com.chrystian;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class PrintTest {
    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        // Write your code here
return 0L;
    }

    private static final class PairIntCollector{
        private int first, second;
        public int difference(){
            return Math.abs(first - second);
        }

    }
    private static final class MappingErrors {

        private Map<String, String> map = new HashMap<>();

        private String first, second;

        public void accept(String str) {
            first = second;
            second = str;
            if (first != null && first.startsWith("err")) {
                map.put(first, second);
            }
        }

        public MappingErrors combine(MappingErrors other) {
            throw new UnsupportedOperationException("Parallel Stream not supported");
        }

        public Map<String, String> finish() {
            return map;
        }

        public static Collector<String, ?, Map<String, String>> collector() {
            return Collector.of(MappingErrors::new, MappingErrors::accept, MappingErrors::combine, MappingErrors::finish);
        }

    }
}


