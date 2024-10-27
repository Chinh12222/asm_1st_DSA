import java.util.*;

class DijkstraAlgorithm {
    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Node>> graph, int source) {
        int V = graph.size();
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int u = currentNode.vertex;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If a shorter path to v is found
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    minHeap.add(new Node(v, distances[v]));
                }
            }
        }

        // Print shortest path from source to each vertex
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from source " + source + " to vertex " + i + " is " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph
        graph.get(0).add(new Node(1, 10));
        graph.get(0).add(new Node(2, 3));
        graph.get(1).add(new Node(2, 1));
        graph.get(1).add(new Node(3, 2));
        graph.get(2).add(new Node(1, 4));
        graph.get(2).add(new Node(3, 8));
        graph.get(2).add(new Node(4, 2));
        graph.get(3).add(new Node(4, 7));
        graph.get(4).add(new Node(3, 9));

        dijkstra(graph, 0); // Source node is 0
    }
}
