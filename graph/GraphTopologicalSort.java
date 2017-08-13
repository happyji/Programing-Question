package graph;

import java.io.File;
import java.io.IOException;
import java.util.*;

class class AdjNode
{
    int vertexNumber;
    AdjNode next;

    AdjNode(int number,AdjNode n)
    {
        vertexNumber = number;
        next =n;
    }
}
class Vertex
{
    String name;

    Vertex(String n)
    {
        name = n;
    }
}

class Edge
{
    int src;
    int dest;
    Integer weight;
    Edge(int s,int d,Integer w)
    {
        src = s;
        dest =d;
        weight =w;
    }
}

class Graph
{
    Vertex[]  vertices;
    Edge[] edges;
    AdjNode[] adjLists;

    Graph(Scanner sc)
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
        Graph graph = new Graph(sc);
        Stack<Integer> stack = graph.topologicalSort();

        while (!stack.isEmpty())
        {
            System.out.print(graph.vertices[stack.pop()].name+" ");
        }

    }


}
