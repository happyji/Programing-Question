package graph;

import java.io.File;
import java.io.IOException;
import java.util.*;



class BGraph
{
    Vertex[]  vertices;
    Edge[] edges;
    AdjNode[] adjLists;

    BGraph(Scanner sc)
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

    void BFS()
    {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i< vertices.length;i++)
        {
            if(!visited.contains(i))
            {
                queue.add(i);
                visited.add(i);

                while (!queue.isEmpty())
                {
                    int vertexNum = queue.poll();
                    System.out.println(vertices[vertexNum].name);

                    AdjNode node = adjLists[vertexNum];
                    while (node!= null)
                    {
                        if(!visited.contains(node.vertexNumber))
                        {
                            queue.add(node.vertexNumber);
                            visited.add(node.vertexNumber);
                        }
                        node = node.next;
                    }
                }
            }
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



public class BFS
{

    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"/src/input.txt"));
        BGraph BGraph = new BGraph(sc);
        BGraph.BFS();
    }


}
