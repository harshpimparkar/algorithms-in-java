package com.harsh.InsertionSort;
import java.util.Arrays;
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {53,34,76,44,98,19,54,22,70,11};
        System.out.println("Before Insertion sort: \n"+Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After Insertion sort: \n"+Arrays.toString(arr));
    }
    static void insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }
    static void swap(int[] arr,int j, int i){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
