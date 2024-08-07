Here's an explanation for each part of the code:

### 1. **Class Definitions**

- **Edge Class**: This class represents an edge in the graph. Each edge has a source vertex (`src`), a destination vertex (`dest`), and a weight (`weight`).

```java
static class Edge {
    int src, dest, weight;

    // Constructor to create a new edge
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
```

- **Graph Class**: This class represents a graph using an array of edges. It includes methods to add edges and run the Bellman-Ford algorithm.

```java
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
}
```

### 2. **Bellman-Ford Algorithm**

The `bellmanFord` method implements the Bellman-Ford algorithm:

- **Initialization**: Set the distance to all vertices as infinite, except for the source vertex which is set to 0.

```java
void bellmanFord(int src) {
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0; // Distance to the source is 0
```

- **Relaxation**: Relax all edges `|V| - 1` times. This means updating the distance to each vertex by checking if a shorter path exists through another vertex.

```java
for (int i = 1; i < V; ++i) {
    for (int j = 0; j < E; ++j) {
        int u = edges[j].src;
        int v = edges[j].dest;
        int weight = edges[j].weight;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
            dist[v] = dist[u] + weight; // Update distance to v
        }
    }
}
```

- **Negative-Weight Cycle Check**: Check for negative-weight cycles by verifying if any distance can be further reduced. If it can, it indicates a negative-weight cycle.

```java
for (int j = 0; j < E; ++j) {
    int u = edges[j].src;
    int v = edges[j].dest;
    int weight = edges[j].weight;
    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
        System.out.println("Graph contains negative weight cycle");
        return;
    }
}
```

- **Print the Results**: Print the shortest distances from the source to all vertices.

```java
printSolution(dist);
```

### 3. **Helper Method**

- **printSolution**: This method prints the distances from the source to all vertices.

```java
void printSolution(int[] dist) {
    System.out.println("Vertex Distance from Source");
    for (int i = 0; i < V; ++i)
        System.out.println(i + "\t\t" + dist[i]);
}
```

### 4. **Main Method**

The `main` method sets up the graph, adds edges, and runs the Bellman-Ford algorithm from a given source vertex.

```java
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
```

This explanation breaks down each part of the code, explaining what each section does and how the Bellman-Ford algorithm is implemented and utilized.