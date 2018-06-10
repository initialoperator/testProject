package com.chrystian.amn.sorting;

public class SortTestRun {
    public static void main(String[] args) {

        int[] array = {6, 4, 7, 9, 9, 8, 8, 3, 3, 7};
        mergesort(array);
        for(int i: array){
            System.out.println(i);
        }
    }
    private int[] heapsort(int[] array){
        int length = array.length;
        int count = length;
        while(count > 0){
            int indexMax = findMaxIndex(array, 0, count);
            int temp = array[count];
            array[count] = array[indexMax];
            array[indexMax] = temp;
            count--;
        }

        return array;
    }
    private int findMaxIndex(int[] array, int start, int end){
        if(end - start == 1)
            return start;
        else if(end == 2){
            return array[start] > array[end-1]? array[start]:array[end-1];
        }else{
            int middle = (end - start) / 2;
            int index1 = findMaxIndex(array,start,middle+1);
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
            while (pos1 <= middle || pos2 <= end){
                //incomplete
            }

        }

    }
}
