package Code;
import java.util.*;

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

    public static Node LCABst(Node p,int n1,int n2)
    {
        if(p== null) return null;

        if(p.data>n1 && p.data>n2)  return LCABst(p.left,n1,n2);
        if(p.data<n1 && p.data<n2)  return LCABst(p.right,n1,n2);

        return p;
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
        root.right.left.right = new Node(85);


        System.out.println(LCABst(root, 80, 65).data);

    }




}
