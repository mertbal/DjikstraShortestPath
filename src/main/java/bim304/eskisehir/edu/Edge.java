package bim304.eskisehir.edu;

public class Edge { // vertex-distance pairs
    private Vertex v1, v2;
    private int distance;

    public Edge (Vertex v1, Vertex v2, int distance) {
        this.v1 = v1;
        this.v2 = v2;
        this.distance = distance;
    }

    public Vertex getAdjacentVertex (Vertex node) {
        return node.getName() != v1.getName() ? v1 : v2;
    }

    public int getDistance() {
        return distance;
    }
}