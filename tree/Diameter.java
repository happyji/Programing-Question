package tree;
import java.lang.*;


/*
    max(leftDiameter,rightDiameter)
    (leftHeight+rightHeight)+1

 */

public class Diameter
{
    static int getDiameterUtil(tree.common.Node node, int[] height, int index)
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

    static int getDiameter(tree.common.Node root)
    {
        return getDiameterUtil(root,new int[2],0);
    }


    public static void main(String args[])
    {
        tree.common.Node root;
        root = new tree.common.Node(50);

        root.left = new tree.common.Node(25);
        root.left.left = new tree.common.Node(12);
        root.left.right = new tree.common.Node(30);
        root.left.left.left = new tree.common.Node(7);
        root.left.left.right = new tree.common.Node(20);

        root.right = new tree.common.Node(70);
        root.right.left = new tree.common.Node(60);
        root.right.right = new tree.common.Node(80);
        root.right.left.left = new tree.common.Node(55);
        root.right.left.right = new tree.common.Node(65);


        System.out.println(getDiameter(root));
    }

}







