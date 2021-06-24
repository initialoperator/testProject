package com.chrystian.interviews;

public class Dungeon {

	public static void main(String[] args) {
//		int[][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
		int[][] dungeon = new int[][]{{1,2,1},{-2,-3,-3},{3,2,-2}};
		Dungeon d = new Dungeon();
		int minh = d.calculateMinimumHP(dungeon);
		System.out.println(minh);
	}

    public int calculateMinimumHP(int[][] dungeon) {
    	int[][] records = new int[dungeon.length][dungeon[0].length];
        
    	int result = determineHealth(dungeon, 0, 0, 1, records);
    	
//    	IntStream.range(0, records.length).forEach(a -> System.out.println(Arrays.toString(records[a])));
        return result;
    }
    
    public int determineHealth(int[][] dungeon, int i, int k, int intended, int[][] records) {
    	if(i >= dungeon.length
    			||  k >= dungeon[0].length)
    		return Integer.MAX_VALUE;
    	if(records[i][k] > 0 )
    		return records[i][k];
    	int value = dungeon[i][k];
    	if(i == dungeon.length - 1 && k == dungeon[0].length-1) {
    		return intended + value > 0 ? intended : (-1)*value+1;
    	}
    	int value1 = determineHealth(dungeon, i+1, k, 1, records);
    	int value2 = determineHealth(dungeon, i, k+1, 1, records);
    	int result = Math.min(value1, value2) - value;
    	records[i][k] = Math.max(result, intended);
    	return Math.max(result, intended);
    				
    }
    

}
