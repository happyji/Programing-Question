package Code;

/*
    Convert a given Tree to sum tree
 */



class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}





public class Solution {

    public static Node root;

    public static int convertSumTree(Node p)
    {
        if(p== null) return 0;

        int temp = p.data;
        int left = convertSumTree(p.left);
        int right = convertSumTree(p.right);
        p.data = left+right;

        return temp+p.data;

    }


    public static void InOrder(Node p)
    {
        if(p== null) return;

        InOrder(p.left);
        System.out.print(p.data+" ");
        InOrder(p.right);
    }


    public static void main(String args[]){
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

        convertSumTree(root);
        InOrder(root);







    }




}
