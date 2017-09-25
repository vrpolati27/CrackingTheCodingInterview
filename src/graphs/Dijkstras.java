package graphs;

import datastructure.PriorityHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vinayreddypolati on 7/28/17.
 */
public class Dijkstras {
    private Graph graph;
    private String source;
    Map<String,PathNDistance> path;
    List<String> nodes;

    public Dijkstras(String source,String filename){
        this.source = source;
        graph = new Graph(filename);
        nodes = graph.getAllNodes();
        path = new HashMap<>(nodes.size());
        for(String node:nodes){
           PathNDistance mn = new PathNDistance();
           path.put(node,mn);
           if(node.equalsIgnoreCase(source))
               mn.distance = 0;
        }
        runDijkstras();
    }

    private void runDijkstras(){
        PriorityHeap<String> minPriorityHeap = new PriorityHeap<>();
        minPriorityHeap.makeHeap(graph.getAllNodes(),source);
        while(!minPriorityHeap.isEmpty()){
            String c1 = minPriorityHeap.deleteMin();
            /*System.out.println(c1);*/
            int distanceToC1 = path.get(c1).distance;
            if(graph.getNeighbors(c1)!=null)
            for(GraphNode2 c2:graph.getNeighbors(c1)){
               if(path.get(c2.name).distance>(distanceToC1+c2.weight)){
                   PathNDistance c3 = new PathNDistance();
                   c3.preNode = c1;
                   c3.distance = distanceToC1+c2.weight;
                   path.put(c2.name,c3);
                   minPriorityHeap.updatePriority(c2.name,c3.distance);
               }
            }
        }
    }

    public void printPath(String destination){
        List<String> revPath = new ArrayList<>();
        String c = destination;
        while(!c.equalsIgnoreCase(source)){
            revPath.add(c);
            c = path.get(c).preNode;
        } revPath.add(source);
        System.out.print("{ ");
        if(revPath.size()>0){
            for(int c1=revPath.size()-1;c1>0;c1--){
                System.out.print(revPath.get(c1)+"-->");
            }
            System.out.print(revPath.get(0));
        }
        System.out.print(" } and \n distance:" + path.get(destination).distance);
        /*for(Map.Entry<String,PathNDistance> en:path.entrySet()){
            System.out.println(en.getKey()+", previous."+en.getValue().preNode+", distance:"+
                    en.getValue().distance);
        }*/
    }
}

class PathNDistance{
    String preNode;
    int distance;

    public PathNDistance(){
        distance = Integer.MAX_VALUE;
        preNode = new String();
    }
}
