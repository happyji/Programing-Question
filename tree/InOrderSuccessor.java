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

    public static Node getInOrderSuccessor(Node node,int key)
    {
        if(node == null)
            return null;

        if(node.data ==key)
        {
            Node r = node;
            if(r.right == null)
              return null;

            r = r.right;
            while (r.left!= null)
                r= r.left;

            return r;
        }
        else if(key < node.data)
        {
            Node p = getInOrderSuccessor(node.left,key);
            return p!= null? p : node;
        }
        else
        {
            return getInOrderSuccessor(node.right,key);

        }

    }



    public static void main(String args[])
    {
        root = new Node(50);

        root.left = new Node(25);
        root.left.left = new Node(12);
        root.left.right = new Node(30);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(20);

        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        root.right.left.left = new Node(55);
        root.right.left.right = new Node(65);
        System.out.println(getInOrderSuccessor(root,30).data);


    }

}






