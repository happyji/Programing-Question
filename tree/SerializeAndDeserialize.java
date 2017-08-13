package tree;

import java.util.*;


public class SerializeAndDeserialize {

    public static tree.common.Node root;


    public static void serialize(tree.common.Node p, StringBuilder sb)
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


    public static tree.common.Node deSerialize(StringTokenizer tokenizer)
    {
       if(!tokenizer.hasMoreElements())
           return null;

       String nodeVal = tokenizer.nextToken();
       if(nodeVal.equals("#"))
           return null;

       tree.common.Node newNode = new tree.common.Node(Integer.parseInt(nodeVal));
       newNode.left = deSerialize(tokenizer);
       newNode.right = deSerialize(tokenizer);
       return newNode;
    }


    public static tree.common.Node deSerialize(String strTree)
    {
        if(strTree== null || strTree.length()== 0) return null;
        StringTokenizer tokenizer = new StringTokenizer(strTree," ");
        return deSerialize(tokenizer);
    }


    public static void inOrder(tree.common.Node p)
    {
        if(p== null)
            return;

        inOrder(p.left);
        System.out.print(p.data+" ");
        inOrder(p.right);
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

        String strTree = serialize();
        System.out.println(strTree);
        root = null;

        root = deSerialize(strTree);
        System.out.println();
        inOrder(root);



    }




}
