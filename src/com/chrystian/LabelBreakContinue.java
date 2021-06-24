package com.chrystian;

public class LabelBreakContinue {

	public static void main(String[] args) {

			
			
		for(int i = 0; i < 20; i++) {
			label:System.out.println("enter i");
			
			labelIn:
			for(int k = 0; k < 20; k++) {
				System.out.println("inside k");
				if(i  == 10) {
					continue labelIn;
				}
				System.out.println("i:"+i + " k:"+k);
			}
			
		}
	}
}
