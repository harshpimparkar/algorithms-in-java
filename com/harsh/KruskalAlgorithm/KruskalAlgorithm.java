package com.harsh.KruskalAlgorithm;
import com.harsh.Edge;

import java.util.*;

class Edge1 implements Comparable<Edge> {
    int src, dest, weight;

    public Edge1(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Graph1 {
    int V;
    List<Edge1> edges1;

    public Graph1(int V) {
        this.V = V;
        this.edges1 = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges1.add(new Edge1(src, dest, weight));
    }

    public List<Edge1> kruskalMST() {
        List<Edge1> result = new ArrayList<>();
//        Collections.sort(edges1);

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (Edge1 edge : edges1) {
            int srcParent = find(parent, edge.src);
            int destParent = find(parent, edge.dest);

            if (srcParent != destParent) {
                result.add(edge);
                union(parent, srcParent, destParent);
            }
        }

        return result;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] == vertex)
            return vertex;
        return parent[vertex] = find(parent, parent[vertex]);
    }

    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int V = 5;
        Graph1 graph = new Graph1(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        List<Edge1> MST = graph.kruskalMST();
        System.out.println("Edges in the minimum spanning tree (Kruskal's Algorithm):");
        for (Edge1 edge : MST) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.weight);
        }
    }
}
