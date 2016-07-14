package Code;
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node left;
    Node right;


    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution
{

    public static Node root;

    public static void printNodes(Node key)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        Queue<Integer> hdQueue = new LinkedList<Integer>();
        hdQueue.offer(0);

        Node p = null;
        int hd = 0;

        boolean isKeyNodeFound = false;
        Integer keyHD = Integer.MIN_VALUE;
        Integer keyLEVEL = Integer.MIN_VALUE;

        while(!queue.isEmpty())
        {
            p = queue.poll();
            hd = hdQueue.poll();

            if(p.data == key.data)
            {
                isKeyNodeFound  = true;
                keyHD = hd;
                //System.out.println(hd);

            }

            if(hd > keyHD && keyHD!= Integer.MIN_VALUE)
            {
                System.out.println(p.data);
            }


            if(p.left!= null)
            {
                queue.offer(p.left);
                hdQueue.offer(hd-1);
            }

            if(p.right!= null)
            {
                queue.offer(p.right);
                hdQueue.offer(hd+1);
            }
        }
    }

    public static void main(String args[])
    {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);

        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.right = new Node(11);

        printNodes(root.left);

    }

}







