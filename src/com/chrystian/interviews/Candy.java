package com.chrystian.interviews;

public class Candy {
	public static void main(String[] args) {
		Candy c = new Candy();
		int[] ratings = {1,6, 10, 8, 7, 3,2};
		System.out.println(c.candy(ratings));

	}
	
	public int candy(int[] ratings) {
		if(ratings.length == 0)
			return 0;
		if(ratings.length == 1)
			return 1;
		int sum = 0;
		int[] candies = new int[ratings.length];
		
		setAndAdjust(ratings, candies, 0, 1);
		for(int i = 0; i < candies.length; i++) {
			System.out.println(candies[i]);
			sum += candies[i];
		}
		
		return sum;
	}
	
	public int setAndAdjust(int[] ratings, int[] candies, int position, int intended) {
		if(position == ratings.length - 1){
			int curr = ratings[position];
			int pre = ratings[position-1];
			if(curr < pre) {
				int value = 1;
				candies[position] = value;
				if(value < intended)
					return intended;
				else
					return value + 1;
			}else if(curr == pre) {
				int value = 1;
				candies[position] = value;
				return intended;
			}else {
				int value = intended+1;
				candies[position] = value;
				return intended;
			}
		}else if(position == 0) {
			candies[0] = setAndAdjust(ratings, candies, 1, 1);
			return -1;
		} else{
			int curr = ratings[position];
			int pre = ratings[position-1];
			if(curr < pre) {
				int value = setAndAdjust(ratings, candies, position+1, 1);
				candies[position] = value;
				if(value < intended)
					return intended;
				else
					return value + 1;
			}else if(curr == pre) {
				int value = setAndAdjust(ratings, candies, position+1, 1);
				candies[position] = value;
				return intended;
			}else {
				int value = setAndAdjust(ratings, candies, position+1, intended+1);
				candies[position] = value;
				if(intended < value)
					return intended;
				return value - 1;
			}
		}
		
	}
	
	
}
