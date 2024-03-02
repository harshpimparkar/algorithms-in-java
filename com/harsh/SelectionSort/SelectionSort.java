package com.harsh.SelectionSort;
import java.util.Arrays;
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10,33,41,92,81,17,56,58,49,98};
        System.out.println("Before Selection sort: \n"+Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After Selection sort: \n"+Arrays.toString(arr));
    }
    static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //find the maximum item from the remaining array
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static int getMaxIndex(int[] arr,int start, int end){
        int max = start;
        for(int i=start;i <= end;i++){
            if( arr[max] < arr[i]){
                max=i;
            }
        }
        return max;
    }

}
