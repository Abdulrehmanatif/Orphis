
import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Edge>[] adjacencyList;

    // Edge class to represent a connection between two vertices and its weight
    class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Constructor to initialize the graph with a given number of vertices
    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        adjacencyList[source].add(edge);

        // For undirected graph, add the edge in both directions
        edge = new Edge(source, weight);
        adjacencyList[destination].add(edge);
    }

    // Method to implement Dijkstra's algorithm
    void dijkstra(int source) {
        // Array to store the shortest distances from the source to each vertex
        int[] distances = new int[vertices];
        // Array to keep track of visited vertices
        boolean[] visited = new boolean[vertices];
        // Priority queue to select the vertex with the smallest distance
        PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(edge -> edge.weight));

        // Initialize all distances as infinity
        Arrays.fill(distances, Integer.MAX_VALUE);
        // Add the source vertex to the priority queue with a distance of 0
        pq.add(new Edge(source, 0));
        distances[source] = 0;

        // Process the priority queue until it is empty
        while (!pq.isEmpty()) {
            // Get the vertex with the smallest distance
            Edge edge = pq.poll();
            int vertex = edge.vertex;

            // If the vertex has not been visited, process its neighbors
            if (!visited[vertex]) {
                visited[vertex] = true;

                // Iterate through all adjacent vertices
                for (Edge neighbor : adjacencyList[vertex]) {
                    // Calculate the new distance
                    int newDist = distances[vertex] + neighbor.weight;
                    // If the new distance is shorter, update the distance and add to the queue
                    if (newDist < distances[neighbor.vertex]) {
                        distances[neighbor.vertex] = newDist;
                        pq.add(new Edge(neighbor.vertex, newDist));
                    }
                }
            }
        }

        // Print the final shortest distances
        printSolution(distances);
    }

    // Method to print the solution
    void printSolution(int[] distances) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        Graph graph = new Graph(6);
        // Add edges to the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        // Run Dijkstra's algorithm from the source vertex 0
        graph.dijkstra(0);
    }
}

