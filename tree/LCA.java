package tree;




public class LCA {
    public static tree.common.Node root;

    public static tree.common.Node LCA(tree.common.Node p, int n1, int n2)
    {
        if(p== null) return null;

        if(p.data == n1 || p.data == n2) return p;

        tree.common.Node lcaLeft =LCA(p.left,n1,n2);
        tree.common.Node lcaRight =LCA(p.right,n1,n2);

        if(lcaLeft!= null && lcaRight!= null) return p;

        return  (lcaLeft!= null) ? lcaLeft : lcaRight;
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


        System.out.println(LCA(root, 65, 80).data);

    }




}
