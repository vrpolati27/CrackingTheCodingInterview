package graphs;

import java.util.Scanner;

/**
 * Created by vinayreddypolati on 7/15/17.
 */
public class GraphDriver {
    public static void main(String[] args){
        System.out.println("Enter File name for which you want to create a Graph");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        if(fileName.equalsIgnoreCase("friendship.txt")){
            exploreFriemdship();
        }else if(fileName.equalsIgnoreCase("website.txt")){
            exploreWebsite();
        }else if(fileName.equalsIgnoreCase("dijkstras.txt")){
            _dijkstras(fileName);
        }else{
            if(fileName.equalsIgnoreCase("dijkstras2.txt")){
                Dijkstras dj = new Dijkstras("E",fileName);
                dj.printPath("H");
            }else
            System.out.println("No such File exists in your Folder");
        }
        sc.close();
    }


    private static void _dijkstras(String filename){
        Dijkstras dj = new Dijkstras("Hyderabad(A)",filename);
        dj.printPath("Mumbai(D)");
    }

    private static void newLine(String str){
        //System.out.println();
        for(int c1=0;c1<40;c1++){
            System.out.print(str);
        }System.out.println();
    }

    private static void exploreFriemdship(){
        Graph friendshipGraph = new Graph("friendship.txt");
        System.out.println("Jane is Friends with: "+friendshipGraph.getNeighbors("Jane"));
        newLine("-");
        friendshipGraph.printGraph();
        newLine("-");
        System.out.print("DepthFirstSearch order: ");
        friendshipGraph.depthFirstSearch();
        /*newLine("-");*/
        System.out.println();
        System.out.print("BreadthFirstSearch order: ");
        friendshipGraph.breadthFirstSearch();
    }

    private static void exploreWebsite(){
        Graph website = new Graph("website.txt");
        System.out.println("pageA has links to: "+website.getNeighbors("pageA"));
        newLine("-");
        website.printGraph();
        newLine("/*");
        System.out.println("DepthFirstSearch order");
        website.depthFirstSearch();
        System.out.println();
        System.out.print("BreadthFirstSearch order: ");
        website.breadthFirstSearch();
    }
}
