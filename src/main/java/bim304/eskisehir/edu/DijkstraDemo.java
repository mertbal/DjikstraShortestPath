package bim304.eskisehir.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DijkstraDemo {

    public static Graph buildGraph(String path){
        Graph graph = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null){
                String[] tokens = line.split("\\s+");
                if (tokens.length == 1){
                    graph = new Graph(parseInt(tokens[0]));
                }else{
                    graph.addEdge(new Vertex(parseInt(tokens[0])),new Vertex(parseInt(tokens[1])),parseInt(tokens[2]));
                }
            }

            br.close();
        }catch(IOException e){
            System.err.println("Please make sure that your file exists in appropriate directory!");
            System.exit(-1);
        }
        return graph;
    }

    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of input file: ");
        String path = scanner.nextLine();

        Graph graph = buildGraph(path);
        Iterator iterator = graph.getGraph().keySet().iterator();
        HashMap<Integer,Integer> totalCosts = new HashMap<>();

        while (iterator.hasNext()){
            int key = ((Vertex) iterator.next()).getName();
            graph = buildGraph(path);
            Dijkstra dijkstra = new Dijkstra(graph);
            Set<Vertex> paths = dijkstra.findShortestPath(key);
            Iterator<Vertex> itr = paths.iterator();
            int total = 0;
            while (itr.hasNext()) {
                total+=itr.next().getDistance();
            }
            totalCosts.put(key,total);
        }

        Iterator keyIterator = totalCosts.keySet().iterator();
        int minCost = Integer.MAX_VALUE;
        int headquarter = -1;
        while (keyIterator.hasNext()){
            int key = (Integer) keyIterator.next();
            int value = totalCosts.get(key);
            if (value<minCost){
                minCost = value;
                headquarter = key;
            }
        }

        System.out.println("The optimal city is "+headquarter+"(cost:"+minCost+") to install headquarters!");
    }
}
