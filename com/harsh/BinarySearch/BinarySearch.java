package com.harsh.BinarySearch;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {

    // Binary search implementation using recursion
    public static int binarySearch(ArrayList<Integer> arr, int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // If the element is present at the middle itself
            if (arr.get(mid) == target)
                return mid;

            // If the element is smaller than the middle element, then it can only be present in the left subarray
            if (arr.get(mid) > target)
                return binarySearch(arr, left, mid - 1, target);

            // Else the element can only be present in the right subarray
            return binarySearch(arr, mid + 1, right, target);
        }

        // Element is not present in the array
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();

        int result = binarySearch(arr, 0, arr.size() - 1, target);
        if (result == -1)
            System.out.println("Element not present in the array");
        else
            System.out.println("Element found at index " + result);

        scanner.close();
    }
}

