package com.chrystian.java8.pratice.streams;


import java.util.*;
import java.util.stream.Collectors;

public class NumberConversion {
    public static void main(String[] args) {
        int number = 0;        
        
        //普通数字
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 999999;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 9876543;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 98765432;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        //针对数位不足万的数字
        number = 9876;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 678;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 67;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 4;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        //针对数位中间有0的数字
        number = 900090;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//跨万位表示
        
        number = 9090909;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//多0跨万
        
        number = 90909090;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//以0结尾
        
        number = 9099;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//万位下0
        
        number = 990999;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//千位0
        		
        number = 9000;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//连续0
        
//        针对数字2的表示
        number = 2;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 22;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 222;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 202;
        System.out.println(number + "表示为" + converNumberToTextZh(number));
        
        number = 2222;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//2在千位上
        
        number = 22222;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//2在万位上 not resolved
        
        
        
        //针对1的表示
        number = 1;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//1在个位上

        number = 11;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//1在十位上
        
        number = 111;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//1在百位上

        number = 1111;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//1在千位上
        
        number = 111111;
        System.out.println(number + "表示为" + converNumberToTextZh(number));//1在十万位上
    }
    
    private static String converNumberToTextZh(int number) {
/*
 * 思路：一个长数字可以表示成 x千x百x十x + 单位（亿/万/（空）） 
 *分2步parse一个数字
 *首先把一个长数字分割成最多到千的数位，每个数位都表示出"x千x百x十x"的形式，
 *然后在数位后加上正确的单位
 * */
    	//
    	int wanUnit = 10000;
    	Queue<String> wanDigit = new LinkedList<>();
//    	List<String> units = List.of("", "万", "亿", "兆"); //original line, not compatible with Java 8
    	List<String> units = Arrays.asList("", "万", "亿", "兆");//compatible with Java 8

    	int currentRemainder = number;
    	boolean leadingZeroAllowed = false;//每一部分转化出来的文字是否可以以零开头，如一万零一百中的 "零一百", 初始化状态不允许
    	while (currentRemainder > wanUnit) {
    		int quote = currentRemainder/wanUnit;
    		String digit = converNumberToTextZhWithinWan(quote, leadingZeroAllowed);
    		wanDigit.add(digit);
    		currentRemainder = currentRemainder % 10000; 
    		leadingZeroAllowed = true;//只要之前有过非零的数位，之后的表达可以以"零"开头
    	}
    	String digitRemainder = converNumberToTextZhWithinWan(currentRemainder, leadingZeroAllowed);
		wanDigit.add(digitRemainder);
    	
    	int unitCount = wanDigit.size();
    	StringBuilder sb = new StringBuilder();
    	while(!wanDigit.isEmpty()) {
    		String digit = wanDigit.remove();
    		sb.append(digit);
    		if(!digit.equals("零"))
    			sb.append(units.get(unitCount-1));
    		unitCount--;
    			
    	}
    	
    	String result = sb.toString();
    	return result.isEmpty()? "零":result;//如果string builder是空的，说明上面的逻辑从未执行过，也就是测试的值为0
    }
    private static String converNumberToTextZhWithinWan(int number, boolean leadingZeroAllowed) {//万内数字转化（在面试过程写出来的是这里面的逻辑，后加corner case的修改）
       
        Map<Integer, String> unitsMap = new HashMap<>();

        unitsMap.put(1000, "千");
        unitsMap.put(100, "百");
        unitsMap.put(10, "十");
        unitsMap.put(1, "");
        
        
        
        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(1, "一");
        numberMap.put(2, "二");
        numberMap.put(3, "三");
        numberMap.put(4, "四");
        numberMap.put(5, "五");
        numberMap.put(6, "六");
        numberMap.put(7, "七");
        numberMap.put(8, "八");
        numberMap.put(9, "九");
        numberMap.put(0, "零");
        
        List<Integer> digits = new ArrayList<>();
        List<Integer> units = new ArrayList<>();
        int currentVal = number;
        List<Integer> keyList = unitsMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(Integer d: keyList) {
        	if(currentVal == 0)
        		break;
        	
            int quote = currentVal / d;
            int remainder = currentVal % d;
            digits.add(quote);
            units.add(d);
            currentVal = remainder;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean canPrintZero = leadingZeroAllowed;
        for(int i = 0; i < digits.size(); i++){
            int digit = digits.get(i);
            if(digit == 0){
                if(canPrintZero && i < digits.size() - 1 ) {
                	sb.append("零");
                canPrintZero = false;
                }
            }else if(digit == 1 && units.get(i) == 10) {
            	sb.append(unitsMap.get(units.get(i)));
                canPrintZero = true;
            }else if(digit == 2 && ( units.get(i) == 1000)) {
            	sb.append("两");
            	sb.append(unitsMap.get(units.get(i)));
                canPrintZero = true;
            }
            else{
            	sb.append(numberMap.get(Integer.valueOf(digit)));
                sb.append(unitsMap.get(units.get(i)));
                canPrintZero = true;
            }
        }
        
        return sb.toString();
    }
}





