package com.chrystian.interviews;

import java.util.stream.IntStream;

/*
 Easy mistakes:
 The way I calculate position makes it a speicial fcase when numRows == 1
 Again, I confused of s' length and numRows in the course of coding.
 Becaue StringBuilder is a reference type, you can't really do Arrays.fill(sbs, new StringBuilder)
 * 
 * */
public class ZigZagString {

	public static void main(String[] args) {
		ZigZagString sol = new ZigZagString();
		String result = sol.convert("PAYPALISHIRING", 3);
		System.out.println(result);//PAHNAPLSIIGYIR
	}
    public String convert(String s, int numRows) {        
    	if(numRows == 1)//the way I calculate position makes numRows 1 to be a special case
    		return s;
    	
        StringBuilder[] sbs = new StringBuilder[numRows];
        IntStream.range(0, numRows).forEach(i -> sbs[i] = new StringBuilder());       
        
        int length = s.length();
        boolean goDown = true;
        int position = 0;
        for(int i = 0; i < length; i++){
            sbs[position].append(s.charAt(i));
            if(position % numRows == 0)
                goDown = true;
            if(position % numRows == numRows - 1)
                goDown = false;
            
            if(goDown)
                position++;
            else
                position--;
            
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb: sbs){
            result.append(sb.toString());
        }
        return result.toString();
    }
}
