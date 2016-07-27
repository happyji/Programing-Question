package Code;
import java.util.*;
import java.lang.*;


/*
    max(leftDiameter,rightDiameter)
    (leftHeight+rightHeight)+1

 */


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



public class Solution
{
    static int getDiameterUtil(Node node,int[] height,int index)
    {
        if(node == null)
        {
            height[index] = -1;
            return 0;
        }

        int[] heights = new int[2];

        int leftDiameter = getDiameterUtil(node.left,heights,0);
        int rightDiameter = getDiameterUtil(node.right,heights,1);

        int leftHeight = heights[0];
        int rightHeight = heights[1];

        height[index] =  1+ Math.max(heights[0],heights[1]);

        return Math.max(2+leftHeight+rightHeight,Math.max(leftDiameter,rightDiameter));

    }

    static int getDiameter(Node root)
    {
        return getDiameterUtil(root,new int[2],0);
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
        root.right.right = new Node(80);
        root.right.left.left = new Node(55);
        root.right.left.right = new Node(65);


        System.out.println(getDiameter(root));
    }

}







