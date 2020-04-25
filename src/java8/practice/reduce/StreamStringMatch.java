package java8.practice.reduce;

import java.util.*;
import java.util.stream.IntStream;

public class StreamStringMatch {

    public static List<List<Integer>> getEmailThreads(List<String> emails) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        // Write your code here
        emails.stream().map(email -> email.split(",")).filter(emailFormat -> {
            String body = emailFormat[2];
            if(body.contains("---"))
                return true;
            else{
                List<Integer> count = new ArrayList<>();
                count.add(1);
                map.put(body.trim(), count);
                return false;
            }
        }).forEach(emailFormat -> {
            String body = emailFormat[2];
            String[] bodyParsed = body.split("---");
            String key = bodyParsed[bodyParsed.length-1].trim();
            map.get(key).add(bodyParsed.length -1);//this line may need revising
        });
        map.entrySet().stream().forEach(k -> {
            result.add(map.get(k.getKey()));
        });
        IntStream.range(1, result.size()+1).forEach(i -> {
            List<Integer> thread = result.get(i-1);
//            System.out.print(i);
            thread.stream().forEach(email -> System.out.print(" "+ email));
            System.out.println();
        });
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abc@gmail.com, x@gmail.com, hello x, how are you?";
        String s2 = "c@gmail.com, abc@gmail.com, did you take a look at the event?";
        String s3 = "x@gmail.com, abc@gmail.com, i am great. how are you?---hello x, how are you?";
        List<String> emails = Arrays.asList(s1, s2, s3);
        getEmailThreads(emails);
    }
}
