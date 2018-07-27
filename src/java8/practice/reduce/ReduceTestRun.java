package java8.practice.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTestRun {

    public static void main(String[] args) {
        List<String> textes = Arrays.asList("public", "static", "StringJoiner", "Amazon", "Madamasca", "Son_Masayoshi", "zebra");
        String o = textes.stream().reduce("a", (a, b) -> {
            if(a.compareTo(b) > 0)
                return a;
            else
                return b;
        });

        System.out.println(o);
    }
}
