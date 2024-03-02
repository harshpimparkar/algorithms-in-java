package com.harsh.LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {12,22,33,53,24,75,66,99,54,67};
        int target = 67;
        int ans = linearSearch(arr,target);
        if(ans == -1 ){
            System.out.println("Target not found.");
        }else{
            System.out.println("Target found at index " + ans);
        }

    }

    //search method
    static int linearSearch(int [] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for(int index =0 ;index< arr.length;index++){
            //check for the element at every index
            int element = arr[index];
            if(element == target){
                return  index;
            }
        }
        return -1;
    }
}