import java.util.*;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFordAlgorithm {
    private int V, E; 
    private Edge[] edges; 

    public BellmanFordAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
    }

    public void bellmanFord(int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i].source;
            int v = edges[i].destination;
            int weight = edges[i].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative-weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; 
        int E = 8; 
        BellmanFordAlgorithm graph = new BellmanFordAlgorithm(V, E);
        graph.edges[0] = new Edge(0, 1, -1);
        graph.edges[1] = new Edge(0, 2, 4);
        graph.edges[2] = new Edge(1, 2, 3);
        graph.edges[3] = new Edge(1, 3, 2);
        graph.edges[4] = new Edge(1, 4, 2);
        graph.edges[5] = new Edge(3, 2, 5);
        graph.edges[6] = new Edge(3, 1, 1);
        graph.edges[7] = new Edge(4, 3, -3);

        graph.bellmanFord(0);
    }
}
