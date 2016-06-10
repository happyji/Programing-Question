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


    public static void serialize(Node p,StringBuilder sb)
    {
        if(p== null)
        {
           sb.append("# ");
           return;
        }

        sb.append(p.data+" ");
        serialize(p.left, sb);
        serialize(p.right,sb);

    }

    public static String serialize()
    {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }


    public static Node deSerialize(StringTokenizer tokenizer)
    {
       if(!tokenizer.hasMoreElements())
           return null;

       String nodeVal = tokenizer.nextToken();
       if(nodeVal.equals("#"))
           return null;

       Node newNode = new Node(Integer.parseInt(nodeVal));
       newNode.left = deSerialize(tokenizer);
       newNode.right = deSerialize(tokenizer);
       return newNode;
    }


    public static Node deSerialize(String strTree)
    {
        if(strTree== null || strTree.length()== 0) return null;
        StringTokenizer tokenizer = new StringTokenizer(strTree," ");
        return deSerialize(tokenizer);
    }


    public static void inOrder(Node p)
    {
        if(p== null)
            return;

        inOrder(p.left);
        System.out.print(p.data+" ");
        inOrder(p.right);
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

        String strTree = serialize();
        System.out.println(strTree);
        root = null;

        root = deSerialize(strTree);
        System.out.println();
        inOrder(root);



    }




}
