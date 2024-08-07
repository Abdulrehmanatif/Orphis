package Main;
import java.util.Arrays;

public class BellmanFord {

    // Class to represent an edge in the graph
    static class Edge {
        int src, dest, weight;

        // Constructor to create a new edge
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Class to represent a graph
    static class Graph {
        int V, E; // V: number of vertices, E: number of edges
        Edge[] edges; // Array of edges

        // Constructor to create a graph with V vertices and E edges
        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
            for (int i = 0; i < E; ++i)
                edges[i] = new Edge(0, 0, 0); // Initialize all edges
        }

        // Method to add an edge to the graph
        void addEdge(int u, int v, int w, int count) {
            edges[count] = new Edge(u, v, w);
        }

        // The Bellman-Ford algorithm
        void bellmanFord(int src) {
            // Initialize distances from src to all other vertices as INFINITE
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0; // Distance to the source is 0

            // Relax all edges |V| - 1 times
            for (int i = 1; i < V; ++i) {
                for (int j = 0; j < E; ++j) {
                    int u = edges[j].src;
                    int v = edges[j].dest;
                    int weight = edges[j].weight;
                    // If the distance to u is not infinite and the distance to v through u is less than the current distance to v
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight; // Update distance to v
                    }
                }
            }

            // Check for negative-weight cycles
            for (int j = 0; j < E; ++j) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                // If there is a negative-weight cycle
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }

            // Print the distance array
            printSolution(dist);
        }

        // Method to print the solution
        void printSolution(int[] dist) {
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; ++i)
                System.out.println(i + "\t\t" + dist[i]);
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        int E = 8; // Number of edges in the graph

        Graph graph = new Graph(V, E); // Create a new graph

        // Add edges to the graph
        graph.addEdge(0, 1, -1, 0);
        graph.addEdge(0, 2, 4, 1);
        graph.addEdge(1, 2, 3, 2);
        graph.addEdge(1, 3, 2, 3);
        graph.addEdge(1, 4, 2, 4);
        graph.addEdge(3, 2, 5, 5);
        graph.addEdge(3, 1, 1, 6);
        graph.addEdge(4, 3, -3, 7);

        // Run the Bellman-Ford algorithm from the source vertex 0
        graph.bellmanFord(0);
    }
}
