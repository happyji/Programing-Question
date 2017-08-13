package tree;
import java.lang.*;


class InOrderSuccessor
{

    public static tree.common.Node root;

    public static tree.common.Node getInOrderSuccessor(tree.common.Node node, int key)
    {
        if(node == null)
            return null;

        if(node.data ==key)
        {
            tree.common.Node r = node;
            if(r.right == null)
              return null;

            r = r.right;
            while (r.left!= null)
                r= r.left;

            return r;
        }
        else if(key < node.data)
        {
            tree.common.Node p = getInOrderSuccessor(node.left,key);
            return p!= null? p : node;
        }
        else
        {
            return getInOrderSuccessor(node.right,key);

        }

    }



    public static void main(String args[])
    {
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
        System.out.println(getInOrderSuccessor(root,30).data);


    }

}







