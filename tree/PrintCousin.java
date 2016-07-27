package Code;
import java.util.*;
import java.lang.*;




class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

/*
                      50
               25           70
          12      30     60     80
        7   20         55  65

 */


public class Solution
{


    static void printCousin(Node root,Node target)
    {
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> lqueue = new LinkedList<>();
        queue.add(root);
        lqueue.add(0);
        int defaultLevel=-1;
        Node sibling = null;

        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            int level = lqueue.poll();

            if(defaultLevel != -1)
            {
                 if(level == defaultLevel && node != sibling && node!= target)
                 {
                     System.out.println(node.data);
                 }

                 if(level > defaultLevel)
                     break;
            }



            if(node.left != null )
            {
                if(node.left == target)
                {
                    defaultLevel = level+1;
                    sibling = node.right;
                }
                queue.add(node.left);
                lqueue.add(level+1);
            }

            if(node.right != null )
            {
                if(node.right == target)
                {
                    defaultLevel = level+1;
                    sibling = node.left;
                }
                queue.add(node.right);
                lqueue.add(level+1);
            }
        }


    }


    public static void main(String args[])
    {
        Node root;
        root = new Node(50);

        root.left = new Node(25);
        root.left.left = new Node(12);



        root.left.right = new Node(30);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(20);

        root.right = new Node(70);
        root.right.left = new Node(60);

        Node p = root.right.left;//this node

        root.right.right = new Node(80);
        root.right.left.left = new Node(55);
        root.right.left.right = new Node(65);

        printCousin(root,p);

    }

}







