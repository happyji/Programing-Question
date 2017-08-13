package tree;
import java.util.*;
import java.lang.*;

/*
                      50
               25           70
          12      30     60     80
        7   20         55  65

 */


public class PrintCousin
{


    static void printCousin(tree.common.Node root, tree.common.Node target)
    {
        Queue<tree.common.Node> queue = new LinkedList<>();
        Queue<Integer> lqueue = new LinkedList<>();
        queue.add(root);
        lqueue.add(0);
        int defaultLevel=-1;
        tree.common.Node sibling = null;

        while (!queue.isEmpty())
        {
            tree.common.Node node = queue.poll();
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
        tree.common.Node root;
        root = new tree.common.Node(50);

        root.left = new tree.common.Node(25);
        root.left.left = new tree.common.Node(12);



        root.left.right = new tree.common.Node(30);
        root.left.left.left = new tree.common.Node(7);
        root.left.left.right = new tree.common.Node(20);

        root.right = new tree.common.Node(70);
        root.right.left = new tree.common.Node(60);

        tree.common.Node p = root.right.left;//this node

        root.right.right = new tree.common.Node(80);
        root.right.left.left = new tree.common.Node(55);
        root.right.left.right = new tree.common.Node(65);

        printCousin(root,p);

    }

}







