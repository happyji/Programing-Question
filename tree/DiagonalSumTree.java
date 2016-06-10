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
    public static TreeMap<Integer,Integer> map  = new TreeMap<>();

    public static void DiagonalSumTree(Node p,Integer HD)
    {
        if(p== null) return;

        DiagonalSumTree(p.left,HD+1);
        if(map.containsKey(HD)){
            int data = map.get(HD)+p.data;
            map.replace(HD,data);
        }
        else {
            map.put(HD,p.data);
        }
        DiagonalSumTree(p.right,HD);

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

        DiagonalSumTree(root,0);
        Iterator itr = map.entrySet().iterator();



        while (itr.hasNext())    {
            Map.Entry me = (Map.Entry)itr.next();
            System.out.print(me.getValue()+" ");
        }



    }




}
