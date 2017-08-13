package tree;



public class LCABst {
    public static tree.common.Node root;

    public static tree.common.Node LCABst(tree.common.Node p, int n1, int n2)
    {
        if(p== null) return null;

        if(p.data>n1 && p.data>n2)  return LCABst(p.left,n1,n2);
        if(p.data<n1 && p.data<n2)  return LCABst(p.right,n1,n2);

        return p;
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
        root.right.left.right = new tree.common.Node(85);


        System.out.println(LCABst(root, 80, 65).data);

    }




}
