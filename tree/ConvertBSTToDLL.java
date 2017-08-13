package tree;



public class ConvertBSTToDLL {

    public static tree.common.Node root;
    public static tree.common.Node head= null;
    public static tree.common.Node prenode = null;

    public static void InOrder(tree.common.Node p){
        if(p== null) return;

        InOrder(p.left);
        System.out.print(p.data + " ");
        InOrder(p.right);
    }


    public static void convertBSTToDLL(tree.common.Node p){
        if(p== null) return;

        convertBSTToDLL(p.left);
        if(prenode == null)
        {
            p.left = null;
            head = p;
            prenode = p;
        }
        else
        {
            prenode.right = p;
            p.left = prenode;
            prenode = p;
        }

        convertBSTToDLL(p.right);
    }


    public static tree.common.Node printDLL(tree.common.Node head){
        tree.common.Node p = head;
        tree.common.Node q=null;
        while (p!= null){
            System.out.print(p.data+" ");
            q=p;
            p= p.right;
        }

        return q;
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

        //InOrder(root);
        convertBSTToDLL(root);
        tree.common.Node p =printDLL(head);
        System.out.println();
        while (p!= null){
            System.out.print(p.data+" ");
            p= p.left;
        }










    }




}
