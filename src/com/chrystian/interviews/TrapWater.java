package com.chrystian.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TrapWater {
    public static void main(String[] args) {
        TrapWater sol = new TrapWater();
        int[] height = {4,2,0,3,2,5};        
        int volume = sol.trap(height);
        System.out.println("Volume: " + volume);

        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        volume = sol.trap(height);
        System.out.println("Volume: " + volume);
    }

//https://leetcode.com/problems/trapping-rain-water/
//also see TrappingRainTest.java from this project. That solution is correct but run overtime O(n^2)
public int trap(int[] height) {
    int finalVolume = 0;
    List<Integer> cortices = findCortices(height);
    while(cortices.size() > 1){
        int volume = finalVolume;
        for(int i = 0; i < cortices.size() - 1; i++){
            int curr = cortices.get(i);
            int next = cortices.get(i+1);
            int limit = Math.min(height[curr], height[next]);
            for(int k = curr+1; k < next; k++){
                if(height[k] >= limit)
                    continue;
                volume += limit - height[k];
                height[k] = limit;
            }
        }
        if(volume == finalVolume)
            break;
        else{
            finalVolume = volume;
            cortices = findCortices(height);
        }
            
    }
    return finalVolume;
}

public List<Integer> findCortices(int[] height){
    List<Integer> cortices = new ArrayList<>();
    if(height.length <= 1)
        return cortices;
    IntStream.range(0, height.length).forEach(i->{
        if(i == 0){
            if(height[i] > height[i+1]){
                cortices.add(i);
            }
        } else if(i == height.length - 1){
            if(height[i] > height[i-1]){
            cortices.add(i);
            }
        }else if(height[i] >= height[i-1] && height[i] > height[i+1]
        ||height[i] > height[i-1] && height[i] >= height[i+1]){
            cortices.add(i);

        }
        
    });
    System.out.println(cortices);
    return cortices;
}


public int trap2(int[] height) {//clean great solution!
    if(height.length==0){
        return 0;
    }
    int left[] = new int[height.length];
    int right[] = new int[height.length];
    left[0] = height[0];
    right[height.length-1] = height[height.length-1];
    for(int i=1;i<height.length;i++){
        left[i] = Math.max(left[i-1],height[i]);
    }
    for(int i=height.length-2;i>=0;i--){
        right[i] = Math.max(right[i+1],height[i]);
    }
    int ans = 0;
    for(int i=0;i<height.length;i++){
        ans+=(Math.min(left[i],right[i]))-height[i];
    }
    return ans;
}







}
