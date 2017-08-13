package graph.common;

/**
 * Created by prashant on 13/08/17.
 */
public class AdjNode
{
    public int vertexNumber;
    public AdjNode next;

    public AdjNode(int number,AdjNode n)
    {
        vertexNumber = number;
        next =n;
    }
}
