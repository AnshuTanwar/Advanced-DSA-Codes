import java.util.*;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class PrimAlgorithm {
    private int V; 
    private List<List<Edge>> adj; 

    public PrimAlgorithm(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adj.get(source).add(new Edge(source, destination, weight));
        adj.get(destination).add(new Edge(destination, source, weight)); 
    }

    public void primMST() {
        boolean[] inMST = new boolean[V]; 
        int[] key = new int[V]; 

        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.key));

        pq.add(new Node(0, 0));
        key[0] = 0;

    
        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            inMST[u] = true;

            for (Edge edge : adj.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Node(v, key[v]));
                }
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < V; i++) {
            System.out.println("Edge: " + i + " - " + key[i]);
        }
    }

    
    class Node {
        int vertex, key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        int V = 5; 
        PrimAlgorithm graph = new PrimAlgorithm(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
