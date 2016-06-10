package Code;

import java.util.Stack;

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
    public static Node head= null;
    public static Node prenode = null;

    public static void InOrder(Node p){
        if(p== null) return;

        InOrder(p.left);
        System.out.print(p.data + " ");
        InOrder(p.right);
    }


    public static void convertBSTToDLL(Node p){
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


    public static Node printDLL(Node head){
        Node p = head;
        Node q=null;
        while (p!= null){
            System.out.print(p.data+" ");
            q=p;
            p= p.right;
        }

        return q;
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

        //InOrder(root);
        convertBSTToDLL(root);
        Node p =printDLL(head);
        System.out.println();
        while (p!= null){
            System.out.print(p.data+" ");
            p= p.left;
        }










    }




}
