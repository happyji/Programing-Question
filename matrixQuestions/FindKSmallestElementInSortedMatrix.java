package Code;
import java.util.*;
import java.lang.*;



class Node
{
    int data;
    int x;
    int y;

    public Node(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }
}

class NodeComparator implements Comparator<Node>
{
    @Override
    public int compare(Node x, Node y)
    {
       return x.data - y.data;
    }
}


public class TestClass
{

    static void findKSmallestElement(int [][]mat,int k)
    {
        NodeComparator nodeComparator = new NodeComparator();
        PriorityQueue<Node> heap = new PriorityQueue<Node>(nodeComparator);


        for (int i=0;i< mat.length;i++)
           heap.add(new Node(mat[i][0],i,0));

        int count =0;
        while (!heap.isEmpty())
        {
            Node current = heap.poll();
            int x = current.x;
            int y =current.y;



            if(count==k)
            {
                System.out.println(current.data);
            }
            count++;

            if(y+1<mat.length)
            {
                current.data = mat[x][y+1];
                current.y = y+1;
                heap.add(current);
            }


        }

    }


    public static void main(String args[]) throws Exception
    {
        int arr[][] = { {2,4,6,8},
                        {3,6,9,12},
                        {4,8,12,16},
                        {5,10,15,25}
                      };

        int arr1[] =  {2,3,4,4,5,6,6,8,8,9,10,12,12,15,16,25 }  ;
       // System.out.println(arr1.length);
        findKSmallestElement(arr,4);
    }


}







