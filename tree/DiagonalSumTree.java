package tree;
import java.util.*;



public class DiagonalSumTree {

    public static tree.common.Node root;
    public static TreeMap<Integer,Integer> map  = new TreeMap<>();

    public static void DiagonalSumTree(tree.common.Node p, Integer HD)
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

        DiagonalSumTree(root,0);
        Iterator itr = map.entrySet().iterator();



        while (itr.hasNext())    {
            Map.Entry me = (Map.Entry)itr.next();
            System.out.print(me.getValue()+" ");
        }



    }




}
