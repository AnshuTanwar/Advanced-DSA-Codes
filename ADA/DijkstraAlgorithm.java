import java.util.*;

class Graph {
    private int V; 
    private List<List<Edge>> adj; 

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Edge(dest, weight));
        adj.get(dest).add(new Edge(src, weight)); 
    }

    public void dijkstra(int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.distance));
        pq.add(new Node(source, 0));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            List<Edge> edges = adj.get(u);
            for (Edge edge : edges) {
                int v = edge.dest;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    class Node {
        int vertex, distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        graph.dijkstra(0);
    }
}
