package graph;
import graph.common.AdjNode;
import graph.common.Edge;
import graph.common.Vertex;

import java.io.File;
import java.io.IOException;
import java.util.*;



class DGraph
{
    Vertex[]  vertices;
    Edge[] edges;
    AdjNode[] adjLists;

    DGraph(Scanner sc)
    {
        vertices = new  Vertex[sc.nextInt()];
        adjLists = new AdjNode[vertices.length];
        edges = new Edge[sc.nextInt()];
        scanVertex(sc);
        scanRelationShips(sc);
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Edge[] getEdges() {
        return edges;
    }


    public AdjNode[] getAdjLists() {
        return adjLists;
    }

    void DFS()
    {
        Set<Integer> visited = new HashSet<>();

        for (int i=0;i< vertices.length;i++)
        {
            if(!visited.contains(i))
            {
                DFSUtil(i,visited);
            }
        }
    }

    private void DFSUtil(int key ,Set<Integer> visited)
    {
        System.out.print(vertices[key].name+" ");
        visited.add(key);

        AdjNode node = adjLists[key];
        while (node != null)
        {
            if(!visited.contains(node.vertexNumber))
                DFSUtil(node.vertexNumber,visited);

            node = node.next;
        }
    }



    private void scanVertex(Scanner sc)
    {
        for (int i=0; i< adjLists.length;i++)
        {
            vertices[i] = new Vertex(sc.next());
        }
    }

    private void scanRelationShips(Scanner sc)
    {
        for(int i=0;i< edges.length;i++)
        {
            int source = indexForName(sc.next());
            int dest = indexForName(sc.next());
            Integer weight = sc.nextInt();
            edges[i] = new Edge(source,dest,weight);

            adjLists[source] = new AdjNode(dest,adjLists[source]) ;

        }

    }

    private int indexForName(String name) {
        for (int v=0; v < vertices.length; v++) {
            if (vertices[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }

}
/*
5 6
PageA
PageB
PageC
PageD
PageE
PageA PageB 20
PageB PageC 10
PageC PageA 50
PageC PageE 30
PageA PageD 10
PageD PageC 30

*/


public class DFS
{

    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/input.txt"));
        DGraph graph = new DGraph(sc);
        graph.DFS();
    }


}
