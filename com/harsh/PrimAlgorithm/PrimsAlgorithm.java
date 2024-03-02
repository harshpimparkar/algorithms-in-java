package com.harsh.PrimAlgorithm;
import java.util.*;

class Graph {
    private int V;
    private List<List<Edge>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int w) {
        adj.get(u).add(new Edge(v, w));
        adj.get(v).add(new Edge(u, w));
    }

    public List<Edge> primMST() {
        boolean[] inMST = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int src = 0; // We start from vertex 0

        List<Edge> MST = new ArrayList<>();
        pq.addAll(adj.get(src)); // Add all edges from src to priority queue
        inMST[src] = true; // Mark src as visited

        while (!pq.isEmpty()) {
            Edge e = pq.poll(); // Remove the minimum weight edge from priority queue
            int u = e.to;

            if (inMST[u]) // If this vertex is already in MST, skip
                continue;

            inMST[u] = true; // Mark vertex u as visited

            for (Edge next : adj.get(u)) {
                if (!inMST[next.to])
                    pq.add(next);
            }

            MST.add(e);
        }
        return MST;
    }
}

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class PrimsAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }

        List<Edge> MST = graph.primMST();
        System.out.println("Edges in the minimum spanning tree:");
        for (Edge edge : MST) {
            System.out.println(edge.to + " - " + edge.weight);
        }

        scanner.close();
    }
}
