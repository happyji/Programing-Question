package graph;

import graph.common.AdjNode;
import graph.common.Edge;
import graph.common.Vertex;

import java.io.File;
import java.io.IOException;
import java.util.*;

class TGraph
{
    Vertex[]  vertices;
    Edge[] edges;
    AdjNode[] adjLists;

    TGraph(Scanner sc)
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

    public Stack<Integer> topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();


        for(int i=0;i< vertices.length;i++)
        {
            if(!visited.contains(i))
            {
                sortUtil(i,stack,visited);
            }

        }

        return stack;
    }


    public void sortUtil(Integer vertexNum,Stack<Integer> stack,Set<Integer> visited)
    {
        visited.add(vertexNum);

        AdjNode node = adjLists[vertexNum];
        while (node!= null)
        {
            if(!visited.contains(node.vertexNumber))
            {
                sortUtil(node.vertexNumber,stack,visited);
            }
            node= node.next;
        }
        stack.add(vertexNum);
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



class GraphTopologicalSort
{

    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/input.txt"));
        TGraph tGraph = new TGraph(sc);
        Stack<Integer> stack = tGraph.topologicalSort();

        while (!stack.isEmpty())
        {
            System.out.print(tGraph.vertices[stack.pop()].name+" ");
        }

    }


}
