package Code;

/*
    - vertical traversal
    - diagoanal traversal
 */


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
    public  static TreeMap<Integer,ArrayList<Node>> map = new TreeMap<>();
    public static  TreeMap<Integer,ArrayList<Node>> map2 = new TreeMap<>();

    public static void verticalOrderTraversal(Node p,int HD){
        if(p == null) return;
        ArrayList<Node> nodeList;

        if(map.containsKey(HD)){
            nodeList = map.get(HD);
            nodeList.add(p);
        }
        else {
            nodeList = new ArrayList<>();
            nodeList.add(p);
            map.put(HD,nodeList);
        }

        verticalOrderTraversal(p.left,HD-1);
        verticalOrderTraversal(p.right,HD+1);

    }

    public static void dialogonalTraversal(Node p,int DCount){
        if(p == null) return;
        ArrayList<Node> nodeList;

        if(map2.containsKey(DCount)){
            nodeList = map2.get(DCount);
            nodeList.add(p);
        }
        else {
           nodeList = new ArrayList<Node>();
            nodeList.add(p);
            map2.put(DCount,nodeList);
        }

        dialogonalTraversal(p.left,DCount+1);
        dialogonalTraversal(p.right,DCount);
    }

    public static void printArray(List<Node> list){
        Iterator<Node> itr = list.iterator();
        System.out.println();
        while (itr.hasNext())
            System.out.print(itr.next().data+" ");

    }

    public static void printMap(TreeMap<Integer,ArrayList<Node>> map){
        Set<Integer> keys = map.keySet();
        for(Integer key : keys){
            printArray(map.get(key));
        }
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


        System.out.println("Vertical Order Traversal : ");
        verticalOrderTraversal(root,0);
        printMap(map);


        System.out.println("Vertical Order Traversal : ");
        dialogonalTraversal(root,1);
        printMap(map2);



    }




}
