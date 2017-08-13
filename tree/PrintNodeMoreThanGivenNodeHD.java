package tree;
import java.util.*;
import java.lang.*;

class PrintNodeMoreThanGivenNodeHD
{

    public static tree.common.Node root;

    public static void printNodes(tree.common.Node key)
    {
        Queue<tree.common.Node> queue = new LinkedList<tree.common.Node>();
        queue.offer(root);

        Queue<Integer> hdQueue = new LinkedList<Integer>();
        hdQueue.offer(0);

        tree.common.Node p = null;
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
        root = new tree.common.Node(1);
        root.left = new tree.common.Node(2);
        root.right = new tree.common.Node(3);

        root.left.left = new tree.common.Node(4);
        root.left.right = new tree.common.Node(5);
        root.left.right.left = new tree.common.Node(9);
        root.left.right.right = new tree.common.Node(10);

        root.right.left = new tree.common.Node(6);
        root.right.right = new tree.common.Node(8);
        root.right.right.right = new tree.common.Node(11);

        printNodes(root.left);

    }

}







