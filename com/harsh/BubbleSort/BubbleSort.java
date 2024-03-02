package com.harsh.BubbleSort;//import java.lang.reflect.Array;
import java.util.Arrays;
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {56,33,45,76,82,32,39,11,23,66};
        System.out.println("Before Bubble sort: \n"+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Bubble sort: \n"+Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr){
        boolean swapped;
        //run the passes n-1 times
        for(int i=0;i< arr.length;i++){
            swapped = false;
            //for each pass the largest element will come at the end
            for(int j=1; j< arr.length-i;j++){
                //swap if the j is smaller than i
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            swapped=true;
        }
    }
}
