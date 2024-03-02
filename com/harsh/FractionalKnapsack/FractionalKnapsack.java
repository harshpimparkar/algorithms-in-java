package com.harsh.FractionalKnapsack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class Item {
    int weight;
    int value;
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
public class FractionalKnapsack {
    public static double fractionalKnapsack(ArrayList<Item> items, int capacity) {
        // Sort items by value per unit weight in descending order
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double ratio1 = (double) item1.value / item1.weight;
                double ratio2 = (double) item2.value / item2.weight;
                return Double.compare(ratio2, ratio1);
            }
        });

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += fraction * item.value;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        System.out.println("Enter the values and weights of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            int value = scanner.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            items.add(new Item(weight, value));
        }
        System.out.print("Enter the capacity of knapsack: ");
        int capacity = scanner.nextInt();
        double maxValue = fractionalKnapsack(items, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
        scanner.close();
    }
}

