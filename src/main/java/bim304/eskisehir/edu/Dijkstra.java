package bim304.eskisehir.edu;

import java.util.*;

public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        if (graph == null) {
            throw new NullPointerException("The graph cannot be null.");
        }
        this.graph = graph;
    }
    public Set<Vertex> findShortestPath(int source) {
        Queue<Vertex> queue = new PriorityQueue<>(10, new VertexComparator());

        for (Map.Entry<Vertex, ArrayList<Edge>> entry :  graph.getGraph().entrySet()) {
            Vertex currentVertex = entry.getKey();
            if (currentVertex.getName() == source) {
                currentVertex.setDistance(0);
                queue.add(currentVertex);
            }
        }

        final Set<Vertex> vertexHashSet = new HashSet<>();

        while (!queue.isEmpty()) {
            Vertex src = queue.poll(); // retrieve and remove
            if (!vertexHashSet.contains(src)){
                vertexHashSet.add(src);

                for (Edge edge : graph.getNeighbours(src)) {
                    Vertex currentVertex = edge.getAdjacentVertex(src); // neighbour vertex

                    if (!vertexHashSet.contains(currentVertex)) {
                        int newDistance = src.getDistance() + edge.getDistance();
                        if (newDistance < currentVertex.getDistance()) {
                            currentVertex.setDistance(newDistance);
                            queue.add(currentVertex);
                        }
                    }
                }
            }
        }

        return vertexHashSet;
    }


}
