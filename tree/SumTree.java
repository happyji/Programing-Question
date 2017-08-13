package tree;

/*
    Convert a given Tree to sum tree
 */



public class SumTree {

    public static tree.common.Node root;

    public static int convertSumTree(tree.common.Node p)
    {
        if(p== null) return 0;

        int temp = p.data;
        int left = convertSumTree(p.left);
        int right = convertSumTree(p.right);
        p.data = left+right;

        return temp+p.data;

    }


    public static void InOrder(tree.common.Node p)
    {
        if(p== null) return;

        InOrder(p.left);
        System.out.print(p.data+" ");
        InOrder(p.right);
    }


    public static void main(String args[]){
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

        convertSumTree(root);
        InOrder(root);







    }




}
