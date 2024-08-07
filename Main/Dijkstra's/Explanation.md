Here's a detailed explanation of the Dijkstra's algorithm code in Java:

### Overview

Dijkstra's algorithm finds the shortest paths from a source vertex to all other vertices in a weighted graph with non-negative weights. This implementation uses a priority queue to efficiently get the vertex with the smallest tentative distance.

### Code Breakdown

1. **Imports and Graph Class**
   ```java
   import java.util.*;
   ```
   Imports Java utility classes for data structures like `LinkedList`, `PriorityQueue`, and `Arrays`.

2. **Graph Class**
   ```java
   class Graph {
       private int vertices;
       private LinkedList<Edge>[] adjacencyList;
   ```
   The `Graph` class represents the graph structure. It has:
   - `vertices`: the number of vertices in the graph.
   - `adjacencyList`: an array of linked lists where each list contains `Edge` objects representing the edges of the graph.

3. **Edge Class**
   ```java
   class Edge {
       int vertex;
       int weight;

       Edge(int vertex, int weight) {
           this.vertex = vertex;
           this.weight = weight;
       }
   }
   ```
   The `Edge` class represents an edge in the graph:
   - `vertex`: the destination vertex of the edge.
   - `weight`: the weight of the edge.

4. **Graph Constructor**
   ```java
   Graph(int vertices) {
       this.vertices = vertices;
       adjacencyList = new LinkedList[vertices];
       for (int i = 0; i < vertices; i++) {
           adjacencyList[i] = new LinkedList<>();
       }
   }
   ```
   Initializes the graph with a specified number of vertices. Each position in the `adjacencyList` array is initialized as an empty linked list to hold edges.

5. **Add Edge Method**
   ```java
   void addEdge(int source, int destination, int weight) {
       Edge edge = new Edge(destination, weight);
       adjacencyList[source].add(edge);

       edge = new Edge(source, weight); // For undirected graph
       adjacencyList[destination].add(edge);
   }
   ```
   Adds an edge between two vertices:
   - For an undirected graph, the edge is added in both directions.

6. **Dijkstra's Algorithm**
   ```java
   void dijkstra(int source) {
       int[] distances = new int[vertices];
       boolean[] visited = new boolean[vertices];
       PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(edge -> edge.weight));

       Arrays.fill(distances, Integer.MAX_VALUE);
       pq.add(new Edge(source, 0));
       distances[source] = 0;

       while (!pq.isEmpty()) {
           Edge edge = pq.poll();
           int vertex = edge.vertex;

           if (!visited[vertex]) {
               visited[vertex] = true;

               for (Edge neighbor : adjacencyList[vertex]) {
                   int newDist = distances[vertex] + neighbor.weight;
                   if (newDist < distances[neighbor.vertex]) {
                       distances[neighbor.vertex] = newDist;
                       pq.add(new Edge(neighbor.vertex, newDist));
                   }
               }
           }
       }

       printSolution(distances);
   }
   ```
   Implements Dijkstra's algorithm:
   - `distances`: Array holding the shortest distance from the source to each vertex. Initialized to `Integer.MAX_VALUE` (representing infinity).
   - `visited`: Array to keep track of visited vertices.
   - `PriorityQueue<Edge> pq`: A priority queue to efficiently get the vertex with the smallest distance.
   - Initialize the source vertex with a distance of 0 and add it to the priority queue.
   - While the priority queue is not empty, extract the vertex with the smallest distance.
   - For each unvisited neighbor, update the distance if a shorter path is found and add the neighbor to the priority queue.
   - Print the shortest distances once all vertices have been processed.

7. **Print Solution Method**
   ```java
   void printSolution(int[] distances) {
       System.out.println("Vertex \t Distance from Source");
       for (int i = 0; i < distances.length; i++) {
           System.out.println(i + " \t\t " + distances[i]);
       }
   }
   ```
   Prints the shortest distances from the source to all vertices.

8. **Main Method**
   ```java
   public static void main(String[] args) {
       Graph graph = new Graph(6);
       graph.addEdge(0, 1, 4);
       graph.addEdge(0, 2, 3);
       graph.addEdge(1, 2, 1);
       graph.addEdge(1, 3, 2);
       graph.addEdge(2, 3, 4);
       graph.addEdge(3, 4, 2);
       graph.addEdge(4, 5, 6);
       graph.dijkstra(0);
   }
   ```
   Creates a graph with 6 vertices, adds edges, and runs Dijkstra's algorithm from vertex 0 to find and print the shortest paths.

This implementation efficiently computes the shortest path from the source vertex to all other vertices using a priority queue, making it suitable for graphs with non-negative weights.