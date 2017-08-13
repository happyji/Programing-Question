package tree;
import java.lang.*;


/*
    max(leftDiameter,rightDiameter)
    (leftHeight+rightHeight)+1

 */


public class PrintAtKDistance
{
    static void printAtKDistanceDown(tree.common.Node node, int k)
    {
        if(node == null || k<0)
            return;

        if(k==0)
        {
            System.out.println(node.data);
        }

        printAtKDistanceDown(node.left,k-1);
        printAtKDistanceDown(node.right,k-1);
    }

    int printkdistanceNode(tree.common.Node node, tree.common.Node target, int k)
    {
        // Base Case 1: If tree is empty, return -1
        if (node == null)
            return -1;

        // If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if (node == target)
        {
            printAtKDistanceDown(node, k);
            return 0;
        }

        // Recur for left subtree
        int dl = printkdistanceNode(node.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1)
        {

            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from
            // target
            if (dl + 1 == k)
            {
                System.out.print(node.data);
                System.out.println("");
            }

            // Else go to right subtree and print all k-dl-2 distant nodes
            // Note that the right child is 2 edges away from left child
            else
                printAtKDistanceDown(node.right, k - dl - 2);

            // Add 1 to the distance and return value for parent calls
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left
        // subtree
        int dr = printkdistanceNode(node.right, target, k);
        if (dr != -1)
        {
            if (dr + 1 == k)
            {
                System.out.print(node.data);
                System.out.println("");
            }
            else
                printAtKDistanceDown(node.left, k - dr - 2);
            return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
    }

    static int printAtKDistance(tree.common.Node node, tree.common.Node target, int k)
    {
        if(node == null)
            return -1;

        if (node == target)
        {
            printAtKDistanceDown(node,k);
            return 0;
        }

        int dl = printAtKDistance(node.left,target,k);
        if (dl!=-1)
        {
            if(dl+1 == k)
                System.out.println(node.data);
            else
                printAtKDistanceDown(node.right,k-dl-2);

            return dl+1;
        }
        int dr = printAtKDistance(node.right,target,k);
        if (dr!=-1)
        {
            if(dr+1 == k)
                System.out.println(node.data);
            else
                printAtKDistanceDown(node.left,k-dr-2);

            return dr+1;
        }

        return -1;
    }


    public static void main(String args[])
    {
        tree.common.Node root;
        root = new tree.common.Node(50);

        root.left = new tree.common.Node(25);
        tree.common.Node p = root.left;//this node
        root.left.left = new tree.common.Node(12);
        root.left.right = new tree.common.Node(30);
        root.left.left.left = new tree.common.Node(7);
        root.left.left.right = new tree.common.Node(20);

        root.right = new tree.common.Node(70);
        root.right.left = new tree.common.Node(60);
        root.right.right = new tree.common.Node(80);
        root.right.left.left = new tree.common.Node(55);
        root.right.left.right = new tree.common.Node(65);

        printAtKDistance(root,p,2);

    }

}







