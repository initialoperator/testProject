package java8.practice.methodReference;


import java.util.HashMap;
import java.util.Map;

public class NumberConvert {
    private static Map<String, String> numCharMap = new HashMap<String, String>();
    public static void main(String[] args) {
        numCharMap.put("0", "-");
        numCharMap.put("1", "*");
        numCharMap.put("2", "abc");
        numCharMap.put("3", "def");
        numCharMap.put("4", "ghi");
        numCharMap.put("5", "jkl");
        numCharMap.put("6", "mno");
        numCharMap.put("7", "pqrs");
        numCharMap.put("8", "tuv");
        numCharMap.put("9", "wxyz");

        String[] tokens = convert("6473335566");
        for(String token:tokens){
            System.out.println(token);
        }
        System.out.println("total number: "+ tokens.length);
    }
    public static String[] convert(String num){
        String possibilities =  covert("", num);
        String[] possArray = possibilities.split(",");
        return possArray;
    }

    private static String covert (String base, String residual){
        if(residual.length()==0){
            return base;
        }else{
            String firstChar = residual.substring(0, 1);
            String mapResult = numCharMap.get(firstChar);//eg "ABC"
            String possibilities = "";
            for(int i = 0; i < mapResult.length(); i++){
                String newChar = ""+mapResult.charAt(i);
                possibilities = covert(base+newChar, residual.substring(1)) +","+possibilities;
            }
            return possibilities;
        }

    }
}
