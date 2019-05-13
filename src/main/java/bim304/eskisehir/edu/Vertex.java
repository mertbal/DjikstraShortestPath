package bim304.eskisehir.edu;

import java.util.LinkedHashMap;

public class Vertex{
    private int name;
    private int distance = Integer.MAX_VALUE;
    private LinkedHashMap<Vertex,Integer> neighbourVertices;

    public Vertex(int name) {
        this.name = name;
        this.neighbourVertices = new LinkedHashMap<>();
    }


    public int getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        return this.name == ((Vertex)o).getName();
    }

    @Override
    public int hashCode() {
        return name;
    }
}
