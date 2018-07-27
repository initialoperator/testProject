package com.chrystian.amn.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortTestRun {
    public static void main(String[] args) {

        int[] array = {6, 4, 7, 9, 9, 8, 8, 3, 3, 7};
        List<Integer> unorderList = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            unorderList.add(r.nextInt(200));
        }
        System.out.println("before sorting");
        array = unorderList.stream().mapToInt(e -> {
            System.out.println(e);
            return e;
        }).toArray();
        System.out.println("begin to sort");
        mergesort(array);
//        heapsort(array);
        for(int i: array){
            System.out.println(i);
        }
    }
    private static void heapsort(int[] array){
        int length = array.length;
        int count = length;
        while(count > 0){
            int indexMax = findMaxIndex(array, 0, count);
            int temp = array[count];
            array[count] = array[indexMax];
            array[indexMax] = temp;
            count--;
        }

//        return array;
    }
    private static int findMaxIndex(int[] array, int start, int end){
        if(end - start == 1)
            return start;
        else if(end == 2){
            return array[start] > array[end-1]? array[start]:array[end-1];
        }else{
            int middle = (end - start) / 2;
            int index1 = findMaxIndex(array,start,middle);
            int index2 = findMaxIndex(array,middle+1, end);
            return array[index1] > array[index2]?index1:index2;
        }
    }

    private static void mergesort(int[] array){
        int length = array.length;
        int start = 0;
        int end = length -1;

        mergesort(array, start, end);
    }
    private static void mergesort(int[] array, int start, int end){
        if(end-start == 1){
            if(array[start] > array[end]){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }else if(end-start > 1){
            int middle = (end + start)/2;
            mergesort(array, start, middle);
            mergesort(array, middle+1, end);
            int length = end -start +1;
            int[] partMerged = new int[length];
            int pos1 = start;
            int pos2 = middle+1;
            int posm = 0;
            while (pos1 <= middle || pos2 <= end){
                if(pos1 > middle){
                    partMerged[posm] = array[pos2];
                    pos2++;
                    posm++;
                }else if(pos2 > end){
                    partMerged[posm] = array[pos1];
                    pos1++;
                    posm++;
                }else{
                    int head1 = array[pos1];
                    int head2 = array[pos2];
                    if(head1 <= head2){
                        partMerged[posm] = array[pos1];
                        pos1++;
                        posm++;
                    }else{
                        partMerged[posm] = array[pos2];
                        pos2++;
                        posm++;
                    }
                }
            }
            //now a new order list is done, we can do replacement;
            for(int i = 0; i < length; i++){
                array[i+start] = partMerged[i];
            }
        }

    }
}
