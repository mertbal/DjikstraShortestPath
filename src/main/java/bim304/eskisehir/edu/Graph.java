package bim304.eskisehir.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Vertex, ArrayList<Edge>> vertices;

    public Graph(int numberOfVertices) {
        if (numberOfVertices < 0) {
            throw new IllegalArgumentException("A vertex cannot be less than zero");
        }
        this.vertices = new HashMap<>();
    }

    public void addEdge (Vertex v1, Vertex v2, int distance) {

        if (v1 == null || v2 == null) {
            throw new NullPointerException("Null vertices detected!");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("The distance cannot be negative!");
        }

        Edge edge = new Edge(v1, v2, distance);

        addGraphPath(v1, edge);
        addGraphPath(v2, edge);
    }

    private void addGraphPath(Vertex vertex, Edge edge) {
        if (vertices.containsKey(vertex)) {
            ArrayList<Edge> edges = vertices.get(vertex);
            edges.add(edge);
        } else  {
            ArrayList<Edge> edges = new ArrayList<>();
            edges.add(edge);
            vertices.put(vertex, edges);
        }
    }

    public List<Edge> getNeighbours(Vertex vertex) {
        return vertices.get(vertex);
    }

    public Map<Vertex, ArrayList<Edge>> getGraph() {
        return vertices;
    }

}
